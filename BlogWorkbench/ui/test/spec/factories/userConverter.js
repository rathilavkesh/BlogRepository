'use strict';

describe('Factory: UserConverterFactory', function() {


  var userConverterFactory, fbUserToBlogUserConverter;

  beforeEach(module('blogApp'));

  beforeEach(inject(function(_UserConverterFactory_, _FbUserToBlogUserConverter_) {
    userConverterFactory = _UserConverterFactory_;
    fbUserToBlogUserConverter = _FbUserToBlogUserConverter_;
  }));

  it('should return the converter based on the arg passed', function() {

    var converter = userConverterFactory.generateConverter('FB');
    expect(converter instanceof fbUserToBlogUserConverter).toEqual(true);
  });

});