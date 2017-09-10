var app = angular.module('calApp', []);

app.controller('calCtrl', function($scope) {
	$scope.fv = 0;
	$scope.lv = 0;

	$scope.cals = [ {
		firstval : 3,
		secondval : 2,
		op : "ADD",
		result : 5
	} ];
	
	$scope.ADD = function(fv, lv) {
		$scope.cals.push({
			firstval : fv,
			secondval : lv,
			op : "ADD",
			result : (fv + lv)
		});
	};
	
	$scope.SUB = function(fv, lv) {
		$scope.cals.push({
			firstval : fv,
			secondval : lv,
			op : "SUBTRACT",
			result : (fv - lv)
		});
	};
	
	$scope.MUL = function(fv, lv) {
		$scope.cals.push({
			firstval : fv,
			secondval : lv,
			op : "MULTIPLY",
			result : (fv * lv)
		});
	};
	
	$scope.DIV = function(fv, lv) {
		$scope.cals.push({
			firstval : fv,
			secondval : lv,
			op : "DIVIDE",
			result : (fv / lv)
		});
	};
});