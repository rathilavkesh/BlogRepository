'use strict';

describe('Factory: StorageFactory', function() {


  var StorageFactory;

  beforeEach(module('blogApp'));

  beforeEach(inject(function(_StorageFactory_) {
    StorageFactory = _StorageFactory_;
  }));


  it('should store the user login status in localStorage', function() {
    spyOn(localStorage, 'setItem');
    StorageFactory.setLoginStatus(true);
    expect(localStorage.setItem).toHaveBeenCalledWith('isLoggedIn', true);
  });

});