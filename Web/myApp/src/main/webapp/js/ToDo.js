/**
 * 
 */

var app = angular.module("ToDoApp", []);

app.controller("ToDoCtrl", function($scope) {
	$scope.username = "New User";
	$scope.items = [{action : "Complete P1", 
		done: false},
		{action : "Watch GOT",
			done : false}] 
	$scope.addNewItem = function(newaction){
		$scope.items.push({action: newaction, done: false})

	}

	$scope.complete = function(item){
		item.done = true;
	}

	$scope.undo = function(item){
		item.done = false;
	}

	$scope.isComplete = function(item){
		if(item.done){return "Yes";}
		else{return "No";}
	}

	$scope.incompleteCount = function(){
		var count = 0;
		angular.forEach($scope.items, function(item){
			if(!item.done)
			{count++;}
			})
			return count;
		}

});


		app.filter("checkedItems",function(){
			return function(items, hide){
				var resultArr = [];

				angular.forEach(items, function(item){
					if(item.done == false || hide == true){
						resultArr.push(item);
					}
				})

				return resultArr;
			}
		});

