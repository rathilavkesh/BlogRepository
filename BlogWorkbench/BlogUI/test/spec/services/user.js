/**
 * Created by jadhavk
 */
'use strict';

describe('Service: UserService ', function() {

    var UserService, httpBackend, ENV;

    beforeEach(module('blogApp'));

    beforeEach(inject(function(_UserService_, $httpBackend, _ENV_) {
        UserService = _UserService_;
        httpBackend = $httpBackend;
        ENV = _ENV_;
    }));

    

    it('should save the user properly', function() {
        httpBackend.whenPOST(ENV.SERVICE_ROOT + '/user/add').respond(function(requestMethod, requestUrl, data, headers) {
            expect(data).toBeDefined();
            return [200, {
                '_id': '1234'
            }];
        });

        var date = new Date();
        var promise = UserService.create({} ,{
            'thirdPartyId': '1234',
            'firstName': 'firstName',
            'lastName': 'lastName',
            'loginType': 'FB'

        });
        httpBackend.flush();
        promise.$promise.then(function(data) {
            expect(data).toBeDefined();
        });

    });

    
});