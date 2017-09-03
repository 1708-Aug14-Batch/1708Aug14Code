/**
 * 
 */

 angular.module.controller("menuContainer",function($scope, $http, $state){
 	$scope.login = function(){
 		$http({
 			method: 'POST',
 			// servlet mapping
 			url: 'login',
 			data: $scope.newLogin
 		}).then(function(value)){
 			console.log("faj");
 		}
 	}
 })