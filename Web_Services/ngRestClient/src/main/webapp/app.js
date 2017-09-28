/**
 * 
 */
var path = "http://192.168.60.75:8050/springrestservice/users/";

angular.module('app', []).controller('hello', function($scope, $http) {

	console.log("hi");
	$http.get(path).then(function(response) {
		$scope.users = response.data;
		console.log(response.data);
	});

	$scope.getUser = function() {
		console.log('in get user function');
		$http.get(path + $scope.id).then(function(response) {
			$scope.user = response.data;
		});

	};

	$scope.addUser = function() {
		console.log($scope.name);

		var user = {
			"username" : $scope.name
		};
		user = JSON.stringify(user);
		console.log(user);

		$http.post(path, user).then(function(success) {
			console.log("addedUser");
			// UserService.getAll();
		});
	}

});
