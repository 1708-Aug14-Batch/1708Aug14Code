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
/*
 * In AngularJS, a service is a function or object that is 
 * available for, and limited to, your AngularJS application.
 * Angular has about 30 built in services like $http
 * https://docs.angularjs.org/api/ng/service/$q
 */
bankApp.service("UserService", function($http, $q){
	console.log("in userService");

	var service = this;

	service.user={
			username : "",
			password : "",
			authenticated : false
	};

	service.getUser= function(){
		return service.user;
	};

	service.setUser = function(data){
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};

	service.registerUser = function(){
		var promise;

		promise = $http.post(
				'rest/user/register',service.user
		).then(
				function(response){
					console.log(response);
					return response;
				},
				function(error){
					console.log('register user promise failed');
					return $q.reject(error);
				}
		);

		return promise;
	};

});

bankApp.controller("LoginCtrl", function($state){
	console.log("in loginctrl");
});

bankApp.controller("RegisterCtrl", function(UserService, $state){
	console.log("in registerctrl");
	
	var register = this;
	register.user = UserService.getUser();
	register.doRegister = function(){
		var promise = UserService.registerUser();
		
		promise.then(
			function(response){
				console.log(response);
				UserService.setUser(response.data);
				$state.go('login');
			}, function(error){
				console.log(error);
			}	
		)
	}
});

bankApp.controller("NavCtrl", function($state){
	console.log("in navctrl");
});
