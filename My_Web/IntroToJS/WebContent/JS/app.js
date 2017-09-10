/**
 * AngularJS app
 */

/*
 * An AngularJS module defines an application
 * The module is the container for differenct parts of your app
 */

/*
 * [] tells Angular to create a project with the name passed in
 * Not providing the [] will tell Angular one already exists
 */
var app = angular.module('myApp', []);

/*
 * The AngularJS app defined by ng-app="myApp" is running
 * inside of our body tag. We have also defined a controller
 * - myController - inside of the body tag.
 * myController was 
 */
var controller = app.controller('myController', function($scope) {
    
    $scope.fname = "";
    $scope.lname = "";
    $scope.fullName = function() {
        return $scope.fname + " " + $scope.lname;
    };
});
