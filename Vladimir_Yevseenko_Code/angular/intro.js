

/*
 * an angular JS module defines an application
 * it is the container for different parts of your app
 */
var app = angular.module('myApp', []);


/*
 * $scope is the application object, the owner of the varialbes and functions
 */
app.controller('myController', function($scope) {
	$scope.fullName = function() {
		return $scope.firstName + ' ' + $scope.lastName;
	}
});