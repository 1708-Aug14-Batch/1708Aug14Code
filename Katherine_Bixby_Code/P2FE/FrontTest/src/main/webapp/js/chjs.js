var app = angular.module("chapterApp",[]);

app.controller("chCtrl",function($scope){
	
	$scope.chapters = [
		{
			"title": "Chapter 1",
			"id": 1,
			"description": "This is chapter 1",
			"locations": [
				{
					"title":"Location 4",
					"id":"l4"
				},
				{
					"title":"Location 5",
					"id":"l5"
				}
			]
		},
		{
			"title": "Chapter 2",
			"id": 2,
			"description": "This is chapter 2",
			"locations": [
				{
					"title":"Location 6",
					"id":"l6"
				},
				{
					"title":"Location 7",
					"id":"l7"
				}
			]
		}
	];
	
	$scope.sidebarlocations = [
		{
			"title":"Location 1",
			"id":"l1"
		},
		{
			"title":"Location 2",
			"id":"l2"
		},
		{
			"title":"Location 3",
			"id":"l3"
		}
	];
	
	
	/*
	 * DESPERATELY NEED TO FIGURE OUT A NEW WAY TO GENERATE AN ID FOR THE LOCATIONS
	 * BUT THAT WILL MOST LIKELY BE DONE WITH BACKEND ANYWAYS
	 * SO IT'S FINE??
	 */
	$scope.addLocal = function(newlocaltitle,newlocalid){
		console.log("ADDING NEW LOCAL: "+newlocaltitle);
		$scope.sidebarlocations.unshift(
				{"title":newlocaltitle,
				"id":"l"+newlocalid
				}
		);
	};
	
	
	$scope.sayhi = function(){
		this.isCarry = true;
	};
	
	$scope.saybye = function(){
		if(this.isCarry==true){
			console.log("Being Dragged: "+event.target.id);
			console.log("Dropped at ID: "+event.relatedTarget.id);
			var dropLocType = document.getElementById(event.relatedTarget.id).className;
			console.log(dropLocType);
			if(dropLocType=="list-group-item ng-binding"){
				console.log("Dropped on a location!");
				console.log("Parent Node: "+document.getElementById(event.relatedTarget.parentNode.id));
				console.log("New Node: "+document.getElementById(event.target.id));
				console.log("Reference Node: "+document.getElementById(event.relatedTarget.id));
				var theParent = document.getElementById(event.relatedTarget.parentNode.id);
				var theNew = document.getElementById(event.target.id);
				var theRef = document.getElementById(event.relatedTarget.id);
				
				theParent.insertBefore(theNew,theRef);
				
				
				//parentNode.insertBefore(newNode,referenceNode);
			}
			else if(dropLocType=="panel-body ng-binding"){
				console.log("Dropped in a chapter!");
				console.log("Parent Node: "+document.getElementById(event.relatedTarget.firstChild.id));
				console.log("New Node: "+document.getElementById(event.target.id));
				console.log("Reference Node: "+document.getElementById(event.relatedTarget.id));
			}
			
		}
		this.isCarry=false;
	}
	
	/*
	 * DESPERATELY NEED TO FIGURE OUT A NEW WAY TO GENERATE AN ID FOR THE CHAPTERS
	 * BUT THAT WILL MOST LIKELY BE DONE WITH BACKEND ANYWAYS
	 * SO IT'S FINE??
	 */
	$scope.addChapter = function(newchaptertitle,newchapterid,newchapterdescription){
		console.log("ADDING NEW CHAPTER: "+newchaptertitle);
		$scope.chapters.unshift(
				{"title":newchaptertitle,
				"id":newchapterid,
				"description":newchapterdescription
				}
		);
	};
	
});



