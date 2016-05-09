'use strict';
var App = angular.module('todoApp');
App.directive( 'editInPlace', function() {
  return {
    restrict: 'E',
    scope: { value: '=' },
    template: '<span class="todoName" ng-click="edit()" ng-bind="value"></span><input class="todoField" ng-model="value"></input>',
    link: function ( $scope, element ) {
      var inputElement = angular.element( element.children()[1] );
      element.addClass( 'edit-in-place' );

      $scope.editing = false;

      // ng-click handler to activate edit-in-place
      $scope.edit = function () {
        $scope.editing = true;

        // We control display through a class on the directive itself. See the CSS.
        element.addClass( 'active' );
        inputElement.focus();
      };

      // When we leave the input, we're done editing.
      inputElement.on("blur",function  () {
        $scope.editing = false;
        element.removeClass( 'active' );
      });

    }
  };
});
