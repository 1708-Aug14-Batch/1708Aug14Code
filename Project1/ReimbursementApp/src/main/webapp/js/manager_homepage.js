
var data;

function loadDash() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response = this.responseText;
			data = JSON.parse(response);
			document.getElementById("welcome").innerHTML = "Welcome " + data.user.firstname + " " + data.user.lastname + ".";
			console.log(data);
			quickResolve();
		}
	}
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("GET", "managerhomepage", true);
	xhr.send();
}

function resetData(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response = this.responseText;
			data = JSON.parse(response);
		}
	}
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("GET", "managerhomepage", true);
	xhr.send();
}

function quickResolve(){
	$('.btn-lg').each(function(){
		$(this).removeClass('active');
	});

	$('#quickresolve').addClass('active');
	$('#heading').text('Quick Resolve');
	//setup headers
	var headers="<thead><tr><th>ID</th><th>Employee</th><th>Amount</th><th>Description</th>";
	headers += "<th>Submitted</th><th>Resolve</th></tr></thead>";

	//setup data body
	var body = "<tbody>";
	for(var i=0; i < data.pending.length; i++){
		body += "<tr>";

		//basic data about reimbursement
		body += "<td>#" + data.pending[i].reimbursementId + "</td>";
		body += "<td>" + data.pending[i].submitName + "</td>";
		body += '<td>$' + data.pending[i].amount.toFixed(2) + '</td>';
		body += "<td>" + data.pending[i].description + "</td>";

		//add date
		var date = new Date(parseInt(data.pending[i].submitDate));
		body += "<td>" + date.toLocaleDateString() + "</td>";

		//modal button
		body += '<td><button id="btn'+data.pending[i].reimbursementId+'" class="btn btn-primary" data-toggle="modal" data-target="#submitModal'+data.pending[i].reimbursementId+'">Resolve</button>';
		//modal
		body+= '<div class="modal fade" id="submitModal'+data.pending[i].reimbursementId+'" tabindex="-1" role="dialog" aria-labelledby="submitModalLabel" aria-hidden="true">';
		body+= '<div class="modal-dialog" role="document">';
		body+= '<div class="modal-content">';
		body+= '<div class="modal-header">';
		body+= '<h5 class="modal-title" id="submitModalLabel">Resolve Reimbursement </h5>';
		body+= '<button type="button" class="close" data-dismiss="modal" aria-label="Close">';
		body+= '<span aria-hidden="true">&times;</span>';
		body+= '</button></div>';

		//description
		body+= '<div class="form-group col-10 mt-1"> <label for="description"><p class="lead">Description:</p></label>';
		body+= '<textarea class="form-control" rows="5" id="description" disabled>'+data.pending[i].description+'</textarea></div>';


		//accept or deny
		body+= '<form id="resolveForm'+data.pending[i].reimbursementId+'">';
		body+= '<div class="modal-body"><div class="form-group col-10">';
		body+= '<label for="approveordeny"><p class="lead">Resolve to: </p></label> ';
		body+= '<select name="statusid" id="approveordeny'+data.pending[i].reimbursementId+'" class="selectpicker ml-2" form="resolveForm'+data.pending[i].reimbursementId+'">';
		body+= '<option value="1" selected>Approve</option>';
		body+= '<option value="2">Deny</option></select></div>';  
		//reason
		body+= '<div class="form-group col-10"><label for="reasoninput"><p class="lead">Reason:</p></label>';       
		body+= '<textarea class="form-control" name="reason" id="reasoninput'+data.pending[i].reimbursementId+'" placeholder="Describe your reason" rows="3"></textarea>';			
		body+= '</div></div>';
		//reimbursement id
		body += '<input type="hidden" name="reimbursementid" value=' + data.pending[i].reimbursementId + '>';

		//close modal with submit/close buttons
		body+= '<div class="modal-footer">';
		body+= '<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>';
		body+= '<button type="submit" class="btn btn-primary">Submit</button>';
		body+= '</div></form></div></div></div></td>';


		//end row
		body += "</tr>";
	}
	body += "</tbody>";

	var table = $('<table/>').attr('id','dataTable').addClass('display cell-border');
	table.html(headers);
	table.append(body);

	$('#content').html(table);

	$('#dataTable').DataTable({
		"columns": [
		            null,
		            null,
		            null,
		            null,
		            { "type": "date" },
		            null
		            ],
		            "aaSorting": [0,'desc']
	});

	//setup on clicks for buttons
	$('form').not('#manager_home_form').not('#profile_form').not('#logout_form').each(function(){
		$(this).on('submit',function(e){
			e.preventDefault();

			//get reimbursement id form attribute
			var id = $(this).attr('id').substring(11);
			var reasonSelector = '#reasoninput' + id;
			if($(reasonSelector).val()==""){
				$(reasonSelector).val('N/A');
			}
			//make form data into url string data
			var details = $(this).serialize();

			//selectors
			var modalSelector = '#submitModal' + id;
			var buttonSelector = '#btn' +id;
			var decisionSelector = '#approveordeny' + id;
			
			//hide modal
			$(modalSelector).modal("hide");
			//get approve or deny
			var decision = $(decisionSelector).val();

			//if approve
			if(decision == 1){
				//disable button and change look to green + approved
				$(buttonSelector).removeClass('btn-primary').addClass('btn-success').html('Approved').attr("disabled","disabled");
			}
			else{
				//disable and change look to red + denied
				$(buttonSelector).removeClass('btn-primary').addClass('btn-danger').html('Denied').attr("disabled","disabled");
			}

			//send request and reset global data
			$.post('resolveReimbursement', details, resetData());
		});
	});

}

