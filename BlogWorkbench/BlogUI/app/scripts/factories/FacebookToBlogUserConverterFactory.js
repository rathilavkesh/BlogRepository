(function() {
	'use strict';

	angular.module('blogApp').factory('FacebookToBlogUserConverterFactory', [function() {

		var Converter = function() {};
		Converter.prototype.convert = function(fbUser) {
			var blogUser = {};
			blogUser.loginType = "FB";
			if (fbUser) {
				if (fbUser.id) {
					blogUser.thirdPartyId = fbUser.id;
				}

				if (fbUser.email) {
					blogUser.email = fbUser.email;
				}

				if (fbUser.first_name) {
					blogUser.firstName = fbUser.first_name;
				}

				if (fbUser.last_name) {
					blogUser.lastName = fbUser.last_name;
				}
			}

			return blogUser;
		};

		return Converter;
	}]);

})();