/**
 * 
 */
var app = angular.module("calcApp", []);

app.controller("calcCtrl", function($scope) {
	// Initialization
	$scope.items = [];
	$scope.x_input = 0;
	$scope.y_input = 0;
	
	$scope.addNewOp = function(OP) {
		var x = $scope.x_input;
		var y = $scope.y_input;
		
		// Set the value of z_output
		if (OP == "+")
			$scope.z_output = x + y;
		else if (OP == "-")
			$scope.z_output = x - y;
		else if (OP == "*")
			$scope.z_output = x * y;
		else if (OP == "/")
			$scope.z_output = x / y;
		else if (OP == "%")
			$scope.z_output = x % y;
		else if (OP == "^")
			$scope.z_output = Math.pow(x,y);
		else $scope.z_output = NaN;
		
		// Add the item to the list
		$scope.items.unshift({
			x : x,
			OP : OP,
			y : y,
			z : $scope.z_output
		});
	}
	
	$scope.countCalculations = function() {
		var result = 0;
		
		angular.forEach($scope.items, function(item) {
			result++;
		})
		
		return result;
	}
	
});
