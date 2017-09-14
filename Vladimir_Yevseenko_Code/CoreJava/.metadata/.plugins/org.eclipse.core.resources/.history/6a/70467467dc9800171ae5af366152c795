$(function() {
	$('#toManagerRegistration').click(function() {
		window.location.replace('register.html');
	});
});



$(function() {
	$('#loginSubmit').click(function() {
		$.post('loginServlet',
				{ email: $('#emailIn').val(), password: $('#passwordIn').val() },
				function(response) {
					if (response.success)
						window.location.href = 'loggedIn.html';
					else
						$('#message').text('Incorrect email/password');
				});
	});
});