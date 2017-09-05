
var app = angular.module('todoApp',[]);


app.controller('todoCtrl',function($scope){

	$scope.username = "Tacos"
	$scope.items = [{action : "Complete P1", done: false},
		{action:"Watch GOT", done: true},
		{action:"Make dinner", done: false}];


	$scope.addNewItem = function(newaction){
		$scope.items.push({action: newaction, done:"false" });
	};

	$scope.incompleteCount = function(){
			var count = 0;
			angular.forEach($scope.items, function(item){
				if(item.done == false){
					count+=1;
				}
			})

			return count;

	}
/*
	$scope.changeTF = function(action){
		console.log(action);
		for(item in $scope.items){
			if(item.action == action){
				if(item.done == "false"){
					item.done = "true";
				}else{
					item.done = "false";
				}
			}
		}
	}
*/
});

app.filter("checkedItems", function(){
	return function(items, showComplete){
		var resultArr = [];
		angular.forEach(items, function(item){
			if(item.done == false || showComplete == true){
				resultArr.push(item);
			}
		})

		return resultArr;
	}
});