/*========================
  *   Products Controller  *
   ==========================*/

var app = angular.module('EasyShoppingApp', [

]);

app.controller('ProductController', function($http) {

	var prods = this;
	
	prods.mostViewdProducts = [];
	prods.mostPurchasedProducts = [];
	
	prods.fetchProducts = function() {
		
		$http.get('/easyshopping/json/data/mostviewd/products')
			.then(function(response) {
				prods.mostViewdProducts = response.data;
		});
			
			
		$http.get('/easyshopping/json/data/mostpurchased/products')
		.then(function(response) {
			prods.mostPurchasedProducts = response.data;
		});
				
	}
	
	
});
