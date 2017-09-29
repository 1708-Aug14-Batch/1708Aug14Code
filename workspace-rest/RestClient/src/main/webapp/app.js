
angular.module('app', []).controller('hello', function($scope, $http) {
	$http.get('http://localhost:8081/RestExample/users').then(
		function(response) {
			$scope.users = response.data;
			console.log(response.data);
		});
	
	$scope.getUser = function() {
		console.log("In getUser function");
		$http.get('http://localhost:8081/RestExample/users/' + $scope.id).then(
			function(response) {
				$scope.user = response.data;
			});
	};
	
	$scope.addUser = function() {
		var user = {"userName" : $scope.name};
		user = JSON.stringify(user);
		$http.post('http://localhost:8081/RestExample/users').then(
			function(response) {
				$scope.users = response.data;
			});
	}
	
});