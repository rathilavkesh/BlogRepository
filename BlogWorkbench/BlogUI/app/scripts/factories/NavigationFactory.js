'use strict';

(function() {
	angular.module('blogApp').factory('NavigationFactory', ['$location', function($location) {
		return {
			'goToHome': function() {
				$location.path('/');
			},
			'goToAddBlog': function() {
				$location.path('/addblog');
			}
		};
	}]);
})();