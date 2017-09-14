
'use strict';
log('in home.js')
let homeTable;
let shouldAddListeners = true;
let lastMove = new Date();
let shouldAlert = true;
let searchFilter = '';

$(document).ready(function () {
	'use strict';
	log('document ready');

	$('body').on('mouseover', function () {
		if ((new Date()).getTime() - lastMove.getTime() > 10*60*1000) {
			if (shouldAlert) {
				alert('You\'ve been logged out due to inactivity... sorry');
				shouldAlert = !shouldAlert
				location.href = 'logout';
			}
		} else {
			lastMove = new Date();
		}
	});

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
	log('in submitRequest');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'submitrequest', true);

	let amount = parseFloat($('#amount').val()).toFixed(2);
	let description = $('#description').val().trim();

	log('amount= '+amount+', description= '+description);

	if (!amount || amount < 1 || !description) {

		log('bad request input');
		$('#message').show();
		return;
	}

	let data = JSON.stringify([amount, description]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {

				$('#requestModal').modal('hide');

				$('#result').html(xhr.responseText);
				$('#resultModal').modal('show');
				loadTable();
			}
			$('.requestInput').val(null);
		}		
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function withdrawRequest() {
	'use strict';
	log('in withdrawRequest');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'withdrawrequest', true);

	let requestId = $('#requestId').val();

	let data = JSON.stringify([requestId]);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {

				$('#withdrawModal').modal('hide');

				$('#result').html(xhr.responseText);
				$('#resultModal').modal('show');
				loadTable();
			}
		}		
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function approveRequest() {
	
}

function denyRequest() {
	
}

function loadHome() {
	'use strict';
	log('in loadHome');

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
	log('in loadTable');
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

			$.each(rows, function () {

				if (!user.manager) {
					homeTable.row.add([
						this.requestId,
						formatDate(new Date(this.submitDate)),
						parseFloat(this.amount).formatMoney(),
						this.status,
						this.description,
						null
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
							na(this.submitterId),
							na(formatDate(new Date(this.submitDate))),
							na(parseFloat(this.amount).formatMoney()),
							na(this.status),
							na(this.description),
							na(formatDate(new Date(this.resolveDate))),
							na(this.resolverId),
							null
							]);
					}
				}
			});
			homeTable.on('click', 'tr', function () {
				let data = homeTable.row(this).data();
				if (!data) return;
				log('clicked row '+data[0]);
				
				if (user.manager) {
					if (showEmployees) {
						log('manager employee list click');
						$('#showEmployees').prop('checked', false).change();
						let first = data[1];
						let last = data[2];
						searchFilter = first+' '+last;
					}
					else {
						log('manager request click');
						$('#resolveModal').modal('show');
					}
				} else {
					log('employee request click');
					$('#expense').text(data[2]);
					$('#date').text(data[1]);
					$('#requestId').val(data[0]);
					$('#withdrawModal').modal('show');
				}
			});
			homeTable.draw();
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
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
	date.getDay()+'/'+
	(''+date.getFullYear()).slice(-2)+' '+
	hours+':'+
	('0'+date.getMinutes()).slice(-2)+' '+
	amPM;
}

function addListeners() {
	'use strict';
	log('in addListeners');

	let all = $('#chooseAll');
	let pending = $('#choosePending');
	let approved = $('#chooseApproved');
	let denied = $('#chooseDenied');
	let showEmployees = $('#showEmployees');

	showEmployees.on('change', function () {
		log('showEmployees box changed');
		searchFilter = '';
		loadHome();
	});
	all.on('change', function () {
		log('all box changed');
		pending.prop('checked', all.prop('checked'));
		approved.prop('checked', all.prop('checked'));
		denied.prop('checked', all.prop('checked'));
		loadTable();
	});	
	pending.on('change', function () {
		log('pending box changed');
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
		log('approved box changed');
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
		log('approved box changed');
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

function log(message) {
	'use strict';
	console.log('home.js -- '+message);
}
