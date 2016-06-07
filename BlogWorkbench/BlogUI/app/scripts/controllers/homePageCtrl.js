(function() {
	'use strict';


	angular.module('blogApp')
		.controller('HomePageCtrl', ['$scope', '$mdSidenav', '$timeout', '$log', '$location', 'NavigationFactory', '$mdDialog', function($scope, $mdSidenav, $timeout, $log, $location, NavigationFactory, $mdDialog) {

			var vm = this;
			vm.selected = "";
			vm.hideSideMenu = false;
			vm.subjects = [{
				'name': 'Java'
			}, {
				'name': 'Javascript'
			}];


			vm.toggleMenu = function() {
				$mdSidenav('left').toggle();
			};

			vm.selectLanguage = function(selectLang) {
				self.selected = selectLang;
			};

			vm.openAddBlogPage = function() {
				$scope.hideSideMenu = true;
				NavigationFactory.goToAddBlog();
			};

			vm.goToHome = function() {
				$scope.hideSideMenu = false;
				NavigationFactory.goToHome();
			};

			vm.openLoginDialog = function(ev) {
				$mdDialog.show({
					controller: 'LoginCtrl',
					templateUrl: 'partial/views/login.html',
					parent: angular.element(document.body),
					targetEvent: ev,
					clickOutsideToClose: true
				});
			};			
	}]);	

})();