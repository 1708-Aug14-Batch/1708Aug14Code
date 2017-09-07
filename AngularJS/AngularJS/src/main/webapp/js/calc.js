/*
 * My Calculator
 */
var app =angular.module('myCalc', []);

app.controller("myCtrl", function(){
	$scope.add = function(){
		var result = firstnumber + secondnumber;
		return result;
	}
		
	
});