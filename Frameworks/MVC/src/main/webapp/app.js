var bankApp = angular.module("bankApp",["ui.router"]);

bankApp.config(function($stateProvider,$urlRouterProvider){
	console.log("Config bank app");
	
	$stateProvider.state("login",{url:"/login",
								  templateUrl: "templates/login.html",
								  controller: "loginCtrl as login"
						})	
				  .state("register",{url:"/register",
					  				templateUrl:"templates/register.html",
					  				controller: "registerCtrl as register"
					    });	
});

bankApp.service("UserService", function($http, $q){
	console.log("in user service");
	
	var service = this;
	
	service.user={
			id : -1,
			username : "",
			password : "",
			authenticated : false
	};
	
	service.getUser = function(){
		return service.user;
	};
	
	service.setUser = function(data){
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};
	
	service.registerUser = function(){
		var promise;
		var user = JSON.stringify(service.user);
		console.log("sending " + JSON.stringify(service.user));
		console.log("sending " + String(service.user));
		promise = $http.post("/MVC/rest/user/register",user)
					.then(
							function(response){
								console.log(response);
								return response;
							},
							function(error){
								console.log('register user promise failed');
								return $q.reject(error);
							}
							);
		
		return promise;
	};
	
	
})

bankApp.controller("navCtrl", function($state){
	console.log("in navctrl");
});

bankApp.controller("loginCtrl", function($state){
	console.log("in loginctrl");
});
bankApp.controller("registerCtrl", function(UserService,$state){
	console.log("in registerctrl");
	
	var register = this;
	
	register.user = UserService.getUser();
	register.doRegister = function(){
		var promise = UserService.registerUser();
		promise.then(function(response){
			console.log(response);
			UserService.setUser(response.data);
			$state.go('login');
		}, function(error){
			console.log(error);
		});
	};
});