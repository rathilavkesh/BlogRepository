 /*global FB*/
 'use strict';

 (function() {
     angular.module('blogApp').provider('facebook', function facebookProvider() {
         
         this.$get = ['$q', function facebookFactory($q) {
             return {
                 'loginToFacebook': function() {
                     var deferred = $q.defer();
                     FB.login(function(response) {
                         if (response.authResponse) {
                             var accessToken = FB.getAuthResponse().accessToken;
                             FB.api('/me', function(response) {
                                 response.accessToken = accessToken;
                                 deferred.resolve(response);
                             });
                         } else {
                             deferred.reject('facebook login failed');
                         }
                     }, {
                         scope: 'public_profile,email,user_likes'
                     });
                     return deferred.promise;
                 },

                 'checkLoginStatus': function() {
                     var deferred = $q.defer();
                     try {
                         FB.getLoginStatus(function(response) {
                             switch (response.status) {
                                 case 'connected':
                                     var accessToken = FB.getAuthResponse().accessToken;
                                     FB.api('/me', function(response) {
                                         response.accessToken = accessToken;
                                         deferred.resolve(response);
                                     });
                                     //deferred.resolve(response);
                                     break;
                                 case 'not_authorized':
                                     deferred.reject('not authorized');
                                     break;
                                 case 'unknown':
                                     deferred.reject('not logged into facebook');
                                     break;
                             }
                         }, function(err) {
                             console.error(err);
                             deferred.reject('Error in logging into facebook');
                         });
                     } catch (err) {
                         console.error(err);
                         deferred.reject('Error in logging into facebook');
                     }
                     return deferred.promise;
                 },
                 'logOut': function() {
                     var deferred = $q.defer();
                     FB.logout(function(response) {
                         console.debug('Facebook user logged out successfully ' + JSON.stringify(response));
                         deferred.resolve('success');
                     });
                     return deferred.promise;
                 }
             };
         }];
     });


     angular.module('blogApp').run(['$window', 'SECRETS', function($window, SECRETS) {

         $window.fbAsyncInit = function() {
             FB.init({
                 'appId': SECRETS.FACEBOOK_APP_ID,
                 'cookie': true, // enable cookies to allow the server to access the session
                 'xfbml': true, // parse social plugins on this page
                 'version': 'v2.1' // use version 2.1
             });
         };

         //Loads the facebook sdk
         (function(d, s, id) {
             var js, fjs = d.getElementsByTagName(s)[0];
             if (d.getElementById(id)) {
                 return;
             }
             js = d.createElement(s);
             js.id = id;
             js.src = '//connect.facebook.net/en_US/sdk.js';
             fjs.parentNode.insertBefore(js, fjs);
         }(document, 'script', 'facebook-jssdk'));

     }]);

 })();