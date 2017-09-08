

var app = angular.module('toDoApp', []);


app.controller('toDoController', function($scope) {
	$scope.username = 'username';
	
	$scope.toDoItems = [ 
							{ description: 'go to the gym', done: false },
							{ description: 'do project 1', done: false },
							{ description: 'play chess', done: false }
						];
	
	$scope.addNewItem = function(newItem) {
		$scope.toDoItems.push({description: newItem, done: false });
		$scope.newItem = '';
	};
	
	$scope.count = function() {
		var count = 0;
		angular.forEach($scope.toDoItems, function(item) {
			if (!item.done)
				count++;
		});
		return count;
	};
});

app.filter('checkedItems', function() {
	return function(items, showAll) {
		var res = [];
		angular.forEach(items, function(item) {
			if (showAll || !item.done)
				res.push(item);
		});
		return res;
	};
});