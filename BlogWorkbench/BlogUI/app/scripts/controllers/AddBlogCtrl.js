(function() {
	'use strict';


	angular.module('blogApp')
		.controller('AddBlogCtrl', ['$scope', 'BlogService', 'ToasterFactory', function($scope, BlogService, ToasterFactory) {

			$scope.userId = '55ed90730631f2622794a6c6';
			$scope.blog = {
				'title': '',
				'content': ''
			};

			$scope.tags = [];

			$scope.create = function() {
				var user = $scope.userId;
				var content = $scope.blog.content;
				var date = new Date();

				var promise = BlogService.create({}, {
					'content': content,
					'submittedBy': user,
					'submittedDate': date
				});


				promise.$promise.then(function(data) {
					ToasterFactory.showSimpleToast('Blog saved successfully');
				});

			}

		}]);

})();