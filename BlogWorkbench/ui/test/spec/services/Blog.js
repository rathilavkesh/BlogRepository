/**
 * Created by jadhavk
 */
'use strict';

describe('Service: BlogService ', function() {

    var BlogService, httpBackend, ENV;

    beforeEach(module('blogApp'));

    beforeEach(inject(function(_BlogService_, $httpBackend, _ENV_) {
        BlogService = _BlogService_;
        httpBackend = $httpBackend;
        ENV = _ENV_;
    }));

    

    it('should save the blog properly', function() {
        httpBackend.whenPOST(ENV.SERVICE_ROOT + '/blog/add').respond(function(requestMethod, requestUrl, data, headers) {
            expect(data).toBeDefined();
            return [200, {
                'success': 'postcreated'
            }];
        });

        var date = new Date();
        var promise = BlogService.create({} ,{
            'content': 'TestBlog',
            'submittedBy': '55ed90730631f2622794a6c5',
            'submittedDate': date

        });
        httpBackend.flush();
        promise.$promise.then(function(data) {
            expect(data).toBeDefined();
            expect(data.success).toBe('postcreated');
        });

    });

    
});