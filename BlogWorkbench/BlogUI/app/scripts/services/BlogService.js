(function() {
	'use strict';

	angular.module('blogApp').service('BlogService', ['$resource', 'ENV', function($resource, ENV) {
		return $resource(ENV.SERVICE_ROOT + '/:dest1/:dest2', {}, {
			create: {
				method: 'POST',
				params: {
					dest1: 'blog',
					dest2: 'add' 
				}
			}
		});
	}]);

})();