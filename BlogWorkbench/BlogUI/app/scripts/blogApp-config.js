(function() {
	'use strict';
   
    var blogAppConfig = angular.module('blogApp');

    blogAppConfig.constant('ENV', {NAME:'dev',SERVICE_ROOT:'http://localhost:8082/blogs'});
    
})();

 