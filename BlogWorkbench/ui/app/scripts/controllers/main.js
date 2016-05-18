'use strict';


angular.module('blogApp')
	.controller('MainCtrl', ['$scope', '$mdSidenav', '$timeout', '$log', '$location', 'NavigationFactory', function($scope, $mdSidenav, $timeout, $log, $location, NavigationFactory) {

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

		$scope.toggleMenu = toggleMenu;
		$scope.openAddBlogPage = openAddBlogPage;
		$scope.goToHome = goToHome;



	}]);