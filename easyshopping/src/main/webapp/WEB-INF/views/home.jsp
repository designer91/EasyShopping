<!-- Home Page -->

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<div class="container" ng-app="EasyShoppingApp" ng-controller="ProductController as prodCtrl">

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
								<img class="slide-image" src="${images}/photo-1522.jpeg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/ecommerce-2140603.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/laptop-1483974__480.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/photo-152.jpeg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/photo-147214.jpeg"
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
		
		<!-- ================================================================================= -->
			
		<!-- Recommended Products -->

		<security:authorize access="hasAuthority('USER')">	

			<div class="row">
				<div class="col-xs-12">
					<h3>Recommended <b>Products</b></h3>
				</div>
			</div>
	
			<!-- =========================================================================== -->
			
			<br><br>
			
			<div class="row is-table-row">

				<div class="col-sm-4"
					ng-repeat="product in prodCtrl.recommendations">

					<div class="thumbnail">

						<div class="card-product">

							<img ng-src="${images}/{{product.productCode}}.jpg"
								alt="{{product.productName}}" class="landingImg">
								
							<div class="card-productbody">

								<h4 class="card-title">{{product.productName}}</h4>

								<h5 class="card-text">{{product.productPrice}} dhs</h5>
								
								<!-- Button -->
								<a ng-href="${contextRoot}/show/{{product.productID}}/product"
									class="btn btn-primary" style="margin-left: 8px">
									<span class="glyphicon glyphicon-eye-open"></span></a>
							
								<a ng-href="${contextRoot}/cart/add/{{product.productID}}/product"
									class="btn btn-success pull-left">
									<span class="glyphicon glyphicon-shopping-cart"></span></a>
									
								<br>

							</div>

						</div>

					</div>


				</div>
				
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>More Recommendations</h4>
					<hr />
					<a class="btn btn-primary" 
							href="${contextRoot}/all/recommendations">
							More Recommendations
					</a>
					
				</div>
				
			</div>
		
			<div>
				<hr style="color: #000; background: #919185; height: 4px;">
			</div>
		
		</security:authorize>
	
		
			<!-- =========================================================================== -->
					
			<!-- Most Viewd Products -->

			<div class="row">
				<div class="col-xs-12">
					<h3>Most Viewed <b>Products</b></h3>
				</div>
			</div>
		
			<br><br>
			
			<!-- =========================================================================== -->

			<div class="row is-table-row">

				<div class="col-sm-4"
					ng-repeat="product in prodCtrl.mostViewdProducts">

					<div class="thumbnail">

						<div class="card-product">

							<img ng-src="${images}/{{product.productCode}}.jpg"
								alt="{{product.productName}}" class="landingImg">
							
							<div class="card-productbody">

								<h4 class="card-title">{{product.productName}}</h4>

								<h5 class="card-text">{{product.productPrice}} dhs</h5>
								
								<!-- Button -->
								<a ng-href="${contextRoot}/show/{{product.productID}}/product"
									class="btn btn-primary" style="margin-left: 8px">
									<span class="glyphicon glyphicon-eye-open"></span></a>
							
							<security:authorize access="hasAuthority('USER')">	
								
								<a ng-href="${contextRoot}/cart/add/{{product.productID}}/product"
									class="btn btn-success pull-left">
									<span class="glyphicon glyphicon-shopping-cart"></span></a>
									
								<br>

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

			<div>
				<hr style="color: #000; background: #919185; height: 4px;">
			</div>

			<!-- =========================================================================== -->
	
			<div class="row">
				<div class="col-xs-12">
					<h3>Most Purchased <b>Products</b></h3>
				</div>
			</div>
			
			<br><br>
			
			<div class="row is-table-row">
	
				<div class="col-sm-4"
					ng-repeat="product in prodCtrl.mostPurchasedProducts">
					
					<div class="thumbnail">
					
						<!-- Card -->
					<div class="card-product">
					
					  <!-- Card image -->
					  <img ng-src="${images}/{{product.productCode}}.jpg"
								alt="{{product.productName}}" class="landingImg">
					
					  <!-- Card content -->
					  <div class="card-body">
					
					    <!-- Title -->
					    <h4 class="card-title">{{product.productName}}</h4>
					    <!-- Text -->
					    <h5 class="card-text">{{product.productPrice}} /dhs</h5>
					   
					    <!-- Button -->
					    <a ng-href="${contextRoot}/show/{{product.productID}}/product"
						   class="btn btn-primary"  style="margin-left:8px">
						   <span class="glyphicon glyphicon-eye-open"></a>
						   
						<security:authorize access="hasAuthority('USER')">	
								
							<a ng-href="${contextRoot}/cart/add/{{product.productID}}/product"
								class="btn btn-success pull-left">
							<span class="glyphicon glyphicon-shopping-cart"></span></a>
														
							<br><br>

						</security:authorize>	
					
						<br>
					
					  </div>	
					
					</div>
					<!-- Card -->
						
					</div>
				
				</div>
				
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>More products</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all//products">More
						Products</a>
				</div>
				
			</div>	
			
			<!-- =========================================================================== -->

		</div>
	
	</div>

</div>

<!-- /.container -->

<!-- AngularJS Files -->

<script src="${js}/angular.js"></script>
<script src="${js}/productsController.js"></script>