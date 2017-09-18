
angular.module('app', []);

function myController($scope) {
	$scope.people = [
		person('Vladimir','Yevseenko'),
		person('Larisa','Yevseenko'),
		person('Andrey','Yevseenko'),
		person('Lyubov','Yevseenko'),
		person('Andrey','Alabin'),
		person('John','Cruz'),
		person('Sam','Lee'),
		person('John','Doe'),
		person('Jane','Doe')
		];
}

function person(firstName, lastName) {
	return {firstName: firstName, lastName: lastName};
}