var calcApp = angular.module('calcApp',[]);

calcApp.controller('calcCtrl',function($scope){
	$scope.result = 0;
	$scope.adding = function(){
		$scope.result =$scope.x+$scope.y;
		return $scope.result;
	};
	$scope.subtract = function(){
		$scope.result =$scope.x-$scope.y;
		return $scope.result;
	};
	$scope.multiply = function(){
		$scope.result =$scope.x*$scope.y;
		return $scope.result;
	};
	$scope.divide = function(){
		$scope.result =$scope.x/$scope.y;
		return $scope.result;
	};
});