/*
var bankApp = angular.module("app" ["ui.router"]);

bankApp.config(function($stateProvider, $urlRouterProvider){
	console.log("init bank app..");

	$stateProvider
		.state("login",{
			url:"/login",
			templateUrl: "templates/login.html", // hmtl
			controller: "LoginCtrl as login"// ngcontroller
		})
		.state("register",{
			url:"/register",
			templateUrl: "templates/register.html",
			controller: "RegisterCtrl as register"
		});
})
*/

var bankApp = angular.module("app", ["ui.router"]);

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

bankApp.service("UserService", function($http, $q){
	console.log("in user service");

	var service = this;

	service.user={
		username: "",
		password: "",
		authenticated: false
	};

	service.getUser=function(){
		return service.user;
	};

	service.setUser=function(data){
		service.user.username=data.username;
		service.user.password=data.password;
		service.user.authenticated=data.password;
	};

	service.registerUser=function(){
		var promise;

		promise = $http.post('rest/user/register',service.user).then(
			function(response){
				console.log(response);
				return response;
			},
			function(error){
				console.log("Register user promise failed");
				return $q.reject(error);
			}
		);

		return promise;
	};
})

bankApp.controller("LoginCtrl", function($state){
	console.log("in login controller");
});

bankApp.controller("RegisterCtrl", function($state, UserService){
	console.log("in register controller");

	var register = this;
	register.user = UserService.getUser();
	register.doRegister = function(){

		var promise = UserService.registerUser();

		promise.then(	
			function(response){
				console.log(response);
				UserService.setUser(response.data);
				$state.go('login');
			},
			function(error){
				console.log("error");
				alert(error);
			}
		)
	}
});

bankApp.controller("NavCtrl", function($state){
	console.log("in nav controller");
});