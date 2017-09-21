var bankApp = angular.module("bankApp", ["ui.router"]);

bankApp.config(function($stateProvider, $urlRouterProvider){
	console.log("init bank app..");
	
	$stateProvider
		.state("login",{
			url:"/login",
			templateUrl: "templates/login.html",// html 
			controller: "LoginCtrl as login"// ng controller			
		})
		.state("register",{
			url: "/register",
			templateUrl: "templates/register.html",
			controller: "RegisterCtrl as register"
		});	
});

bankApp.controller("LoginCtrl", function($state){
	console.log("in loginctrl");
});

bankApp.controller("RegisterCtrl", function($state){
	console.log("in registerctrl");
});

bankApp.controller("NavCtrl", function($state){
	console.log("in navctrl");
})
