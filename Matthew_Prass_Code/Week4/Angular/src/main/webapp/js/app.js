var app  = angular.module('myApp',[]);
//module deinfes an app
//is a container for different parts of the app
//[] tells angular to create a project
//with the name passed in
app.controller('myCtrl',function($scope){
	$scope.fn="jane";
	$scope.ln = "doe";
	$scope.fullName = function(){
		return $scope.fn+ " "+ $scope.ln;
	}
})

//angular js app defined by ng-app= "myApp"
//running inside of our body tag
//we also defined a controller inside the body
//"myctrl" is a js function

//angular js will invoke the controller with the $scope object
//$scope is the app object(owner of variables and functions)