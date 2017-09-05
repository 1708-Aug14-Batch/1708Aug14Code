
var app = angular.module('calcApp',[]);


app.controller('calcCtrl',function($scope){
	$scope.values = [];
/*
	$scope.calc = function(){
			angular.forEach($scope.values, function(value){
				if(value.op == "+"){
					value.rs = value.v1+value.v2;
				}else if(value.op == "-"){
					value.rs = value.v1-value.v2;
				}else if(value.op == "*"){
					value.rs = value.v1*value.v2;
				}else if(value.op == "/"){
					value.rs = value.v1/value.v2;
				}
			})	
			console.log($scope.rs);
	}*/

	$scope.addValues = function(value1,value2,operator){
		$scope.values.push({v1: value1, v2: value2, op: operator, rs: (value1+value2)
		})
	};
	$scope.subValues = function(value1,value2,operator){
		$scope.values.push({v1: value1, v2: value2, op: operator, rs: (value1-value2)
		})
	};
	$scope.mulValues = function(value1,value2,operator){
		$scope.values.push({v1: value1, v2: value2, op: operator, rs: (value1*value2)
		})
	};
	$scope.divValues = function(value1,value2,operator){
		$scope.values.push({v1: value1, v2: value2, op: operator, rs: (value1/value2)
		})
	};

//$scope.calc(value1,value2,operator)
/*
result: function(){
				if(operator == "+"){
					return value1+value2;
					//result.arr.push(val.v1+val.v2);
				}else if(operator == "-"){
					return value1-value2;
					//result.arr.push(val.v1-val.v2);
				}else if(operator == "*"){
					return value1*value2;
					//result.arr.push(val.v1*val.v2);
				}else if(operator == "/"){
					return value1/value2;
					//result.arr.push(val.v1/val.v2);
				}
		}
*/

	
/*
	$scope.result = function(){
			angular.forEach($scope.values, function(val){
				if(val.op == "+"){
					result.arr.push(val.v1+val.v2);
				}else if(val.op == "-"){
					result.arr.push(val.v1-val.v2);
				}else if(val.op == "*"){
					result.arr.push(val.v1*val.v2);
				}else if(val.op == "/"){
					result.arr.push(val.v1/val.v2);
				}
			})
	}*/
})