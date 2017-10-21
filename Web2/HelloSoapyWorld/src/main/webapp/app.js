/**
 * 
 */

var app = angular.module("app", []);


app.controller("feedbackController",function($scope){
	$scope.trainee = {firstName: "Yahya, ",
			lastName: "Hossain",
			panelistName: "Rajesh Yamunachari",
			track: "Java",
			PanelRound: 1,
			Consent: "Yes",
			RecordingLink: "",
			InterviewDate: "29-JUL-17",
			InterviewTime: "10:00 AM",
			InterviewMode: "Skype",
			OverallFeedback: "Pass",
			InternetConnectivity: "Stable"}
	
	$scope.feedback = [
		{technology: "java",
			result: "good",
			repanel: "yes",
			comment: "decent"}
	]
			
});
