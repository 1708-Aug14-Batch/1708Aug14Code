

var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http){
	$http.get("employee_home").then(function (response){
		$scope.myWelcome = response.data;
	});
});