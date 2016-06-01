'use strict';

describe('Controller: MainCtrl', function() {



  var scope, controller, mdDialog, rootScope, facebook;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, $location, _NavigationFactory_, $mdDialog, _facebook_) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    controller = $controller;
    mdDialog = $mdDialog;
    facebook = _facebook_;
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

  it('should call facebook for login', function() {

    spyOn(facebook, 'loginToFacebook').and.callFake(function() {
      return {
        'then': function(success) {
          success({});
        }
      };
    });

    createController();
    scope.loginToFacebook();
    expect(facebook.loginToFacebook).toHaveBeenCalled();

  });

});