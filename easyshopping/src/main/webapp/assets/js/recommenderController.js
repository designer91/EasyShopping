/*========================
  *   Products Controller  *
   ==========================*/

var app = angular.module('RecommenderApp', []);

app.controller('ReviewsController', function($http) {

	var prods = this;
	
	prods.reviews = [];
	
	prods.fetchReviews = function() {
		
		$http.get('/easyshopping/json/data/reviews')
			.then(function(response) {
				prods.reviews = response.data;
		});
				
	}
	
	
});

app.controller('RecommenderController', function($http) {
	
	var prods = this;
	
	prods.recommendedProducts = [];
	
	prods.fetchRecommendedProducts = function() {
		
		$http.get('/easyshopping/json/data/recommended/products')
		.then(function(response) {
			prods.mostViewdProducts = response.data;
		});
		
	}
	
	
});
