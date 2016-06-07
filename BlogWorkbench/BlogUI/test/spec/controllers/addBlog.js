'use strict';

describe('Controller: AddBlogCtrl', function() {



  var scope, controller, BlogService, rootScope, ToasterFactory, mdDialog;

  beforeEach(module('blogApp'));

  beforeEach(inject(function($rootScope, $controller, _BlogService_, _ToasterFactory_) {
    rootScope = $rootScope;
    scope = rootScope.$new();
    controller = $controller;
    BlogService = _BlogService_;
    ToasterFactory = _ToasterFactory_;
    
  }));


  function createController() {
    
    controller('AddBlogCtrl', {
      '$scope': scope,
      'BlogService': BlogService
    });
  }

  it('should call the service to save the blog', function() {

    spyOn(ToasterFactory, 'showSimpleToast');

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
    scope.blog= {};
    scope.blog.content = 'TestBlog';
    scope.create();
    expect(BlogService.create).toHaveBeenCalled();
    expect(ToasterFactory.showSimpleToast).toHaveBeenCalledWith('Blog saved successfully');
  });


 


});