angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8050/springrestservice/users').
        then(function(response) {
            $scope.users = response.data;
        });
});