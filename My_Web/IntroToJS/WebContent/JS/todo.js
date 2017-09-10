/**
 * 
 */

var app = angular.module('todoApp', []);

app.controller('todoCtlr', function($scope) {

    $scope.items = [{ action:"Get haircut", done:false },
                    { action:"Finish Project 1", done:false },
                    { action:"Get groceries", done:true }];
    $scope.addNewItem = function(newAction) {
        $scope.items.push({ action:newAction, done:false });
    };

    $scope.incompleteCount = function() {
        var count = 0;
        $scope.items.forEach(function(item){
            if (!item.done) {
                count++;
            }
        });
        return count;
    };
});

app.filter('doneItems', function() {
    return function(items, showDone) {
        var ret = [];

        angular.forEach(items, function(item) {
            if (!item.done || showDone) {
                ret.push(item);
            }
        });

        return ret;
    };
});
