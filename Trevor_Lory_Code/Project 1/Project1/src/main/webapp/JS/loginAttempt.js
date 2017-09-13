
function loadDashboardView() {
	console.log('Getting Dash');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	};
	xhr.open('GET', 'getDashboard', true);
	xhr.send();
}

function getUserNavInfo() {
	console.log('Getting User Nav Info');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			var firstname = dto.fn;
			var lastname = dto.ln;
			document.getElementById('GreetThing').innerHTML = 'Hello, ' + firstname + ' ' + lastname + '!';
			console.log(dto);
		}
	};
	xhr.open('GET', 'getUserNavInfo', true);
	xhr.send();
}

var reims = [];
var Penreims = [];

function reloadMyReim() {
	if(document.getElementById('ResCheck').checked) {
		$('#ReimTable').DataTable( {
			destroy: true,
	        "order": [[ 0, "desc" ]],
	        data: reims,
	        columns: [
	            { title: "Submitter" },
	            { title: "Resolver" },
	            { title: "Submit Date" },
	            { title: "Resolve Date" },
	            { title: "Status" },
	            { title: "Submit Note" },
	            { title: "Resolve Note" },
	            { title: "Amount" }
	        ]
	    } );
	}
	else {
		$('#ReimTable').DataTable( {
			destroy: true,
	        "order": [[ 0, "desc" ]],
	        data: Penreims,
	        columns: [
	            { title: "Submitter" },
	            { title: "Resolver" },
	            { title: "Submit Date" },
	            { title: "Resolve Date" },
	            { title: "Status" },
	            { title: "Submit Note" },
	            { title: "Resolve Note" },
	            { title: "Amount" }
	        ]
	    } );
	}
}

function getUserReim() {
	console.log('Getting Reim Base Data');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			console.log(dto);
			reims = [];
			Penreims = [];
			for(var i = 0; i < dto.reims.length; i++) {
				var arr = [ dto.reims[i].sub, dto.reims[i].res, dto.reims[i].subDate, dto.reims[i].resDate, dto.reims[i].status, dto.reims[i].desc, dto.reims[i].resNote, dto.reims[i].amount];
				reims.push(arr);
				if(dto.reims[i].status == 'Pending') {
					Penreims.push(arr);
				}
			}
			console.log(dto.reims[0][0]);
			console.log(reims);
			$('#ReimTable').DataTable( {
				destroy: true,
		        "order": [[ 0, "desc" ]],
		        data: reims,
		        columns: [
		            { title: "Submitter" },
		            { title: "Resolver" },
		            { title: "Submit Date" },
		            { title: "Resolve Date" },
		            { title: "Status" },
		            { title: "Submit Note" },
		            { title: "Resolve Note" },
		            { title: "Amount" }
		        ]
		    } );
			
			document.getElementById('ResCheck').onchange = function() {
				reloadMyReim();
			};
		}
	};
	xhr.open('GET', 'getMyReimData', true);
	xhr.send();
}

function addNewReim() {
	console.log('Adding new Reim');
	var xhr = new XMLHttpRequest();
	var Amt = document.getElementById('amount').value;
	var desc = document.getElementById('desc').value;
	if(desc == null || desc == '' || Amt == null || Amt == 0) {
		document.getElementById('failText').style.display = 'inline';
		document.getElementById('passText').style.display = 'none';
		return;
	}
	var tx = [Amt, desc];
	tx = JSON.stringify(tx);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText == 'true') {
				document.getElementById('failText').style.display = 'none';
				document.getElementById('passText').style.display = 'inline';
				getUserReim();
			}
			else if(xhr.responseText == 'false') {
				document.getElementById('failText').style.display = 'inline';
			}
			else {
				console.log('THE HECK!');
			}
		}
	};
	xhr.open('POST', 'addNewReim', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}

function loadMyReimView() {
	console.log('Getting Reim');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserReim();
			document.getElementById('AddReimButt').onclick = function() {
				if(document.getElementById('AddReimView').style.display == 'none') {
					document.getElementById('AddReimView').style.display = 'inline';
				}
				else {
					document.getElementById('AddReimView').style.display = 'none';
				}
			};
			document.getElementById('AddReimButtAct').onclick = function() {
				addNewReim();
			}
		}
	};
	xhr.open('GET', 'getMyReim', true);
	xhr.send();
}

function loadSettingsData() {
	console.log('Getting Settings Data');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			console.log(dto);
			document.getElementById('SetEmail').innerHTML = dto.email;
			document.getElementById('SetFirst').innerHTML = dto.firstName;
			document.getElementById('SetLast').innerHTML = dto.lastName;
			var tempPass = '';
			for(var i = 0; i < dto.password.length; i++) {
				tempPass += '*';
			}
			document.getElementById('SetPass').innerHTML = tempPass;
		}
	};
	xhr.open('GET', 'getSettingsData', true);
	xhr.send();
}

