
var app = angular.module("calcApp", []);

app controller("calcCtrl", function($scope){
	var firstNumber = $scope.firstNumber;
	var secondNumber = $scope.secondNumber;
	var operator = $scope.operator;
	var answer = null;
	if(operator == "+") {
		var answer = firstNumber + secondNumber;
	}
	if(operator == "-") {
		var answer = firstNumber - secondNumber;
	}
	if(operator == "*") {
		var answer = firstNumber * secondNumber;
	}
	if(operator == "/") {
		var answer = firstNumber / secondNumber;
	}
	return answer;
});