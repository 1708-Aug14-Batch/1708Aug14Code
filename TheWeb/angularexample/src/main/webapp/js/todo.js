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

		$scope.items.unshift(
				{ action : newaction,
					done: false}
		);
	};
	
	$scope.incompleteCount = function(){
		
	};


});


app.filter("checkedItems", function(){
	return function(items, showComplete){
		var resultArr = [];
//		for(item in items){
//		} // what is the difference between these loops
		angular.forEach(items, function(item){
			if(item.done==false || showComplete == true){
				resultArr.push(item);
			}
		});
		
		return resultArr;
	}
	
});