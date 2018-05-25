/*========================
  *   Products Controller  *
   ==========================*/

var app = angular.module('EasyShoppingApp', [
	
]);

app.controller('ProductController', function($http) {

	var prods = this;
	
	prods.mostViewdProducts = [];
	prods.mostPurchasedProducts = [];
	
	prods.recommendations = [];
	prods.allRecommendations = [];
	
	prods.fetchProducts = function() {
		
		$http.get('/easyshopping/json/data/mostviewd/products')
			.then(function(response) {
				prods.mostViewdProducts = response.data;
		});
			
			
		$http.get('/easyshopping/json/data/mostpurchased/products')
		.then(function(response) {
			prods.mostPurchasedProducts = response.data;
		});
		
		
		// recommendations:
		
		$http.get('/easyshopping/json/data/recommendations/products')
		.then(function(response) {
			prods.recommendations = response.data;
		});
			
		$http.get('/easyshopping/json/data/all/recommendations/products')
		.then(function(response) {
			prods.allRecommendations = response.data;
		});
		
	}
	
	
});
