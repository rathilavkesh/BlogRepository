(function() {
	'use strict';

	angular.module('blogApp').factory('UserConverterFactory', ['FacebookToBlogUserConverterFactory', function(FacebookToBlogUserFactory) {
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