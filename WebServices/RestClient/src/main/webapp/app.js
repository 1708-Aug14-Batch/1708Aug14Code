/**
 * 
 */

angular.module('app',[])
.controller('hello', function($scope, $http){
	$http.get('http://192.168.60.75:8050/springrestservice/users').then(function(response){
		$scope.users = response.data;
		console.log(response.data);
	});
	
	var data = $.param({"username": "dkljsalkds"});
	console.log(data);
	var config = {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;',
                'accept' : 'application/json'
            }
        }
	$http.post('http://192.168.60.75:8050/springrestservice/users',data).success(function (data, status, headers, config) {
        console.log(data);
	});
	
	
	console.log("right before add user");
	$scope.addUser = function(username){
		console.log(username);
		console.log("inside add user");
	};
	
	
});