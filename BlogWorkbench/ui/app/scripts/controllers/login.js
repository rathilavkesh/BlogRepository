'use strict';


angular.module('blogApp')
	.controller('LoginCtrl', ['$scope', '$mdDialog', 'facebook', function($scope, $mdDialog, facebook) {

		$scope.cancel = function() {
			$mdDialog.hide();
		}

		$scope.loginToFacebook = function() {
			var promise = facebook.loginToFacebook();
			promise.then(function(response) {
				console.log('Response is ', response);
			});
		};

	}]);