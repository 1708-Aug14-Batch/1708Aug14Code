window.onload = function(){
	loadDashboardView();
};

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getAllEmployees();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}

function getAllEmployees(){
	console.log("getting here");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var emps = JSON.parse(xhr.responseText);
			
			
			if(emps.length == 0){
				console.log("something");
			}
			else{
				for(var i =0; i <emps.length; i++){
					var table = document.getElementById("dev-table");
					var tablename = document.getElementById("header");
					tablename.innerHTML = "Employees"
					var row = table.insertRow();
					var empid = row.insertCell(0);
					var fn = row.insertCell(1)
					var ln = row.insertCell(2)
					var email = row.insertCell(3);
					var username = row.insertCell(4)
					empid.innerHTML = "No.: " + emps[i].id + " ";
					fn.innerHTML = emps[i].firstname + " ";
					ln.innerHTML = emps[i].lastname + " ";
					email.innerHTML = emps[i].email+ " ";
					username.innerHTML = emps[i].username;
					
				}
			}
			//document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
		}
	}
	xhr.open("GET","getAllEmployees",true);
	xhr.send();
	(function(){
		'use strict';
		var $ = jQuery;
		$.fn.extend({
			filterTable: function(){
				return this.each(function(){
					$(this).on('keyup', function(e){
						$('.filterTable_no_results').remove();
						var $this = $(this), 
						search = $this.val().toLowerCase(), 
						target = $this.attr('data-filters'), 
						$target = $(target), 
						$rows = $target.find('tbody tr');

						if(search == '') {
							$rows.show(); 
						} else {
							$rows.each(function(){
								var $this = $(this);
								$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
							})
							if($target.find('tbody tr:visible').size() === 0) {
								var col_count = $target.find('tr').first().find('td').size();
								var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
								$target.find('tbody').append(no_results);
							}
						}
					});
				});
			}
		});
		$('[data-action="filter"]').filterTable();
	})(jQuery);

	$(function(){
		// attach table filter plugin to inputs
		$('[data-action="filter"]').filterTable();

		$('.container').on('click', '.panel-heading span.filter', function(e){
			var $this = $(this), 
			$panel = $this.parents('.panel');

			$panel.find('.panel-body').show();
			if($this.css('display') != 'none') {
				$panel.find('.panel-body input').focus();
			}
		});
		$('[data-toggle="tooltip"]').tooltip();
	})
}

$(document).ready(function(){
	document.getElementById("register").addEventListener("click", register)
});



function register(){
	
	var fn = document.getElementById("firstname").value;
	var ln = document.getElementById("lastname").value;
	var em = document.getElementById("email").value;
	
	var tx = [fn,ln,em];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "RegisterEmployee", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}