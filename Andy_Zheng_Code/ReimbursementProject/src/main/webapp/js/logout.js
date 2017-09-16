function invalidateSession(){
	$.ajax({
		type: 'GET',
		url: 'logout',
		success: function(){
			loadLogin();
			//window.location = "";
		}
	})
}