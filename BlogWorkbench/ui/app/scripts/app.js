'use strict';

/**
 * @ngdoc overview
 * @name blogApp
 * @description
 * # blogApp
 *
 * Main module of the application.
 */

angular
  .module('blogApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.sortable',
    'ngMaterial',
    'textAngular',
    'blogApp.config'
  ])
  .config(function($routeProvider, $mdThemingProvider, $httpProvider) {
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    $mdThemingProvider.theme('default')
      .primaryPalette('brown')
      .accentPalette('red');
    $routeProvider
      .when('/', {
        templateUrl: 'views/landing.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });