'use strict';

angular.module('todoApp')
  .controller('AddCtrl', ['$http', '$scope', '$location', 'constants', function ($http, $scope, $location, constants) { 
    $scope.addToDo = function () {
      $http.post(constants.BACKEND_SERVER_URL+'todo/add', {'name': $scope.name, 'description': $scope.description, 'dueDate': $scope.dueDate}, function (response) {
        console.log(response);
      }).error(function (error) {
        console.log(error);
        $scope.errorMsg = error.message;
      });
      $location.path('/list');
    };
  }]);
