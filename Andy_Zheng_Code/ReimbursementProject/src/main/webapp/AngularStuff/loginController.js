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
 			console.log(response);
 			if(response.data == 1){
 				$state.go("menu");
 			}else if(response.data == 2){
 				$scope.fail = 'Invalid Password';
 			}else{
 				$scope.fail = 'Invalid Username or Password';
 			}
 		})
 	}
 })