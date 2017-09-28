angular.module('demo', [])
.controller('hello', function($scope, $http) {
	
	
	console.log("test");
	
    $http.get('http://localhost:8050/springrestservice/users').
        then(function(response) {
            $scope.users = response.data;
        });
    
    
    
    $scope.getUser = function(){
    	console.log("in get user function");
        $http.get('http://localhost:8050/springrestservice/users/'+ $scope.id).
        then(function(response) {
            $scope.user = response.data;
        });
    };
    
    
    
    $scope.add = function(){
    	console.log("adding user");
    	var user = {'username' : $scope.name };
    	user = JSON.stringify(user);
    	console.log(user);
    }
});