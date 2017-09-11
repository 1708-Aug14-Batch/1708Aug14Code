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

	$scope.addNewItem = function(newaction){
		$scope.items.push(
				{ action : newaction,
					done: false}
		);
	};
	
	$scope.incompleteCount = function() {
		var count = 0;
		
		angular.forEach($scope.items, function(item) {
			if (!item.done) {
				count++;
			}
		});
		return count;
	};


});



app.filter("checkedItems", function() {
	return function(items, showComplete) {
		var resultArr = [];
		
		angular.forEach(items, function(item) {
			if(item.done==false || showComplete == true) {
				resultArr.push(item);
			}	
		});
		
		return resultArr;
	}
});









