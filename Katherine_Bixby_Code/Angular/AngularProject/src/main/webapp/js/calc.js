/**
 * 
 */

var app = angular.module('myCalc',[]);


app.controller('myCtrl', function($scope){
	$scope.num1 = 0;
	$scope.num2 = 0;
	$scope.addition = function(){
		return parseInt($scope.num1)+parseInt($scope.num2);
	}
	$scope.subtraction = function(){
		return parseInt($scope.num1)-parseInt($scope.num2);
	}
	
})
