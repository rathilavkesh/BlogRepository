'use strict';


angular.module('blogApp')
	.controller('AddBlogCtrl', ['$scope', 'BlogService',  function($scope, BlogService) {

		$scope.userId = '55ed90730631f2622794a6c5';
		$scope.blog= {};

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
				console.log('Data saved is ', data);
			});

		}

	}]);