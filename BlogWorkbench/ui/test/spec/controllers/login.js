'use strict';

describe('Controller: MainCtrl', function() {



  var scope, controller, mdDialog, rootScope;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, $location, _NavigationFactory_, $mdDialog) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    controller = $controller;
    mdDialog = $mdDialog;
  }));


  function createController() {
    controller('LoginCtrl', {
      '$scope': scope,
      '$mdDialog': mdDialog
    });
  }


  it('should close the dialog', function() {
    spyOn(mdDialog, 'hide');
    createController();
    scope.cancel();
    expect(mdDialog.hide).toHaveBeenCalled();
  });



});