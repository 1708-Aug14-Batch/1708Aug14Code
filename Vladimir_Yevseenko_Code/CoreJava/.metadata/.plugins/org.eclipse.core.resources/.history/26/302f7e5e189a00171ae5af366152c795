$(function() {
	$('#backToLogin').click(function() {
		window.location.replace('login.html');
	});
	
	$('#registerSubmit').click(function() {
		
		$('.errorMsg').each(function() {
			$(this).text('');
		});
		
		$('.inField').each(function() {
			$(this).css('border-color', 'rgba(0,0,0,0.3)');
		});
		
		$('#registerMsg').text('');
		
		if (!$('#firstNameIn').val()) {
			$('#firstNameIn').css('border-color', 'red');
			$('#firstNameMsg').text('Please enter a first name');
			setTimeout(function() {
				$('#firstNameIn').css('border-color', 'rgba(0,0,0,0.3)');
				$('#firstNameMsg').text('');
			}, 3000);
			return;
		} else if (!$('#lastNameIn').val()) {
			$('#lastNameIn').css('border-color', 'red');
			$('#lastNameMsg').text('Please enter a last name');
			setTimeout(function() {
				$('#lastNameIn').css('border-color', 'rgba(0,0,0,0.3)');
				$('#lastNameMsg').text('');
			}, 3000);
			return;
		} else if (!$('#emailIn').val()) {
			$('#emailIn').css('border-color', 'red');
			$('#emailMsg').text('Please enter an email');
			setTimeout(function() {
				$('#emailIn').css('border-color', 'rgba(0,0,0,0.3)');
				$('#emailMsg').text('');
			}, 3000);
			return;
		} else if (!validateEmail($('#emailIn').val())) {
			$('#emailIn').css('border-color', 'red');
			$('#emailMsg').text('Please enter a valid email');
			setTimeout(function() {
				$('#emailIn').css('border-color', 'rgba(0,0,0,0.3)');
				$('#emailMsg').text('');
			}, 3000);
			return;
		} else if (!$('#passwordIn1').val()) {
			$('#passwordIn1').css('border-color', 'red');
			$('#passwordMsg1').text('Please enter a password');
			setTimeout(function() {
				$('#passwordIn1').css('border-color', 'rgba(0,0,0,0.3)');
				$('#passwordMsg1').text('');
			}, 3000);
			return;
		} else if ($('#passwordIn1').val().length < 8) {
			$('#passwordIn1').css('border-color', 'red');
			$('#passwordMsg1').text('Password must be >= 8 characters');
			setTimeout(function() {
				$('#passwordIn1').css('border-color', 'rgba(0,0,0,0.3)');
				$('#passwordMsg1').text('');
			}, 3000);
			return;
		} else if ($('#passwordIn1').val() !== $('#passwordIn2').val()) {
			$('#passwordIn2').css('border-color', 'red');
			$('#passwordMsg2').text('Passwords do not match');
			setTimeout(function() {
				$('#passwordIn2').css('border-color', 'rgba(0,0,0,0.3)');
				$('#passwordMsg2').text('');
			}, 3000);
			return;
		}
		$.post('registerServlet',
				{ firstName: $('#firstNameIn').val(), lastName: $('#lastNameIn').val(),
				  email: $('#emailIn').val(), password: $('#passwordIn').val(),
				  isManager: "true"},    
				function(response) {
					console.log(response.success);
					if (response.success) {
						$('#registerMsg').text('Registration successful');
						$('.inField').each(function() {
							$(this).val('');
						});
						setTimeout(function() {
							$('#registerMsg').text('');
						}, 3000);
					} else {
						$('#emailIn').css('border-color', 'red');
						$('#emailMsg').text('Email already exists');
					}
				},
				'JSON');
	});
});


function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}