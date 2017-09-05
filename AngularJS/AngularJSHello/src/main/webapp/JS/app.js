/**
 * 
 */

// tells angular to create a project
var app = angular.module('myApp',[]);
/*
 * [] tells angular to create a project with the name passed in
 * note providing the [] will tell angular one already exist
 * 
 * an AngularJS module defines an application
 * The module is the container for different parts of your app
 * 
 * 
 * 
 */

app.controller('myCtrl',function($scope){


	$scope.hello = "this is binded to my scope";

	$scope.fn = "Jane";
	$scope.ln = "Dope";
	$scope.fullName = function(){
		return $scope.fn + " " + $scope.ln;
	}

})

/*
The AngularJS appp defined by ng-app="myApp" 
is running inide of our body tag.
We have also defined a controller - myCtrl - inside 
of the body tag. myCtrl is a JAVASCRIPT FUNCTION

AngularJS will invoke the contoller with the $scope object
$scope is the application object (the owner of the variables and functions)


*/
