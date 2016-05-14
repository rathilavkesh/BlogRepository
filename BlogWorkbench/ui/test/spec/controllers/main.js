'use strict';

describe('Controller: MainCtrl', function() {



  var scope, controller, mockMdSideNav, rootScope, mockMdDialog;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    mockMdSideNav = function() {};
    mockMdDialog = {};
    controller = $controller;
  }));


  function createController() {
    controller('MainCtrl', {
      '$scope': scope,
      '$mdSidenav': mockMdSideNav,
      '$mdDialog': mockMdDialog
    });
  }

  it('should toggle the menu when toggle menu function is called', function() {
    var mockToggleObj = {
      'toggle': function() {}
    }
    mockMdSideNav = function(side) {
      expect(side).toEqual('left');
      return mockToggleObj;
    };

    spyOn(mockToggleObj, 'toggle');
    createController();
    scope.toggleMenu();
    expect(mockToggleObj.toggle).toHaveBeenCalled();
  });

  it('should open the dialog for adding the blog when create is clicked', function() {
    mockMdDialog = {
      'show':  function(params) {
        expect(params).toBeDefined();
        return {
          'then': function(success, error) {
            success();
          }
        }
      }
    };
    spyOn(mockMdDialog, 'show').and.callThrough();
    createController();
    scope.openAddBlogPage({});
    expect(mockMdDialog.show).toHaveBeenCalled();

  });


});