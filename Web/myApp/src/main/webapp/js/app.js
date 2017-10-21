/**
 * 
 */


var app = angular.module('myApp', []);


//app.controller('myCtrl', function($scope){
//	$scope.hello = "hello";
//	$scope.fullName = fuction(){
//	$scope.fn = "Jane";
//	$scope.ln = "Doe";
//	$scope.fulname function(){
//	return $scope.fn +" "+$scope.ln
//	}
//});

app.controller('myCtrl', function($scope) {
    $scope.fn= "John";
    $scope.ln= "Doe";
    $scope.fullname = function(){
    		return $scope.fn+" "+$scope.ln;
    }
});

app.controller('myCtrl1', function($scope) {
    $scope.person={firstName:'John',lastName:'Doe'};
    $scope.mylastname = function(){
    		$scope.person.firstname = $scope.fn;
    		$scope.person.lastname = $scope.ln;
    		return $scope.person.lastname;
    }
});

app.directive("myDirect", function($scope){
	return{
		template: "I am a directive. I don't know what that means."
	}
});

/**
 * The angularJS app defined by ng-app myApp is running inside of our bodytage
 * We also defined myCtrl inside the body tag, my ctrl is a JAVASCRIPT Function
 * angular js will invoke the controller with the $scope object
 * $scop is the application object, aka the owner of the variables nad functiokns
 * [] tells angular to create a project
 * with the name passed in
 * Not providing the []
 * will tell angular one already exists
 * 
 */
