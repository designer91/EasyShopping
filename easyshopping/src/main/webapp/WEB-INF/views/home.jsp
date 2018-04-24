<!-- Home Page -->

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="container" ng-app="EasyShoppingApp"
	ng-controller="ProductController as prodCtrl">

	<div class="row" ng-init="prodCtrl.fetchProducts()">

		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img class="slide-image" src="${images}/img-carousel-4.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/img-carousel-2.png"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/img-carousel-3.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/img-carousel-4.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/img-carousel-5.jpg"
									alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>

				

			<!-- Most Viewd/Purchased Products -->

			<div class="row">
				<div class="col-xs-12">
					<h3>Most Viewed Products</h3>
					<hr />
				</div>
			</div>
	
			<!-- =========================================================================== -->

			<div class="row is-table-row">

				<div class="col-lg-4 col-md-6 mb-4"
					ng-repeat="product in prodCtrl.mostViewdProducts">

					<div class="thumbnail">

						<div class="card-product">

							<a href="${contextRoot}/show/{{product.productID}}/product">
								<img ng-src="${images}/{{product.productCode}}.jpg"
								alt="{{product.productName}}" class="landingImg">
							</a>
							
							<hr>
								
							<div class="card-productbody">

								<h4 class="card-title">{{product.productName}}</h4>

								<h5 class="card-title">{{product.productPrice}} dhs</h5>

								<p class="card-text">{{product.productDesc}}</p>	
								
								<hr>
								
								<!-- Button -->
								<a ng-href="${contextRoot}/show/{{product.productID}}/product"
									class="btn btn-primary" style="margin-left: 8px">View &#160;
									<span class="glyphicon glyphicon-eye-open"></span></a>
							
							<security:authorize access="hasAuthority('USER')">	
								
								<a ng-href="${contextRoot}/cart/add/{{product.productID}}/product"
									class="btn btn-success pull-left"> Add to Cart &#160;
									<span class="glyphicon glyphicon-shopping-cart"></span></a>
											
									
								<br><br>


							</security:authorize>	
							
				
							

							</div>

						</div>

					</div>


				</div>
				
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>More products</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>
				
				<br><br>


			</div>



			<!-- =========================================================================== -->
	
	
	
			<div class="row">
				<div class="col-xs-12">
					<h3>Most Purchased Products</h3>
					<hr />
				</div>
			</div>
			
			
			<div class="row is-table-row">
	
				<div class="col-sm-4"
					ng-repeat="product in prodCtrl.mostPurchasedProducts">
					
					<div class="thumbnail">
					
						<!-- Card -->
					<div class="card-product">
					
					  <!-- Card image -->
					  <img ng-src="${images}/{{product.productCode}}.jpg"
								alt="{{product.productName}}" class="landingImg">
					
					  <hr>	
					
					  <!-- Card content -->
					  <div class="card-productbody">
					
					    <!-- Title -->
					    <h4 class="card-product-title">{{product.productName}}</h4>
					    <!-- Text -->
					    <h3 class="card-product-text">{{product.productPrice}} /dhs</h3>
					    <p class="card-product-text">{{product.productDesc}}</p>
					    
					    <hr>
					    
					    <!-- Button -->
					    <a ng-href="${contextRoot}/show/{{product.productID}}/product"
						   class="btn btn-primary pull-right">View</a>
					
						<br>
					
					  </div>	
					
					</div>
					<!-- Card -->
						
					</div>
				
				</div>
				
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>More products</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>
				
			</div>
			
			
			<%-- <div class="row is-table-row">
	
				<div class="col-sm-4"
					ng-repeat="product in prodCtrl.mostPurchasedProducts">
					<div class="thumbnail">
						<img ng-src="${images}/{{product.productCode}}.jpg"
							alt="{{product.productName}}" class="landingImg">
				  		<h3>&ensp;{{product.productName}}</h3>
						<div class="caption">
							<h4 class="pull-right">{{product.productPrice}} /dhs</h4>
							<p>{{product.productDesc}}</p>
							<a ng-href="${contextRoot}/show/{{product.productID}}/product"
								class="btn btn-primary pull-right">View</a>
						</div>
					</div>
				</div>
	
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>More products</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>
	
			</div> --%>
			
			
			<!-- =========================================================================== -->





		</div>


		
	</div>


</div>

<!-- /.container -->

<!-- AngularJS Files -->

<script src="${js}/angular.js"></script>
<script src="${js}/productsController.js"></script>
