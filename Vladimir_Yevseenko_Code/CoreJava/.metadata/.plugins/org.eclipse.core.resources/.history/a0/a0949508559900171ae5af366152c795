$(function() {
	$.post('userInfoServlet',
			{},
			function(curUser) {
				if (!curUser.isManager) {
					$('#viewAllReimbursementsBtn').hide();
					$('#registerEmployeeBtn').hide();
				} else {
					$('#viewOwnReimbursementsBtn').hide();
				}
			}); 
	
	
	$.post('yourReimbursementsServlet',
			{},
			function(arr) {
				let table = $('#reimbursementsTable').DataTable({searching:false});
				for (let i=0; i<arr.length; i++) {
					console.log(arr[i]);
					let resolverTxt;
					let resolutionTxt;
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
					        resolverTxt,
					        arr[i].submissionDate,
					        resolutionTxt
					               ]).draw(false);
				}
			});
	
	$('#homeBtn').click(function() {
		window.location.replace('loggedIn.html')
	});
	
	$('#logoutBtn').click(function() {
		$.post('logoutServlet',
				{},
				function(data) {
					window.location.replace('login.html');
				});
	});
	
	$('#viewOwnReimbursementsBtn').click(function() {
		window.location.replace('yourReimbursements.html');
	});
	
	$('#viewAllReimbursementsBtn').click(function() {
		window.location.replace('allReimbursements.html')
	});
	
	$('#updateAccInfoBtn').click(function() {
		window.location.replace('accInfo.html');
	});
	
	$('#registerEmployeeBtn').click(function() {
		window.location.replace('registerEmployee.html');
	});
});