function viewResolved(){
	$('.btn-lg').each(function(){
		$(this).removeClass('active');
	});

	$('#viewallresolved').addClass('active');
	$('#heading').text('Resolved Reimbursements');
	//setup headers
	var headers="<thead><tr><th>ID</th><th>Employee</th><th>Amount</th><th>Description</th>";
	headers += "<th>Manager</th><th>Reason</th><th>Status</th><th>Resolved</th></tr></thead>";

	//setup data body
	var body = "<tbody>";
	for(var i=0; i < data.resolved.length; i++){
		body += "<tr>";

		//basic data about reimbursement
		body += "<td>#" + data.resolved[i].reimbursementId + "</td>";
		body += "<td>" + data.resolved[i].submitName + "</td>";
		body += "<td>$" + data.resolved[i].amount.toFixed(2) + "</td>";
		body += "<td>" + data.resolved[i].description + "</td>";
		body += "<td>" + data.resolved[i].resolveName + "</td>";
		body += "<td>" + data.resolved[i].managerNotes + "</td>";

		if(data.resolved[i].statusId == 1){
			body += '<td><span class="text-success">Approved</span></td>';
		}
		else{
			body += '<td><span class="text-danger">Denied</span></td>';
		}

		//add date
		var date = new Date(parseInt(data.resolved[i].resolveDate));
		body += "<td>" + date.toLocaleDateString() + "</td>";


		//end row
		body += "</tr>";
	}
	body += "</tbody>";

	var table = $('<table/>').attr('id','dataTable').addClass('display cell-border');
	table.html(headers);
	table.append(body);

	$('#content').html(table);
	$('#dataTable').DataTable({
		"columns": [
		            null,
		            null,
		            null,
		            null,
		            null,
		            null,
		            null,
		            { "type": "date" }
		            ],
		"aaSorting": [7,'desc']
	});
}

function viewEmployees(){
	$('.btn-lg').each(function(){
		$(this).removeClass('active');
	});

	$('#viewallemployees').addClass('active');
	$('#heading').text('Employees');
	//setup headers
	var headers="<thead><tr><th>Firstname</th><th>Lastname</th><th>username</th>";
	headers += "<th>Email</th><th>User ID</th></tr></thead>";

	//setup data body
	var body = "<tbody>";
	for(var i=0; i < data.employees.length; i++){
		body += "<tr>";

		//basic data about reimbursement
		body += "<td>" + data.employees[i].firstname + "</td>";
		body += "<td>" + data.employees[i].lastname + "</td>";
		body += "<td>" + data.employees[i].username + "</td>";
		body += "<td>" + data.employees[i].email + "</td>";
		body += "<td>#" + data.employees[i].userId + "</td>";

		//end row
		body += "</tr>";
	}
	body += "</tbody>";

	var table = $('<table/>').attr('id','dataTable').addClass('display cell-border');
	table.html(headers);
	table.append(body);

	$('#content').html(table);
	$('#dataTable').DataTable();
}

