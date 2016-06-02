'use strict';

angular.module('blogApp').factory('UserConverterFactory', ['FbUserToBlogUserConverter', function(FbUserToBlogUserConverter) {
	return {
		'generateConverter': function(type) {
			switch(type) {
				case 'FB':
					return new FbUserToBlogUserConverter();
			}
		}
	};
}]);