var bankApp = angular.module("bankApp", ["ui.router"]);

bankApp.config(function($stateProvider, $urlRouterProvider){
	console.log("init bank app..");

	$stateProvider
	.state("login",{
		url:"/login",
		templateUrl: "templates/login.html",// html 
		controller: "LoginCtrl as login"// ng controller			
	})
	.state("register",{
		url: "/register",
		templateUrl: "templates/register.html",
		controller: "RegisterCtrl as register"
	})
	.state("home",{
		url:"/home",
		templateUrl: "templates/home.html",
		controller: "HomeCtrl as home"
	});	
});


/*
 * In AngularJS, a service is a function or object that is 
 * available for, and limited to, your AngularJS application.
 * Angular has about 30 built in services like $http
 * https://docs.angularjs.org/api/ng/service/$q
 */
bankApp.service("UserService", function($http, $q){
	console.log("in userService");

	var service = this;

	service.user={
			username : "",
			password : "",
			authenticated : false
	};

	service.getUser= function(){
		return service.user;
	};

	service.setUser = function(data){
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};

	service.authenticateUser = function(){
		var promise = $http.post(
				'rest/user/auth', service.user)
				.then(
						function(response){
							console.log(response);
							return response;
						},
						function(error){
							console.log('login promise fail');
						}
				);
		return promise;
	};

	service.registerUser = function(){

		var promise;

		promise = $http.post(
				'rest/user/register',service.user
		).then(// can pass in and register up to three callback functions [success, error, notified(which is sort of like a finally)]
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

});

bankApp.controller("HomeCtrl", function(UserService,$state){
	console.log("in homeCtrl");
	var home = this;
	home.user = UserService.getUser();
});

bankApp.controller("LoginCtrl", function(UserService, $state){
	console.log("in loginctrl");

	var login = this;
	login.user = UserService.getUser();

	login.doLogin = function(){
		console.log("about to authenticate user");
		var promise = UserService.authenticateUser();
	
		promise.then(
				function(response){
					if(login.user!= null){
						login.user.authenticated = true;
						UserService.setUser(response.data);
						console.log("setting user in login ctrl")
						console.log(UserService.getUser());
						$state.go("home");
					} else{
						alert("Invalid login!");
					}
				},function(error){
					console.log(error);
				});
	
	};
});

bankApp.controller("RegisterCtrl", function(UserService, $state){
	console.log("in registerctrl");

	var register = this;

	register.user = UserService.getUser();

	register.doRegister = function(){

		var promise = UserService.registerUser();

		promise.then(
				function(response){
					console.log("setting data");
					console.log(response.data);
					UserService.setUser(response.data);
					$state.go('login');

				}, function(error){
					console.log(error);
				}	
		)
	}
});

bankApp.controller("NavCtrl", function($state){
	console.log("in navctrl");
})
