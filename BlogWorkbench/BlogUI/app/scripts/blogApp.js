/**
 * @ngdoc overview
 * @name blogApp
 * @description
 * # blogApp
 *
 * Main module of the application.
 */
(function() { 
    'use strict';

    var blogApp = angular.module('blogApp', ['ngAnimate', 'ngCookies', 'ngResource', 'ngRoute', 'ngSanitize', 
            'ngTouch', 'ngMaterial', 'ngMdIcons', 'textAngular', 'blogApp.secrets']);

    blogApp.config(function($routeProvider, $httpProvider) {
          delete $httpProvider.defaults.headers.common['X-Requested-With'];
          
          $routeProvider
            .when('/', {
              templateUrl: 'partial/views/home.html'
            })
            .when('/addblog', {
              templateUrl: 'partial/views/add.html'
            })
            .otherwise({
              redirectTo: '/'
            });
    });

})();
