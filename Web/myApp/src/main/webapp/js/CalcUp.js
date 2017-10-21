/**
 * 
 */
var app = angular.module('Calc', []);

app.controller('CCtrl', function($scope){
	
	$scope.items =[];
	$scope.Calc = function(){
		$scope.items.unshift({x: $scope.a,
							y: $scope.b,
							div: $scope.division(),
							mult: $scope.multiplication(),
							add: $scope.Addition(),
							sub: $scope.Subtraction()});
	}
	
	$scope.division = function(){
		return $scope.a / $scope.b;
	}
	$scope.multiplication = function(){
		return $scope.a*$scope.b;
	}
	$scope.Addition = function(){
		return $scope.a - $scope.b;
	}
	$scope.Subtraction = function(){
		return $scope.a + $scope.b;
	}
	
	$scope.Switch = function(){
		var inta = $scope.a;
		$scope.a = $scope.b;
		$scope.b = inta;
	}
	
	
	});
