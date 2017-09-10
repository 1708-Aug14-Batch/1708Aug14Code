/**
 * AngularJS App
 */

var app = angular.module('myApp', []);
/**
 * An AngularJS module defines an application
 * The module is the container for the different parts of yuor app
 * 
 * 
 * [] tells angular to create a project with the name passed in
 * NOT providing the [] will tell angular one already exists
 */


app.controller('myCtrl', function($scope) {
	
	$scope.hello = "This is binded to my scope";
	
	$scope.fn = "Trevor";
	$scope.ln = "lory";
	
	$scope.fullName = function() {
		return $scope.fn + " " + $scope.ln;
	}
	
});

/*
 * The AngularJS app defined by ng-app="myAPP" is running inside of our body tag.
 * We have also defined a controller - myCtrl - inside of the body tag.
 * myCtrl is a JAVASCRIPT FUNCTION.
 * AngularJS will invoke the controller with the $scope object.
 * $scope is the application object (aka the owner of the varaibles and functions).
 */