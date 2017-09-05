/**
 * To do App
 */

var app = angular.module("todoApp", []);

app.controller("todoCtrl", function($scope){
	$scope.username = "New User";
	$scope.items = [ 
	               {
	            	   action : "Complete P1",
	            	   done: false
	               },
	               {
	            	   action : "Watch GOT",
	            	   done:false
	               },
	               {action: "Make dinner",
	            	   done:false}

	               ];

	$scope.addNewItem = function(action){

	};


});