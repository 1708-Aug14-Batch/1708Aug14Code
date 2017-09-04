function runRegEmp() {
	var fn = document.getElementById("fname").value;
	var ln = document.getElementById("lname").value;
	var cn = document.getElementById("uname").value;
	var em = document.getElementById("email").value;
	
	Packages.com.project1.dao.DaoImpl.registerEmp(fn, ln, cn, em);
}

document.getElementById("registerEmp").addEventListener("click", runRegEmp);