'use strict';

angular.module('todoApp')
  .controller('LoginCtrl', ['$scope', '$http', '$location', 'constants', function ($scope, $http, $location, constants) {
    $scope.logIn = function () {
      var loginData = {'name': $scope.username, 'password': $scope.password};
      $http.post(constants.BACKEND_SERVER_URL + 'login', loginData).success(function(res){
        console.debug(res);
        $scope.successMsg = 'Logged in successfully';
        $location.path('/list');
      }).error(function(err){
        $scope.errorMsg = err.message;
      });
    };
  }]);
