angular.module('app', [])


.controller('hello', function($scope, $http){

	console.log("hello");
	$http.get('http://localhost:8050/springrestservice/users').
	then(function(response){
		$scope.users = response.data;
		console.log(response.data);
	});
	
	$scope.getUser = function(){
		console.log('in get user function');
		$http.get('http://localhost:8050/springrestservice/users/' + $scope.id)
		.then(function(response){
			$scope.user = response.data;
		});

	};

	$scope.addUser = function(){
		console.log($scope.name);

		var user = {"username" : $scope.name };
		user = JSON.stringify(user);
		console.log(user);

		$http.post('http://localhost:8050/springrestservice/users',user)
		.then(function(success){
			console.log("addedUser");
			$http.get('http://localhost:8050/springrestservice/users').
			then(function(response){
				$scope.users = response.data;
				console.log(response.data);
			});
		});
	}


});

