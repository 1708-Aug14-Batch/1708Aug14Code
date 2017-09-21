var app = angular.module('myApp',['ngRoute']);
var domain = 'http://localhost:8021/ngmvcbank/';
app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl :'login.html'
	})
	.otherwise({
		redirectTo: '/'
	});
});

app.controller('loginCtrl', function($scope){
	
});