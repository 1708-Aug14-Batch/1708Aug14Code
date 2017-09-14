$(function() {
	$('#allReimbursementsBtn').hide();
	
	
	$.post('allReimbursementsServlet',
			{},
			function(arr) {
				 let table = $('#reimbursementsTable').DataTable( {
					 initComplete: function () {
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
				        },
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
					let resolverTxt, submitterTxt, resolutionTxt;
					if (arr[i].status === 'pending') {
						resolverTxt = 'unresolved';
						resolutionTxt = 'unresolved';
					} else {
						resolverTxt = arr[i].resolver.first + " " + arr[i].resolver.last;
						resolutionTxt = arr[i].resolutionDate;
					}
					table.row.add([
					        arr[i].description,
					        arr[i].amount,
					        arr[i].status,
					        arr[i].submitter.first + " " + arr[i].submitter.last,
					        resolverTxt,
					        arr[i].submissionDate,
					        resolutionTxt
					               ]).draw(false);
				}
			},
			'JSON');
	
	$('#logoutBtn').click(function() {
		$.post('logoutServlet',
				{},
				function(data) {
					window.location.replace('login.html');
				});
	});
	
	$('#accInfoBtn').click(function() {
		window.location.replace('accInfo.html');
	});
	
	$('#registerEmployeeBtn').click(function() {
		window.location.replace('registerEmployee.html');
	});
	
	$('#viewEmployeesBtn').click(function() {
		window.location.replace('employees.html');
	});
	
	$('#resolveBtn').click(function() {
		$.post('resolutionServlet',
				{id: $('#reimbursementId').val(), approved: $('#resolutionChoice').val() },
				function(response) {
					if (response.success) {
						location.reload();
					} else {
						$('#message').text('Unable to resolve reimbursement');
					}
				},
				'JSON');
	});
	
	
});