function loadEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			loadEmployeeInfo();
			
		}
	}
	xhr.open("GET", "loadEmployee", true);
	xhr.send();
/*
	console.log("loadEmployee")
	$.ajax({
		type: 'GET',
		url: 'loadEmployee',
		success: function(){
			loadEmployeeInfo();
		}
	})*/
}

function loadEmployeeInfo(){
	$.ajax({
		type: 'GET',
		url: 'employeeInfo',
		success: function(response){
			var emps = response;
			for(var x = 0; x<emps.length; x++){
				var tr = "<tr>";
				tr += "<td>" + emps[x].fname + "</td>";
				tr += "<td>" + emps[x].lname + "</td>";
				tr += "<td>" + emps[x].email + "</td>";
				tr += "</tr>"	
				$( "#empTable tbody" ).append(tr);
			}

			var empTable = $('#empTable').DataTable({
				"pageLength": 8,
				"bLengthChange": false,
    			initComplete: function () {
    				this.api().columns([0,1,2]).every( function () {
    					var column = this;
    					var select = $('<select><option value="">Show all</option></select>');
    					select.appendTo($(column.footer()).empty()).on( 'change', function () {
    						var val = $.fn.dataTable.util.escapeRegex($(this).val());
    						column.search( val ? '^'+val+'$' : '', true, false ).draw();
    					} );
    					column.cells('', column[0]).render('display').sort().unique().each( function ( d, j )
    					{
    						select.append( '<option value="'+d+'">'+d+'</option>' )
    					} );
    				} );
    			}
    		});
		}
	})
}