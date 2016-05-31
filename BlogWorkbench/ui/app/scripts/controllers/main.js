'use strict';


angular.module('blogApp')
	.controller('MainCtrl', ['$scope', '$mdSidenav', '$timeout', '$log', '$location', 'NavigationFactory', '$mdDialog', function($scope, $mdSidenav, $timeout, $log, $location, NavigationFactory, $mdDialog) {

		$scope.selected = "";
		$scope.hideSideMenu = false;
		$scope.subjects = [{
			'name': 'Java'
		}, {
			'name': 'Javascript'
		}];


		function toggleMenu() {
			$mdSidenav('left').toggle();
		}

		function selectLanguage(selectLang) {
			self.selected = selectLang;
		}


		function openAddBlogPage() {
			$scope.hideSideMenu = true;
			NavigationFactory.goToAddBlog();
		}

		function goToHome() {
			$scope.hideSideMenu = false;
			NavigationFactory.goToHome();
		}

		function openLoginDialog(ev) {
			$mdDialog.show({
				controller: 'LoginCtrl',
				templateUrl: 'views/login.html',
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			});

		}

		$scope.toggleMenu = toggleMenu;
		$scope.openAddBlogPage = openAddBlogPage;
		$scope.goToHome = goToHome;
		$scope.openLoginDialog = openLoginDialog;



	}]);