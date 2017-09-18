
'use strict';
homeLog('in home.js')
let homeTable;
let shouldAddListeners = true;
let shouldAlert = true;
let searchFilter = '';

$(document).ready(function () {
	'use strict';
	homeLog('document ready');

	$('#requestSubmit').on('click', submitRequest);
	$('#requestWithdraw').on('click', withdrawRequest);
	$('#requestApprove').on('click', approveRequest);
	$('#requestDeny').on('click', denyRequest);
	$('.modalCancel').on('click', function () { $('.requestInput').val(null) });

	loadNavbar();
	loadHome();
});

function submitRequest() {
	'use strict';
	homeLog('in submitRequest');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'submitrequest', true);

	let amount = parseFloat($('#amount').val()).toFixed(2);
	let description = $('#description').val().trim();

	homeLog('amount= '+amount+', description= '+description);

	if (!amount || amount < 1 || !description) {

		homeLog('bad request input');
		$('#message').show();
		return;
	}

	let data = JSON.stringify([amount, description]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			$('#requestModal').modal('hide');

			if (xhr.status === 200) {
				showResultModal(xhr.responseText);
			}
			$('.requestInput').val(null);
		}		
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function withdrawRequest() {
	'use strict';
	homeLog('in withdrawRequest');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'withdrawrequest', true);

	let requestId = $('#requestId').val();

	let data = JSON.stringify([requestId]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			$('#withdrawModal').modal('hide');

			if (xhr.status === 200) {
				showResultModal(xhr.responseText);
			}
		}		
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function approveRequest() { resolveRequest('approve'); }
function denyRequest() { resolveRequest('deny'); }

