(function() {
	'use strict';

	angular.module('blogApp')
		.controller('LoginCtrl', ['$scope', '$mdDialog', '$log', 'facebook', 'UserConverterFactory', 'UserService', function($scope, $mdDialog, $log, facebook, UserConverterFactory, UserService) {

			$scope.cancel = function() {
				$mdDialog.hide();
			};

			$scope.loginToFacebook = function() {
				var promise = facebook.loginToFacebook();
				promise.then(function(response) {
					$log.log('Response is ', response);
					var userObj = UserConverterFactory.generateConverter('FB').convert(response);
					saveUserObject(userObj);
				});
			};

			function saveUserObject(userObj) {
				var promise = UserService.create(userObj);
				promise.$promise.then(function(data) {
					$log.log('User saved to database is ', data);
				});
			}

		}]);

})();