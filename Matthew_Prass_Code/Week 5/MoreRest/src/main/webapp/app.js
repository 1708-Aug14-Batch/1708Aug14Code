angular.module('app',[])
.controller('hello',function($scope, $http){
	$http.get("http://localhost:8112/MVCREST/users").
	then(function(response){
		$scope.users = response.data;
	});
	
	$scope.getUser = function(){
		$http.get("http://localhost:8112/MVCREST/users/" + $scope.id)
		.then(function(response){
			if(response != null){
				$scope.user = response.data;
			}
			else{
				$scope.user=null;
			}
			
		})
	}
	
	$scope.addUser = function(){
		var user = {"username" : $scope.name};
		user = JSON.stringify(user);
		
		$http.post("http://localhost:8112/MVCREST/users" , user).
		then(function(success){
			console.log("yay!");
		});
	}
});