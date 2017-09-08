


var app = angular.module('calcApp', []);



app.filter('wholePartFilter', function() {
	return function(value) {
		return Math.trunc(value);
	};
});


app.filter('absFilter', function() {
	return function(value) {
		return Math.abs(value);
	};
});