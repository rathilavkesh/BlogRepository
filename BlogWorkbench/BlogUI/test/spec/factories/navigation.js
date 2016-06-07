'use strict';

describe('Factory: NavigationFactory', function() {

  var NavigationFactory, location;

  beforeEach(module('blogApp'));

  beforeEach(inject(function(_NavigationFactory_, $location) {
    NavigationFactory = _NavigationFactory_;
    location = $location;
  }));



  it('should navigate to home page', function() {
    spyOn(location, "path");
    NavigationFactory.goToHome();
    expect(location.path).toHaveBeenCalledWith('/');
  });


  it('should go to add blog page', function() {
    spyOn(location, "path");
    NavigationFactory.goToAddBlog();
    expect(location.path).toHaveBeenCalledWith('/addblog');
  });


});