<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Recommendations</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}/recommendations.css">

</head>

<body >

<div class="container-fluid" ng-app="EasyShoppingApp" ng-controller="ProductController as prodCtrl">
						
	<div class="row" ng-init="prodCtrl.fetchProducts()">
		
		<div class="col-md-12">
		
			<h2>Recommended <b>Products</b></h2>
		
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0">
		
			<!-- Wrapper for carousel items -->
			<div class="carousel-inner">
				<div class="item carousel-item active">
					<div class="row">
						<div class="col-sm-3" ng-repeat="product in prodCtrl.allRecommendations">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img ng-src="${images}/{{product.productCode}}.jpg"
											alt="{{product.productName}}" class="landingImg">									
								</div>
								<div class="thumb-content">
									
									<p class="item-name"><b>{{product.productName}}</b></p>
									<p class="item-price"><span>{{product.productPrice}} dhs</span></p>
									
									<a ng-href="${contextRoot}/show/{{product.productID}}/product"
										class="btn btn-primary">
										<span class="glyphicon glyphicon-eye-open"></span>
										View
									</a>
									<a ng-href="${contextRoot}/cart/add/{{product.productID}}/product"
										 class="btn btn-primary" >
										 <span class="glyphicon glyphicon-shopping-cart"></span>
										 Add to Cart
									</a>
									
								</div>						
							</div><br>
						</div>
						
					</div>
				</div>
				
			
			</div>
			
			<!-- Carousel controls 
			<a class="carousel-control left carousel-control-prev" href="#myCarousel" data-slide="prev">
				<i class="fa fa-angle-left"></i>
			</a>
			<a class="carousel-control right carousel-control-next" href="#myCarousel" data-slide="next">
				<i class="fa fa-angle-right"></i>
			</a>-->
			
		</div>
		
		</div>
		
	</div>
	
</div>

<!-- AngularJS Files -->

<script src="${js}/angular.js"></script>
<script src="${js}/productsController.js"></script>

</body>
</html>                                		                            