function resolveRequest(status) {
	'use strict';
	homeLog('in resolveRequest: '+status);

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'resolverequest', true);

	let requestId = $('#requestId').val();
	let reason = $('#reason').val().trim();
	let data = JSON.stringify([requestId, reason, status]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			$('#resolveModal').modal('hide');

			if (xhr.status === 200) {
				showResultModal(xhr.responseText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function loadHome() {
	'use strict';
	homeLog('in loadHome');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'gethome', true);

	let showEmployees = $('#showEmployees').prop('checked');
	let data = JSON.stringify([showEmployees]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#view').html(xhr.responseText);

			homeTable = $('#homeTable').DataTable({ 'paging':false, 'scrollY':420, 'lengthChange':false, 'info':false });

			$('input[type="search"]').on('keyup', function () {
				searchFilter = $(this).val();
				homeTable.search(searchFilter).draw();
			});			
			loadTable();
			if (shouldAddListeners) {
				addListeners();
				shouldAddListeners = false;
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function loadTable() {
	'use strict';
	homeLog('in loadTable');
	homeTable.off('click').clear();
	homeTable.search(searchFilter);

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'gettable', true);

	let getPending = $('#choosePending').prop('checked');	
	let getApproved = $('#chooseApproved').prop('checked');	
	let getDenied = $('#chooseDenied').prop('checked');
	let showEmployees = $('#showEmployees').prop('checked');

	let data = JSON.stringify([getPending, getApproved, getDenied, showEmployees])

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			let dto = JSON.parse(xhr.responseText);
			let user = dto.user;
			let rows = dto.list;

			$.each(rows, function (index) {
				let moreInfo = this.status === 'Pending' ? null : 'more info';

				if (!user.manager) {
					let row = homeTable.row.add([
						this.requestId,
						formatDate(new Date(this.submitDate)),
						parseFloat(this.amount).formatMoney(),
						this.status,
						this.description,
						moreInfo,
						this.resolverName,
						this.resolveDate,
						this.notes
						]);

				} else {
					if (showEmployees) {
						homeTable.row.add([
							na(this.userId),
							na(this.firstName),
							na(this.lastName),
							na(this.email),
							this.manager ? 'Yes' : 'No',
									]);
					}
					else {
						homeTable.row.add([
							na(this.requestId),
							na(this.name),
							na(formatDate(new Date(this.submitDate))),
							na(parseFloat(this.amount).formatMoney()),
							na(this.status),
							na(this.description),
							moreInfo,
							this.resolverName,
							this.resolveDate,
							this.notes
							]);
					}
				}
			});

			homeTable.on('click', 'td:last-child', function () {
				if ($(this).text() === 'more info') {
					log('clicked the last column data');
					let data = homeTable.row(this).data();

					$('#id').text(data[0]);
					$('#desc').text(data[data.length-5]);
					$('#res').text(data[data.length-3]);
					$('#resDate').text(formatDate(new Date(data[data.length-2])));
					$('#resNote').text(data[data.length-1]);

					$('#moreInfoModal').modal('show');
				}
			});
			homeTable.on('click', 'tr', function () {
				let data = homeTable.row(this).data();
				if (!data) return;
				homeLog('clicked row '+data[0]);
				$('#requestId').val(data[0]);
				log('(after) requestId= '+$('#requestId').val());
				homeLog('requestId= '+$('#requestId').val());

				if (user.manager) {
					if (showEmployees) {
						homeLog('manager employee list click');
						$('#showEmployees').prop('checked', false).change();
						let first = data[1];
						let last = data[2];
						searchFilter = first+' '+last;
					}
					else {
						homeLog('manager request click');
						if (data[4] === 'Pending') {
							$('#resolveModal').modal('show');
						}
						$('#requestNum').text(data[0]);
					}
				} else {
					homeLog('employee request click');
					if (data[3] === 'Pending') {
						$('#expense').text(data[2]);
						$('#date').text(data[1]);
						$('#withdrawDescription').text(data[4]);
						$('#withdrawModal').modal('show');
					}
					$('#requestId').val(data[4]);
				}
			});
			homeTable.draw();
			homeTable.rows().every(function () {
				if ('Pending' === this.data()[this.data().length-6] || (user.manager && showEmployees)) {
					$(this.node()).addClass('clickable');
				}
			}).draw();
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function showMoreInfo() {

}

function na(val) {
	return val ? val : 'n/a';
}

Number.prototype.formatMoney = function(places, symbol, thousand, decimal) {
	places = !isNaN(places = Math.abs(places)) ? places : 2;
	symbol = symbol !== undefined ? symbol : "$";
	thousand = thousand || ",";
	decimal = decimal || ".";
	var number = this, 
	negative = number < 0 ? "-" : "",
			i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
			j = (j = i.length) > 3 ? j % 3 : 0;
			return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
};

function formatDate(date) {
	'use strict';
	if (date.getTime() === new Date(0).getTime()) return null;
	let amPM = date.getHours() < 12 ? 'am' : 'pm';
	let hours = date.getHours()%12 == 0 ? 12 : date.getHours()%12;
	return date.getMonth()+'/'+
	date.getDate()+'/'+
	(''+date.getFullYear()).slice(-2)+' '+
	hours+':'+
	('0'+date.getMinutes()).slice(-2)+' '+
	amPM;
}

function addListeners() {
	'use strict';
	homeLog('in addListeners');

	let all = $('#chooseAll');
	let pending = $('#choosePending');
	let approved = $('#chooseApproved');
	let denied = $('#chooseDenied');
	let showEmployees = $('#showEmployees');

	showEmployees.on('change', function () {
		homeLog('showEmployees box changed');
		searchFilter = '';
		loadHome();
	});
	all.on('change', function () {
		homeLog('all box changed');
		pending.prop('checked', all.prop('checked'));
		approved.prop('checked', all.prop('checked'));
		denied.prop('checked', all.prop('checked'));
		loadTable();
	});	
	pending.on('change', function () {
		homeLog('pending box changed');
		if (pending.prop('checked')) {
			if (approved.prop('checked') && denied.prop('checked')) {
				all.prop('checked', true);
			}
		}
		else {
			all.prop('checked', false);
		}
		loadTable();
	});
	approved.on('change', function () {
		homeLog('approved box changed');
		if (approved.prop('checked')) {
			if (pending.prop('checked') && denied.prop('checked')) {
				all.prop('checked', true);
			}
		}
		else {
			all.prop('checked', false);
		}
		loadTable();
	});	
	denied.on('change', function () {
		homeLog('approved box changed');
		if (denied.prop('checked')) {
			if (pending.prop('checked') && approved.prop('checked')) {
				all.prop('checked', true);
			}
		}
		else {
			all.prop('checked', false);
		}
		loadTable();
	});	
}

function showResultModal(message) {
	$('#result').html(message);
	$('#resultModal').modal('show');
	loadTable();
}

function homeLog(message) {
	'use strict';
	console.log('home.js -- '+message);
}
