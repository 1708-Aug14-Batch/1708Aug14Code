/**
 * 
 */

var bankApp = angular.module("bankApp", [ "ui.router" ]);
var filePrefix = "templates/";

bankApp.config(function($stateProvider, $urlRouterProvider) {
	console.log("init bank app...");

	// Gives functionality to different states
	$stateProvider.state("login", {
		url : "/login",
		templateUrl : filePrefix + "login.html", // html,
		controller : "LoginCtrl as login" // ng controller
	}).state("register", {
		url : "register",
		templateUrl : filePrefix + "register.html",
		controller : "RegisterCtrl as register"
	});
});

/*
 * In AngularJS, a service is a function or object that is available for, and
 * limited to, your AngularJS application. Angular has about 30 built-in
 * services like $http
 */
// $q is a "promise"
bankApp.service("UserService", function($http, $q) {
	console.log("in UserService");

	var service = this;

	service.user = {
		username : "",
		password : "",
		authenticated : false
	};

	service.getUser = function() {
		return service.user;
	};
	service.setUser = function(data) {
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};
	service.registerUser = function() {
		var promise = $http.post("rest/user/register", service.user).then(
				function(response){
					console.log("Response: " + response)
					
				},
				function(error){
					console.log("Error: " + error);
					return $q.reject(error);
				}
		);
		
		return promise;
	};
});

bankApp.controller("LoginCtrl", function($state) {
	console.log("in loginCtrl");
});

bankApp.controller("RegisterCtrl", function(UserService, $state) {
	console.log("in registerCtrl");
	
	var register = this;
	register.user = UserService.getUser();
	register.doRegister = function() {
		var promise = UserService.registerUser();
		
		promise.then(
				function(response) {
					console.log("Response: " + response);
					UserService.setUser(response, data);
					$state.go("login");
				},
				function(error) {
					console.log("Error: " + error);
					alert("Error: " + error);
				}
		);
	}
});

bankApp.controller("NavCtrl", function($state) {
	console.log("in navCtrl");
});
