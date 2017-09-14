window.onload = function(){
	loadDashboardView();
};

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}

function getUserInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var emp = dto.emp;
			var reimb = dto.reimbs;

			document.getElementById('name').innerHTML = emp.firstname + " " +emp.lastname;

			if(reimb.length == 0){

			}
			else{
				for(var i =0; i <reimb.length; i++){
					var table = document.getElementById("dev-table");
					var row = table.insertRow();
					var reid = row.insertCell(0);
					var subdate = row.insertCell(1);
					var status = row.insertCell(2);
					var desc = row.insertCell(3);
					var amt = row.insertCell(4);
					reid.innerHTML = "No.: " + reimb[i].id + " ";
					subdate.innerHTML = reimb[i].submitdate+ " ";
					status.innerHTML = reimb[i].type.name + " ";
					if(reimb[i].type.name == "Denied"){
						status.setAttribute("class", "table-danger");
					}
					else if(reimb[i].type.name == "Approved"){
						status.setAttribute("class", "table-success");
					}
					desc.innerHTML = reimb[i].descript+ " ";
					amt.innerHTML = "$ "+reimb[i].amount;
				}
			}
			//document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
		}
	}
	xhr.open("GET","getEmployeeInfo",true);
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

