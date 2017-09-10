
var app = angular.module('calcApp', []);

app.controller('calcCtlr', function($scope) {

    $scope.num1 = 0;
    $scope.num2 = 0;

    $scope.results = [];

    $scope.storeResult = function(params) {
        var num1 = params.n1;
        var num2 = params.n2;
        var result = {};
        result.n1 = num1;
        result.n2 = num2;
        result.sum = $scope.add(num1, num2);
        result.diff = $scope.sub(num1, num2);
        result.prod = $scope.mul(num1, num2);
        result.quot = $scope.div(num1, num2);
        result.pow = $scope.pow(num1, num2);
        angular.forEach($scope.results, function(val, key) {
            //console.log("i = " + i + ", (n1, n2) = (" + e.n1 + ", " + e.n2 + ")");
            if (val.n1 == num1 && val.n2 == num2) {
                $scope.results.splice(key, 1);
            }
        });
        $scope.results.unshift(result);
    };
    
    $scope.add = function(num1, num2) {
        return num1 + num2;
    };    
    $scope.sub = function(num1, num2) {
    return num1 - num2;
    };
    $scope.mul = function(num1, num2) {
    return num1 * num2;
    };
    $scope.div = function(num1, num2) {
    return num1 / num2;
    };
    $scope.pow = function(num1, num2) {
    return Math.pow(num1, num2);
    };
});
