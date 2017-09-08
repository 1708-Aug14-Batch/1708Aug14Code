/**
 * AngularJS app
 */

var app = angular.module('myApp',[]);



/*
 * An AngularJS module defines an application
 * The module is the container for different parts
 * of your app.
 * 
 * 
 *[] tells angular to create a project 
 * 	with the name passed in
 * Not providing the [] will tell angular
 *  one already exists
*/

app.controller('myCtrl', function($scope){
	$scope.hello = "this is binded to my scope";
	$scope.fn = "Jane";
	$scope.ln = "Doe";
	$scope.fullName = function(){
		return $scope.fn + " " + $scope.ln;
	}
	
})

/*
 * The AngularJS app defined by ng-app="myApp"
 * is running inside of our body tag. We have also
 * defined a controller - myCtrl - inside of the body
 * tag. myCtrl is a JAVASCRIPT FUNCTION
 * AngularJS will invoke the controller with the $scope object
 * $scope is the application object (the owner of the
 * variables and functions)
 *  
 */
