function loadMenu(value){
	$.ajax({
		type: 'GET',
		url: 'loadMenu',
		success: function(response){
			document.getElementById('content').innerHTML = response;
			loadUser();
			menu(value);
		}
	})
}