function updateSettingsData() {
	console.log('Updating Settings Data');
	var xhr = new XMLHttpRequest();
	var Email = document.getElementById('SetUpEmail').value;
	var FirstName = document.getElementById('SetUpFirst').value;
	var LastName = document.getElementById('SetUpLast').value;
	var NewPass = document.getElementById('SetUpPass').value;
	var OldPass = document.getElementById('SetUpPassCon').value;
	var tx = [Email, FirstName, LastName, NewPass, OldPass];
	tx = JSON.stringify(tx);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			loadSettingsData();
			if(xhr.responseText == 'true') {
				document.getElementById('SetUpEmail').value = '';
				document.getElementById('SetUpFirst').value = '';
				document.getElementById('SetUpLast').value = '';
				document.getElementById('SetUpPass').value = '';
				document.getElementById('SetUpPassCon').value = '';
				document.getElementById('failText').style.display = 'none';
				document.getElementById('passText').style.display = 'inline';
				document.getElementById('failpassText').style.display = 'none';
			}
			else if(xhr.responseText == 'false'){
				document.getElementById('failText').style.display = 'inline';
				document.getElementById('passText').style.display = 'none';
				document.getElementById('failpassText').style.display = 'none';
			}
			else if(xhr.responseText == 'pass') {
				document.getElementById('failText').style.display = 'none';
				document.getElementById('passText').style.display = 'none';
				document.getElementById('failpassText').style.display = 'inline';
			}
			else {
				console.log('THE HECK!');
			}
		}
	};
	xhr.open('POST', 'updateEmpSet', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}

function loadSettingsView() {
	console.log('Getting Settings');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('SetPassButt').onclick = function() {
				if(document.getElementById('SetUpEmail').style.display == 'none') {
					document.getElementById('SetUpText').style.display = 'inline';
					document.getElementById('SetUpEmail').style.display = 'inline';
					document.getElementById('SetUpFirst').style.display = 'inline';
					document.getElementById('SetUpLast').style.display = 'inline';
					document.getElementById('SetUpPass').style.display = 'inline';
					document.getElementById('SetUpPassCon').style.display = 'inline';
					document.getElementById('SetUpSubmit').style.display = 'inline';
				}
				else {
					document.getElementById('SetUpText').style.display = 'none';
					document.getElementById('SetUpEmail').style.display = 'none';
					document.getElementById('SetUpFirst').style.display = 'none';
					document.getElementById('SetUpLast').style.display = 'none';
					document.getElementById('SetUpPass').style.display = 'none';
					document.getElementById('SetUpPassCon').style.display = 'none';
					document.getElementById('SetUpSubmit').style.display = 'none';
				}
			};
			loadSettingsData();
			document.getElementById('SetUpSubmit').addEventListener('click', updateSettingsData);
		}
	};
	xhr.open('GET', 'getSettings', true);
	xhr.send();
}

function loadNavBarView() {
	console.log('Getting NavBar');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('AppView').innerHTML = xhr.responseText;
			getUserNavInfo();
			document.getElementById('HomeBut').addEventListener('click', loadDashboardView);
			document.getElementById('MyR').addEventListener('click', loadMyReimView);
			document.getElementById('Settings').addEventListener('click', loadSettingsView);
			loadDashboardView();
		}
	};
	xhr.open('GET', 'getNavBar', true);
	xhr.send();
}

function loadDashboardViewMan() {
	console.log('Getting Dash Man');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	};
	xhr.open('GET', 'getDashboardMan', true);
	xhr.send();
}

var Manreims = [];
var ManPenreims = [];

function reloadManReim() {
	if(document.getElementById('ResCheck').checked) {
		$('#ReimTable').DataTable( {
			destroy: true,
	        "order": [[ 0, "desc" ]],
	        data: Manreims,
	        columns: [
	            { title: "Submitter" },
	            { title: "Resolver" },
	            { title: "Submit Date" },
	            { title: "Resolve Date" },
	            { title: "Status" },
	            { title: "Submit Note" },
	            { title: "Resolve Note" },
	            { title: "Amount" }
	        ]
	    } );
	}
	else {
		$('#ReimTable').DataTable( {
			destroy: true,
	        "order": [[ 0, "desc" ]],
	        data: ManPenreims,
	        columns: [
	            { title: "Submitter" },
	            { title: "Resolver" },
	            { title: "Submit Date" },
	            { title: "Resolve Date" },
	            { title: "Status" },
	            { title: "Submit Note" },
	            { title: "Resolve Note" },
	            { title: "Amount" }
	        ]
	    } );
	}
}

