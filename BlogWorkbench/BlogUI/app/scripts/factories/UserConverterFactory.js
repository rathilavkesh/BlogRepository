'use strict';

(function() {
	angular.module('blogApp').factory('UserConverterFactory', ['FacebookToBlogUserFactory', function(FacebookToBlogUserFactory) {
		return {
			'generateConverter': function(type) {
				switch(type) {
					case 'FB':
						return new FacebookToBlogUserFactory();
				}
			}
		};
	}]);
})();