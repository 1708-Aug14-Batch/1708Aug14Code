
var bankApp = angular.module("bankApp", ["ui.router"]);

bankApp.config(function($stateProvider, $urlRouterProvider) {
	console.log("init bank app..");
	$stateProvider
	.state("login", {
		url:"/login",
		templateUrl:"template/login.html", //html
		controller:"LoginCtrl as login" //ng controller / as is not necessary
	})
	.state("register", {
		url:"/register",
		templateUrl:"template/register.html",
		controller:"RegisterCtrl as register"
	});
});

bankApp.service("UserService", function($http, $q) {
	console.log("in userService");
	var service = this;
	service.user = {
			username:"",
			password:"",
			authenticated:false
	};

	service.getUser=function() {
		return service.user;
	};

	service.setUser = function(data) {
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};

	service.registerUser = function() {
		var promise;
		promise = $http.post(
				'rest/user/resgister', 
				service.user)
				.then(function(response) {
					console.log(reponse);
					return response;
				}, 
				function(error){
					console.log("register user promise failed"); 
					return $q.reject(error);
				});
		return promise;
	};
});

bankApp.controller("LoginCtrl", function($state){
	console.log("in loginCtrl");
});

bankApp.controller("RegisterCtrl", function(UserService, $state){
	console.log("in registerCtrl");
	var register = this;
	register.user = UserService.getUser();
	register.doRegister = function() {
		var promise = UserService.registerUser();
		promise.then(
				function(response) {
					console.log(response);
					UserService.setUser(response.data);
					$state.go('login');
				}, function(error) {
					console.log(error);
				}
		)
	}
});

bankApp.controller("NavCtrl", function($state) {
	console.log("in navCtrl");
});