function resolveEmployee(){
	$('.btn-lg').each(function(){
		$(this).removeClass('active');
	});

	$('#resolveemployee').addClass('active');
	$('#heading').text('Resolve Employee');

	var select = "<h5>Choose employee: </h5>";
	select += '<form id="nameForm" action="javascript:getEmployeeReimbursements();"> <input list="employeeNames" id="employeeName">';
	select += '<datalist id="employeeNames">';

	for(var i=0; i < data.employees.length; i++){
		select += '<option value="'+data.employees[i].firstname +" "+data.employees[i].lastname+'">'; 
	}

	select += '</datalist><button type="submit" class="btn btn-sm btn-primary m-2">Submit</button></form><hr>';
	select += '<div id="employee-content"></div>';
	$('#content').html(select);
}

function getEmployeeReimbursements(){
	var querystring = "name="+$('#employeeName').val();
	$.get( "getemployeereimbursements", querystring, function( reimbursements ) {
		console.log(reimbursements);
		//setup headers
		var headers="<thead><tr><th>ID</th><th>Amount</th><th>Description</th>";
		headers += "<th>Submitted</th><th>Status</th><th>Resolve</th></tr></thead>";

		//setup data body
		var body = "<tbody>";
		for(var i=0; i < reimbursements.length; i++){
			body += "<tr>";

			//basic data about reimbursement
			body += "<td>#" + reimbursements[i].reimbursementId + "</td>";
			body += "<td>$" + reimbursements[i].amount.toFixed(2) + "</td>";
			body += "<td>" + reimbursements[i].description + "</td>";

			//add date
			var date = new Date(parseInt(reimbursements[i].submitDate));
			body += "<td>" + date.toLocaleDateString() + "</td>";

			//create buttons and forms for resolving this row
			if(reimbursements[i].statusId == 0){
				body += '<td><span id="span'+reimbursements[i].reimbursementId+'" class="text-info">Pending</span></td>';


				//modal button
				body += '<td><button id="btn'+reimbursements[i].reimbursementId+'" class="btn btn-primary" data-toggle="modal" data-target="#submitModal'+reimbursements[i].reimbursementId+'">Resolve</button>';
				//modal
				body+= '<div class="modal fade" id="submitModal'+reimbursements[i].reimbursementId+'" tabindex="-1" role="dialog" aria-labelledby="submitModalLabel" aria-hidden="true">';
				body+= '<div class="modal-dialog" role="document">';
				body+= '<div class="modal-content">';
				body+= '<div class="modal-header">';
				body+= '<h5 class="modal-title" id="submitModalLabel">Resolve Reimbursement </h5>';
				body+= '<button type="button" class="close" data-dismiss="modal" aria-label="Close">';
				body+= '<span aria-hidden="true">&times;</span>';
				body+= '</button></div>';

				//description
				body+= '<div class="form-group col-10 mt-1"> <label for="description"><p class="lead">Description:</p></label>';
				body+= '<textarea class="form-control" rows="5" id="description" disabled>'+reimbursements[i].description+'</textarea></div>';


				//accept or deny
				body+= '<form id="resolveForm'+reimbursements[i].reimbursementId+'">';
				body+= '<div class="modal-body"><div class="form-group col-10">';
				body+= '<label for="approveordeny"><p class="lead">Resolve to: </p></label> ';
				body+= '<select name="statusid" id="approveordeny'+reimbursements[i].reimbursementId+'" class="selectpicker ml-2" form="resolveForm'+reimbursements[i].reimbursementId+'">';
				body+= '<option value="1" selected>Approve</option>';
				body+= '<option value="2">Deny</option></select></div>';  
				//reason
				body+= '<div class="form-group col-10"><label for="reasoninput"><p class="lead">Reason:</p></label>';       
				body+= '<textarea class="form-control" name="reason" id="reasoninput'+reimbursements[i].reimbursementId+'" placeholder="Describe your reason" rows="3"></textarea>';			
				body+= '</div></div>';
				//reimbursement id
				body += '<input type="hidden" name="reimbursementid" value=' + reimbursements[i].reimbursementId + '>';

				//close modal with submit/close buttons
				body+= '<div class="modal-footer">';
				body+= '<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>';
				body+= '<button type="submit" class="btn btn-primary">Submit</button>';
				body+= '</div></form></div></div></div></td>';


			}
			else{
				if(reimbursements[i].statusId == 1){
					body += '<td><span class="text-success">Approved</span></td>';
				} else{body += '<td><span class="text-danger">Denied</span></td>';}
				body+='<td></td>'
			}
			//end row
			body += "</tr>";
		}
		body += "</tbody>";

		var table = $('<table/>').attr('id','dataTable').addClass('display cell-border');
		table.html(headers);
		table.append(body);

		$('#employee-content').html(table);
		$('#dataTable').DataTable(({
			"columns": [
			            null,
			            null,
			            null,
			            { "type": "date" },
			            null,
			            null
			            ],
			            "aaSorting": [5,'desc']
		}));

		//setup on clicks for buttons
		$('form').not('#manager_home_form').not('#profile_form').not('#nameForm').not('#logout_form').each(function(){
			$(this).on('submit',function(e){
				e.preventDefault();

				//get reimbursement id form attribute
				var id = $(this).attr('id').substring(11);
				var reasonSelector = '#reasoninput' + id;
				if($(reasonSelector).val()==""){
					$(reasonSelector).val('N/A');
				}
				//make form data into url string data
				var details = $(this).serialize();

				//selectors
				var modalSelector = '#submitModal' + id;
				var buttonSelector = '#btn' +id;
				var decisionSelector = '#approveordeny' + id;
				var spanSelector = '#span' + id;

				//hide modal
				$(modalSelector).modal("hide");
				//get approve or deny
				var decision = $(decisionSelector).val();

				//if approve
				if(decision == 1){
					//disable button and change look to green + approved
					$(buttonSelector).removeClass('btn-primary').addClass('btn-success').html('Approved').attr("disabled","disabled");
					$(spanSelector).removeClass('text-info').addClass('text-success').text('Approved');
				}
				else{
					//disable and change look to red + denied
					$(buttonSelector).removeClass('btn-primary').addClass('btn-danger').html('Denied').attr("disabled","disabled");
					$(spanSelector).removeClass('text-info').addClass('text-danger').text('Denied');
				}

				//send request
				$.post('resolveReimbursement', details, resetData());
			});
		});

	});
}

