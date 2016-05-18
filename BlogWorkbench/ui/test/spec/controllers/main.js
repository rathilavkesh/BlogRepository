'use strict';

describe('Controller: MainCtrl', function() {



  var scope, controller, mockMdSideNav, rootScope, location, NavigationFactory;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, $location, _NavigationFactory_) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    mockMdSideNav = function() {};
    controller = $controller;
    location = $location;
    NavigationFactory = _NavigationFactory_;
  }));


  function createController() {
    controller('MainCtrl', {
      '$scope': scope,
      '$mdSidenav': mockMdSideNav
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

  it('should take to add blog page for adding the blog when create is clicked', function() {
    spyOn(NavigationFactory, 'goToAddBlog');
    createController();
    scope.openAddBlogPage({});
    expect(NavigationFactory.goToAddBlog).toHaveBeenCalled();
    expect(scope.hideSideMenu).toBeTruthy();
  });


  it('should navigate to home page', function() {
    spyOn(NavigationFactory, 'goToHome');
    createController();
    scope.goToHome({});
    expect(NavigationFactory.goToHome).toHaveBeenCalled();
    expect(scope.hideSideMenu).toBeFalsy();
  });


});