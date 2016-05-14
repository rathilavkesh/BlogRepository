'use strict';

console.log('loading controller');
angular.module('blogApp')
	.controller('MainCtrl', ['$scope', '$mdSidenav', '$mdDialog', '$timeout', '$log', function($scope, $mdSidenav, $mdDialog, $timeout, $log) {

		$scope.selected = "";
		$scope.subjects = [{
			'name': 'Java'
		}, {
			'name': 'Javascript'
		}];
		$scope.toggleMenu = toggleMenu;
		$scope.openAddBlogPage = openAddBlogPage;

		function toggleMenu() {
			$mdSidenav('left').toggle();
		}

		function selectLanguage(selectLang) {
			self.selected = selectLang;
		}

	
		function openAddBlogPage(ev) {
			console.log('openAddBlogPage called');
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