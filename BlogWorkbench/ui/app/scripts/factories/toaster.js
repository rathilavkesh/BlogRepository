'use strict';

angular.module('blogApp').factory('ToasterFactory',['$mdToast', function($mdToast) {
	return {
		'showSimpleToast': function(message) {
			$mdToast.show($mdToast.simple().textContent(message));
		}
	};
}]);