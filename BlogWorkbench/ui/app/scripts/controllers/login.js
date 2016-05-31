'use strict';


angular.module('blogApp')
	.controller('LoginCtrl', ['$scope', '$mdDialog', function($scope, $mdDialog) {

		$scope.cancel = function() {
			$mdDialog.hide();
		}

	}]);