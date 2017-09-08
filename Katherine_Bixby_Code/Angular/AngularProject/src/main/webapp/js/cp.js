
var cp = angular.module('myCP',[]);

cp.controller('myCtrl',function($scope){
	$scope.count = 0;
	$scope.myFunc = function(){
		$scope.count++;
	}
	$scope.redVal = 0;
	$scope.greenVal = 0;
	$scope.blueVal = 0;
	$scope.myRGB = function(){
		return "RGB("+$scope.redVal+","+$scope.greenVal+","+$scope.blueVal+")";
			
	}
	$scope.rgbToHex = function(){
		return $scope.toHex($scope.redVal)+$scope.toHex($scope.greenVal)+$scope.toHex($scope.blueVal);
	}
	$scope.hex = "#FFFFFF";
	$scope.toHex = function(n){
		n = parseInt(n,10);
		if (isNaN(n)) return "00";
		n = Math.max(0,Math.min(n,255));
		$scope.hex = "0123456789ABCDEF".charAt((n-n%16)/16)
	      + "0123456789ABCDEF".charAt(n%16)
		return $scope.hex;
	}
	
	
	
	
	
	
})
