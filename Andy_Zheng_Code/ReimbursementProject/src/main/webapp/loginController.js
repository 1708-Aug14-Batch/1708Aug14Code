/**
 * 
 */

 angular.module("ReimbursementProject").controller("loginContainer",
 	function($scope, $http, $state){
 	// $ save function as object
 	//$state.go("menu");
 	$scope.login = function(){
 		$http({
 			method: 'POST',
 			// servlet mapping
 			url: 'login',
 			data: $scope.credential
 		}).then(function(response){
 			$state.go("menu");
 		})
 	}
 })