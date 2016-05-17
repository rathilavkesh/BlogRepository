'use strict';

describe('Factory: ToasterFactory', function() {



  var ToasterFactory, mdToast;

  beforeEach(module('blogApp'));

  beforeEach(inject(function(_ToasterFactory_, $mdToast) {
    ToasterFactory = _ToasterFactory_;
    mdToast = $mdToast;
  }));



  it('should show a simple toaster', function() {
    spyOn(mdToast, "show");
    spyOn(mdToast, "simple").and.callFake(function() {
      return {
        'textContent': function(message) {
          expect(message).toEqual('Test Message');
        }
      };
    });
    ToasterFactory.showSimpleToast('Test Message');
    expect(mdToast.show).toHaveBeenCalled();
  });


});