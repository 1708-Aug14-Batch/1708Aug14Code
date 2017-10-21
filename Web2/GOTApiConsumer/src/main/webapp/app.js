/**
 * genesis bonds [4:11 PM] 
192.168.60.75
 */


angular.module('app', []).controller('hello', function($scope, $http){
	$http.get('http://192.168.60.75:8050/springrestservice/users').
	then(function(response){
		$scope.users = response.data
	});
	
	var people;
	$scope.getUser = function(){
		console.log('in get user');
		$http.get('http://192.168.60.75:8050/springrestservice/users/' + $scope.id)
		.then(function(response){
			$scope.user = response.data;
			people += (response.data);
		})
	}
	
	$scope.addUser = function(){
		console.log($scope.name)
		var user = {"username" : $scope.name}
		user = JSON.stringify(user);
		console.log(user);
		
		$htp.post('http://192.168.60.75:8050/springrestservice/users/', user)
		.then(function(success){
			console.log(success);
		})
	}
	
	
})