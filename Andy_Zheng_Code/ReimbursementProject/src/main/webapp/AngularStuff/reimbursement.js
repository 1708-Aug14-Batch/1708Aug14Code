/**
 * 
 */

 angular.module("ReimbursementProject", ["ui.router"]);

 angular.module("ReimbursementProject").config(function($stateProvider, $urlRouterProvider){
 	$urlRouterProvider.otherwise("/")

 	$stateProvider.state({
 		name: 'login',
 		url: '/',
 		templateUrl: 'login.html',
 		controller: 'loginContainer'
 	}).state({
 		name: 'menu',
 		url: '/menu',
 		templateUrl: 'menu.html'
 		//controller: 'menuContainer'
 	});

 });
