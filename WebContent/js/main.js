
var app = angular.module('myApp', ['ngRoute']);
app
.config(function($httpProvider) {
	$httpProvider.defaults.headers.post['Content-Type'] = "application/json; charset=UTF-8";
	$httpProvider.defaults.headers.post['Data-Type'] = "json";
});

app.controller(
				"LoginController",
				function($scope, $http) {
				

					$scope.loginForm = {};
					$scope.projectList = null;

					$scope.loginForm.getDetails = function() {
						
						
							$scope.loginForm.message = null;
							var data = angular.fromJson($scope.loginForm);
						
							var responsePromise = $http.post("http://35.237.77.96:8080/LoginApplication/api/BuildAPI/Details" , data);
						
							
							responsePromise
									.then(
											function(response) {
												$scope.error="";
												window.location = "home.html";
											},
											function(response) {
												alert(response);
												 $scope.error = "Incorrect username/password !";
											});
						
					}

					
				});

