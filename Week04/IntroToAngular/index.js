
var app = angular.module('myApp',[]);

app.controller('myCtrl', function($scope){
	$scope.hello = "hello";
	$scope.fullName = function() {
		return $scope.fn + " " + $scope.ln
	}
})