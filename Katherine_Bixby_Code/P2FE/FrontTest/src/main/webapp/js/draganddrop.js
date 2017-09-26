






















angular.module('demo', ['dndLists']).controller('DemoController', function($scope) {
	
	$scope.model = [generateList(1), generateList(2)];

	$scope.onDrop = function(srcList, srcIndex, targetList, targetIndex) {
		targetList.splice(targetIndex, 0, srcList[srcIndex]); // Copy the item from source to target.
		
		if (srcList == targetList && targetIndex <= srcIndex){ // Remove the item from the source, possibly correcting the index first.
			srcIndex++; // We must do this immediately, otherwise ng-repeat complains about duplicates.
		}
		srcList.splice(srcIndex, 1);
		
		return true; // By returning true from dnd-drop we signalize we already inserted the item.
	};

	function generateList(id) {
		return ['A', 'B', 'C'].map(function(letter) {
			// angular-drag-and-drop-lists usually serializes the objects to drag, thus we
			// can not transfer functions on the objects. However, as this fiddle uses dnd-callback
			// to move the objects directly without serialization, we can use a function reference
			// on the item here.
			return {
				labelFunc: function(index) {
					return "Item " + id + letter + " at index " + index;
				}
			};
		});
	}
});


