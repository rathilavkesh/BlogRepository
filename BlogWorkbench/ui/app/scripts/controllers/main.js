'use strict';

angular.module('todoApp')
	.controller('MainCtrl', ['$scope', '$mdSidenav', '$mdDialog', '$timeout', '$log', function($scope, $mdSidenav, $mdDialog, $timeout, $log) {


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
				.then(function() {

				}, function() {

				});
		}

		function DialogController($scope, $mdDialog) {
			$scope.textAngularOptions = [
				['bold', 'italics', 'underline', 'strikeThrough', 'ul', 'ol', 'redo', 'undo', 'clear'],
				['justifyLeft', 'justifyCenter', 'justifyRight', 'indent', 'outdent'],
				['charcount']
			];

			$scope.hide = function() {
				$mdDialog.hide();
			};

			$scope.submit = function(answer) {
				$mdDialog.hide();
			};
		}

	}]);