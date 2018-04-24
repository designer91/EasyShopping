<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


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
			
		<c:if test="${not empty message}">
						
			<div class="col-xs-12 col-md-offset-2 col-md-8">			
				<div class="alert alert-success alert-dissmissible">
					<button type="button" class="close" data-dissmiss="alert">&times;</button>
					${message}
				</div>				
			</div>
			
		</c:if>
			
	</div>
	
	
	
	
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div>
							
				<img src="${images}/${product.productCode}.jpg" class="img img-responsive"/>
						
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
			
			<security:authorize access="hasAuthority('USER')">
			
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
				
			
			</security:authorize>

			<security:authorize access="hasAuthority('ADMIN')">
			
				<a href="${contextRoot}/manage/${product.productID}/product" class="btn btn-warning">
				<span class="glyphicon glyphicon-pencil"></span> Edit </a>
				
			</security:authorize>
			
			

			<a href="${contextRoot}/home" class="btn btn-info">Go Back</a>
					
		</div>

	</div>

	<br><br>
	
	<div class="row">

		<div class="col-xs-12 col-sm-8 pull-right">

		<security:authorize access="hasAuthority('USER')">

			<!-- Preview Form -->

			<sf:form method="post" modelAttribute="review" id="review"
				action="${contextRoot}/product/review?id=${product.productID}">

				<table border="2">

					<tr>
						
						<td>Rating</td>
						<td>
							<div id="rating"></div> 
							<input type="hidden" id="hiddenRating" name="hiddenRating">
						</td>

					</tr>

					<tr>
					
						<td>Message</td>
						<td><sf:textarea path="content"></sf:textarea></td>

					</tr>

					<tr>

						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Rate"
							class="btn btn-warning" /></td>
							<sf:hidden path="product.productID"/>	
							<sf:hidden path="user.userID"/>	

					</tr>

				</table>



			</sf:form>


		</security:authorize>
		

		</div>

	</div>




</div>
