'use strict';

describe('Controller: AddBlogCtrl', function() {



  var scope, controller, BlogService, rootScope;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, _BlogService_) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    controller = $controller;
    BlogService = _BlogService_;

  }));


  function createController() {
    
    controller('AddBlogCtrl', {
      '$scope': scope,
      'BlogService': BlogService
    });
  }

  it('should call the service to save the blog', function() {
    spyOn(BlogService, 'create').and.callFake(function(urlParams, bodyParams) {
      expect(bodyParams).toBeDefined();
      expect(bodyParams.content).toEqual('TestBlog');
      expect(bodyParams.submittedBy).toEqual('55ed90730631f2622794a6c5');
      return {
        '$promise': {
          'then': function(success) {
            success({'_id': '1234'});
          }
        }
      }
    });

    createController();
    
    scope.userId = '55ed90730631f2622794a6c5';
    scope.content = 'TestBlog';
    scope.create();
    expect(BlogService.create).toHaveBeenCalled();


  });


});