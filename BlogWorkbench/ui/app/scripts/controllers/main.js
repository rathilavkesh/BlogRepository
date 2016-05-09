'use strict';

angular.module('todoApp')
	.controller('MainCtrl', ['$mdSidenav', '$mdBottomSheet', '$timeout', '$log', function($mdSidenav, $mdBottomSheet, $timeout, $log) {


		var self = this;
		self.selected="";
		self.subjects = [{
			'name': 'Java'
		}, {
			'name': 'Javascript'
		}];
		self.toggleMenu = toggleMenu;

		// *********************************
		// Internal methods
		// *********************************

		/**
		 * Hide or Show the 'left' sideNav area
		 */
		function toggleMenu() {
			$mdSidenav('left').toggle();
		}

		function selectLanguage(selectLang) {
			self.selected = selectLang;
		}

		/**
		 * Select the current avatars
		 * @param menuId
		 */
		function selectUser(user) {
			self.selected = angular.isNumber(user) ? $scope.users[user] : user;
		}

	}]);


