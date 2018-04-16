<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
				
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.productName}</li>
			
			</ol>
		
		</div>
	
	</div>
	
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${images}/${product.productSKU}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
	
		<!-- Display the product description -->	
		<div class="col-xs-12 col-sm-8">
		
			<h3>${product.productName}</h3>
			<hr/>
			
			<p>${product.productDesc}</p>
			<hr/>
			
			<h4>Price: <strong> ${product.productPrice} dhs /-</strong></h4>
			<hr/>
			
			<c:choose>
				<c:when test="${product.productQuantity < 1}">
					<h6>Qty. Available: <span style="color:red">Out of Stock</span></h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available:  ${product.productQuantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.productQuantity < 1}">
					<a href="javasctipt:void(0)" class="btn btn-success disabled">
					<span class="glyphicon glyphicon-shopping-cart"></span> <del>Add to Cart</del></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.productID}/product" class="btn btn-success">
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				</c:otherwise>
			</c:choose>
			

					<a href="${contextRoot}/show/all/products/${product.productID}/product" class="btn btn-info">
					back to shop</a>
					
		</div>

	</div>

</div>