'use strict';

/**
 * @ngdoc overview
 * @name todoApp
 * @description
 * # todoApp
 *
 * Main module of the application.
 */

console.log('loading module');
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
    'textAngular'
  ])
  .config(function($routeProvider, $mdThemingProvider) {
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