function getManReim() {
	console.log('Getting Reim Base Data');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			console.log(dto);
			Manreims = [];
			ManPenreims = [];
			for(var i = 0; i < dto.reims.length; i++) {
				var arr = [ dto.reims[i].sub, dto.reims[i].res, dto.reims[i].subDate, dto.reims[i].resDate, dto.reims[i].status, dto.reims[i].desc, dto.reims[i].resNote, dto.reims[i].amount];
				Manreims.push(arr);
				if(dto.reims[i].status == 'Pending') {
					ManPenreims.push(arr);
				}
			}
			console.log(dto.reims[0][0]);
			console.log(Manreims);
			$('#ReimTable').DataTable( {
				destroy: true,
		        "order": [[ 0, "desc" ]],
		        data: Manreims,
		        columns: [
		            { title: "Submitter" },
		            { title: "Resolver" },
		            { title: "Submit Date" },
		            { title: "Resolve Date" },
		            { title: "Status" },
		            { title: "Submit Note" },
		            { title: "Resolve Note" },
		            { title: "Amount" }
		        ]
		    } );
			
			document.getElementById('ResCheck').onchange = function() {
				reloadManReim();
			};
		}
	};
	xhr.open('GET', 'getReimManData', true);
	xhr.send();
}

function loadMyReimManView() {
	console.log('Getting Man Reim');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getManReim();
		}
	};
	xhr.open('GET', 'getReimMan', true);
	xhr.send();
}

function loadAccData() {
	console.log('Getting Account Base Data');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			console.log(dto);
			var ManAcc = [];
			for(var i = 0; i < dto.users.length; i++) {
				var temp = '';
				for(var e = 0; e < dto.users[i].password.length; e++) {
					temp += '*';
				}
				if(dto.users[i].isManager) {
					var arr = [ dto.users[i].firstName, dto.users[i].lastName, dto.users[i].email, temp,'Manager' ];
					ManAcc.push(arr);
				}
				else {
					var arr = [ dto.users[i].firstName, dto.users[i].lastName, dto.users[i].email, temp, 'Employee' ];
					ManAcc.push(arr);
				}
			}
			console.log(ManAcc);
			$('#AccTable').DataTable( {
				destroy: true,
		        "order": [[ 0, "desc" ]],
		        data: ManAcc,
		        columns: [
		            { title: "First Name" },
		            { title: "Last Name" },
		            { title: "Email" },
		            { title: "Password" },
		            { title: "Job" }
		        ]
		    } );
		}
	};
	xhr.open('GET', 'getAccData', true);
	xhr.send();
}

function addNewEmp() {
	console.log('Attempting Login');
	var xhr = new XMLHttpRequest();
	var first = document.getElementById('AddFirst').value;
	var last = document.getElementById('AddLast').value;
	var email = document.getElementById('AddEmail').value;
	var man = document.getElementById('AddMan').checked;
	var tx = [];
	if(man) {
		tx = [first, last, email, 'true'];
	}
	else {
		tx = [first, last, email, 'false'];
	}
	tx = JSON.stringify(tx);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText != null || xhr.responseText != "") {
				loadAccData();
				alert("New Employee's temp password: " + xhr.responseText);
			}
			else {
				//TODO Add in negative feedback
			}
		}
	};
	xhr.open('POST', 'addNewEmp', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}

function loadManAccView() {
	console.log('Getting Accounts');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			loadAccData();
			document.getElementById('AddEmpButt').onclick = function() {
				if(document.getElementById('AddDiv').style.display == 'none') {
					document.getElementById('AddDiv').style.display = 'inline';
				}
				else {
					document.getElementById('AddDiv').style.display = 'none';
				}
			};
			document.getElementById('AddEmpButtSub').addEventListener('click', addNewEmp);
		}
	};
	xhr.open('GET', 'getAccounts', true);
	xhr.send();
}

function loadNavBarManView() {
	console.log('Getting NavBar');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('AppView').innerHTML = xhr.responseText;
			getUserNavInfo();
			document.getElementById('HomeBut').addEventListener('click', loadDashboardViewMan);
			document.getElementById('Reim').addEventListener('click', loadMyReimManView);
			document.getElementById('ManAcc').addEventListener('click', loadManAccView);
			loadDashboardViewMan();
		}
	};
	xhr.open('GET', 'getNavBarMan', true);
	xhr.send();
}

function attemptLoginFunc() {
	console.log('Attempting Login');
	var xhr = new XMLHttpRequest();
	var email = document.getElementById('email').value;
	var pass = document.getElementById('pass').value;
	var tx = [email, pass];
	tx = JSON.stringify(tx);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText == "Failed") {
				console.log('ResponseText: ' + xhr.responseText);
				document.getElementById("passText").style.visibility = "visible";
			}
			else if(xhr.responseText == 'false') {
				document.getElementById('bodyTag').setAttribute('background', '');
				loadNavBarView();
			}
			else if(xhr.responseText == 'true') {
				document.getElementById('bodyTag').setAttribute('background', '');
				loadNavBarManView();
			}
			else {
				console.log('I am sorry BUT HOW????');
			}
		}
	};
	xhr.open('POST', 'attemptLogin', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}

document.getElementById('submit').addEventListener('click', attemptLoginFunc);