'use strict';

angular.module('todoApp')
	.controller('MainCtrl', ['$mdSidenav', '$mdDialog', '$timeout', '$log', function($mdSidenav, $mdDialog, $timeout, $log) {


		var self = this;
		self.selected = "";
		self.subjects = [{
			'name': 'Java'
		}, {
			'name': 'Javascript'
		}];
		self.toggleMenu = toggleMenu;
		self.openAddBlogPage = openAddBlogPage;

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


		function openAddBlogPage(ev) {
			$mdDialog.show({
					controller: DialogController,
					templateUrl: 'views/add.html',
					parent: angular.element(document.body),
					targetEvent: ev,
					clickOutsideToClose: true
				})
				.then(function(answer) {
					$scope.status = 'You said the information was "' + answer + '".';
				}, function() {
					$scope.status = 'You cancelled the dialog.';
				});
			$scope.$watch(function() {
				return $mdMedia('xs') || $mdMedia('sm');
			}, function(wantsFullScreen) {
				$scope.customFullscreen = (wantsFullScreen === true);
			});
		}

		function DialogController($scope, $mdDialog) {
			$scope.hide = function() {
				$mdDialog.hide();
			};
			
			$scope.submit = function(answer) {
				$mdDialog.hide();
			};
		}

	}]);