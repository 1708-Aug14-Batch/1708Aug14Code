var app=angular.module('myApp', ['ngRoute']);


app.config(function($routeProvider){
	$routeProvider
	
	.when('/',{
		templateUrl:'partials/home.html'
	})
	.when('/login',{
		templateUrl:'partials/login.html'
	})
	.otherwise({
		redirectTo: '/'
	});
})