function registerEmployee(){
	$('.btn-lg').each(function(){
		$(this).removeClass('active');
	});

	$('#registeremployee').addClass('active');
	$('#heading').text('Register');

	var form = '<h5>Enter information about employee:</h5><hr><form id="employeeForm">';

	form += '<div class="form-group m-2"> ';
	form += '<p class="lead">Name</p>';
	form += '<input class="form-control" type="text" name="fn" placeholder="First name" required>';
	form += '<input class="form-control" type="text" name="ln" placeholder="Last name" required><hr>';
	form += '<p class="lead">Username</p>';
	form += '<input class="form-control" type="text" name="username" id="usernameinput" placeholder="Username" required><hr>';
	form += '<p class="lead">Email</p>';
	form += '<input class="form-control" type="email" name="email" id="emailinput" placeholder="Email" required><hr>';
	form += '<p class="text-muted">Pass will be auto-generated</p>';

	form += '<button type="submit" class="btn btn-primary">Submit</button>';
	form += '</div></form>';

	$('#content').html(form);

	$('#employeeForm').on('submit',function(e){
		e.preventDefault();
		var pwd = makepass();

		$('<input />').attr('type', 'hidden')
		.attr('name', 'pwd')
		.attr('value', pwd)
		.appendTo('#employeeForm');

		var details = $(this).serialize();
		$.post('addEmployee', details, function(response){
			alert('Success! Their pass is: "'+pwd + '". And Id is '+response.userId);
			registerEmployee();
		});
		resetData();
	});
}

function makepass() {
	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 5; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}

window.onload = function(){
	$('#quickresolve').click(quickResolve);
	$('#viewallresolved').click(viewResolved);
	$('#viewallemployees').click(viewEmployees);
	$('#resolveemployee').click(resolveEmployee);
	$('#registeremployee').click(registerEmployee);
	loadDash();
}
