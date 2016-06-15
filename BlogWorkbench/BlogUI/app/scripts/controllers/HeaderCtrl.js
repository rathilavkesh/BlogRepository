(function() {
	'use strict';


	angular.module('blogApp')
		.controller('HeaderCtrl', ['$scope', '$window', '$mdSidenav', '$timeout', '$log', '$location', 'NavigationFactory', '$mdDialog', function($scope, $window, $mdSidenav, $timeout, $log, $location, NavigationFactory, $mdDialog) {

			var vm = this;
						
			vm.openAddBlogPage = function() {				
				NavigationFactory.goToAddBlog();
			};

			vm.goToHome = function() {				
				NavigationFactory.goToHome();
			};

			vm.openLoginDialog = function(ev) {
				$mdDialog.show({
					controller: 'LoginCtrl',
					templateUrl: 'partial/views/login.html',
					parent: angular.element($window.document.body),
					targetEvent: ev,
					clickOutsideToClose: true
				});
			};			
	}]);	

})();