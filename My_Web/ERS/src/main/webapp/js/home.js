/**
 * 
 */
log('in home.js')

$(document).ready(function () {
	'use strict';
	log('document ready');

	loadNavbar();
	loadHome();
});

function loadHome() {
	'use strict';
	log('in loadHome');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'gethome', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#view').html(xhr.responseText);
			loadTable();
			addStatusListeners();
		}
	};	
	xhr.send();
}

function loadTable() {
	'use strict';
	log('in loadTable');

	log('table= '+$('#homeTable')[0]);
	let homeTable = $('#homeTable').DataTable();

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'gettable', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			let dto = JSON.parse(xhr.responseText);
			let user = dto.user;
			let requests = dto.list;

			$.each(requests, function () {
				log('isManager= '+user.manager+', '+this.requestId+' '+this.submitDate+' '+this.amount);
				if (!user.manager) {
					homeTable.columns = [{data:'Submitted On', type:'date'}];
					homeTable.row.add([
						this.requestId,
						this.submitDate,
						this.amount,
						this.status,
						this.description
						]).draw();

				} else {
					homeTable.row.add([
						this.requestId,
						this.submitterId,
						this.submitDate,
						this.amount,
						this.status,
						this.description,
						this.resolveData,
						this.resolverId
						]).draw();
				}
			});
		}
	};
	xhr.send();
}

function addStatusListeners() {
	'use strict';
	log('in addStatusListner');

	let all = $('#chooseAll');
	let pending = $('#choosePending');
	let approved = $('#chooseApproved');
	let denied = $('#chooseDenied');

	all.on('change', function () {

		pending.prop('checked', all.prop('checked'));
		approved.prop('checked', all.prop('checked'));
		denied.prop('checked', all.prop('checked'));
	});	
	pending.on('change', function () {

		if (!this.selected) {
			all.prop('checked', false);
		}
		else {
			if (approved.prop('checked') && denied.prop('checked')) {
				all.prop('checked', true);
			}
		}
	});
	approved.on('change', function () {

		if (!this.selected) {
			all.prop('checked', false);;
		}
		else {
			if (approved.prop('checked') && denied.prop('checked')) {
				all.prop('checked', true);
			}
		}
	});	
	denied.on('change', function () {

		if (!this.selected) {
			all.prop('checked', false);;
		}
		else {
			if (approved.prop('checked') && denied.prop('checked')) {
				all.prop('checked', true);
			}
		}
	});	
}

function log(message) {
	'use strict';
	console.log('home.js -- '+message);
}
