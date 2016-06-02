'use strict';

describe('Factory: fbUserToBlogUserConverter', function() {


  var fbUserToBlogUserConverter;

  beforeEach(module('blogApp'));

  beforeEach(inject(function(_FbUserToBlogUserConverter_) {
    fbUserToBlogUserConverter = new _FbUserToBlogUserConverter_();
  }));


  it('should convert the fb User to blog user', function() {
    var blogUser = fbUserToBlogUserConverter.convert({
      'id': '1234',
      'email': 'test@test.com',
      'first_name': 'firstName',
      'gender': 'male',
      'last_name': 'lastName',
      'name': 'Kuldeep Vijay Jadhav'
    });

    expect(blogUser.thirdPartyId).toEqual('1234');
    expect(blogUser.email).toEqual('test@test.com');
    expect(blogUser.firstName).toEqual('firstName');
    expect(blogUser.lastName).toEqual('lastName');
    expect(blogUser.loginType).toEqual('FB');
  });



});