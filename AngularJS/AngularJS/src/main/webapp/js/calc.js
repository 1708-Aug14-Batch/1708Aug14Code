/**
 *  calc app
 */

var app = angular.module("calcApp", []);

app.controller("calcCtrl", function($scope) {
	$scope.addNumbers = function() {
		$scope.operation = "Add";
		$scope.result = $scope.num1 + $scope.num2;
	}
	$scope.subtractNumbers = function() {
		$scope.operation = "Subtract";
		$scope.result = $scope.num1 - $scope.num2;
	}
	$scope.multiplyNumbers = function() {
		$scope.operation = "Multiply";
		$scope.result = $scope.num1 * $scope.num2;
	}
	$scope.divideNumbers = function() {
		$scope.operation = "Divide";
		$scope.result = $scope.num1 / $scope.num2;
	}
});