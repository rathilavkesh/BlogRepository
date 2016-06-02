'use strict';

angular.module('blogApp').factory('StorageFactory', [function() {
	return {
		'setLoginStatus': function(status) {
			localStorage.setItem('isLoggedIn', status);
		}
	};
}]);