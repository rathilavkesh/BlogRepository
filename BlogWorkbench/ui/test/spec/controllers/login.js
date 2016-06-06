'use strict';

describe('Controller: MainCtrl', function() {



  var scope, controller, mdDialog, rootScope, facebook, UserService, UserConverterFactory;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, $location, _NavigationFactory_, $mdDialog, _facebook_, _UserService_, _UserConverterFactory_) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    controller = $controller;
    mdDialog = $mdDialog;
    facebook = _facebook_;
    UserService = _UserService_;
    UserConverterFactory = _UserConverterFactory_;

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

    spyOn(UserConverterFactory, 'generateConverter').and.callFake(function() {
      return {
        'convert': function() {
          return {
            'firstName': 'firstName',
            'lastName': 'lastName',
            'thirdPartyId': '1234',
            'loginType': 'FB'
          };
        }
      }
    });

    spyOn(UserService, 'create').and.callFake(function() {
      return {
        '$promise': {
          'then': function(success) {
            success({});
          }
        }
      };
    });

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
    expect(UserConverterFactory.generateConverter).toHaveBeenCalled();
    expect(UserService.create).toHaveBeenCalledWith({
      'firstName': 'firstName',
      'lastName': 'lastName',
      'thirdPartyId': '1234',
      'loginType': 'FB'
    });

  });

});