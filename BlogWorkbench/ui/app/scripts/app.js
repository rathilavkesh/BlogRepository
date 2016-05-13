'use strict';

/**
 * @ngdoc overview
 * @name todoApp
 * @description
 * # todoApp
 *
 * Main module of the application.
 */
angular
  .module('todoApp', [
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
        templateUrl: 'views/test.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });