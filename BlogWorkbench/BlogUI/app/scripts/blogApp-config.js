'use strict';

(function() {
   
    var blogAppConfig = angular.module('blogApp');

    blogAppConfig.constant('ENV', {NAME:'dev',SERVICE_ROOT:'http://localhost:8082/blogs'});
	blogAppConfig.constant('SECRETS', {FACEBOOK_APP_ID:'1818455765050005'});
    
})();

 