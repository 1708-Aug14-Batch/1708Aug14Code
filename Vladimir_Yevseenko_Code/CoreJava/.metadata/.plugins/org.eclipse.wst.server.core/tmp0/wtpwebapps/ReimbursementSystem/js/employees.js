$(function() {
	$.post('employeesServlet',
			{},
			function(arr) {
				let table = $('#employeesTable').DataTable( {
			        createdRow: function () {
			            this.api().columns().every( function () {
			                let column = this;
			                let select = $('<select><option value=""></option></select>')
			                    .appendTo( $(column.footer()).empty() )
			                    .on( 'change', function () {
			                        let val = $.fn.dataTable.util.escapeRegex(
			                            $(this).val()
			                        );
			 
			                        column
			                            .search( val ? '^'+val+'$' : '', true, false )
			                            .draw();
			                    } );
			 
			                column.data().unique().sort().each( function ( d, j ) {
			                    select.append( '<option value="'+d+'">'+d+'</option>' )
			                } );
			            } );
			        }
			    } );
				for (let i=0; i<arr.length; i++) {
					console.log(arr[i]);
					table.row.add([
					         arr[i].id,
					         arr[i].first,
					         arr[i].last,
					         arr[i].email
					               ]).draw(false);
				}
 			});
	
	$('#logoutBtn').click(function() {
		$.post('logoutServlet',
				{},
				function(data) {
					window.location.replace('login.html');
				});
	});
	
	$('#allReimbursementsBtn').click(function() {
		window.location.replace('allReimbursements.html')
	});
	
	$('#accInfoBtn').click(function() {
		window.location.replace('accInfo.html');
	});
	
	$('#registerEmployeeBtn').click(function() {
		window.location.replace('registerEmployee.html');
	});
	
	$('#viewEmployees').click(function() {
		window.location.replace('employees.html');
	});
});