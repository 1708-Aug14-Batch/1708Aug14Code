var app = angular.module('todoApp', []);

app.controller('todoCtrl', function($scope) {
	$scope.username = "New User";
	$scope.items = [ {
		action : "Complete P1",
		done : false
	}, {
		action : "Watch GOT",
		done : false
	}, {
		action : "Make Dinner",
		done : true
	} ];
	$scope.addNewItem = function(action) {
		$scope.items = $scope.items.concat({
			action : action,
			done : false
		});
	};
	
	$scope.incompleteCount = function() {
		var temp = 0;
		angular.forEach($scope.items, function(item) {
			if(item.done == false) {
				temp++;
			}
		});
		return temp;
	};
});

app.filter("checkedItems", function() {
	return function(items, showComplete) {
		var resultArr = [];
		angular.forEach(items, function(item) {
			if (item.done == false || showComplete == true) {
				resultArr.push(item);
			}
		});
		return resultArr;
	};
});