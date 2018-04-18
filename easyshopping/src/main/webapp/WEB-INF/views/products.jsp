<div class="container">

	<div class="col-md-3">
	
		<%@ include file="./shared/sidebar.jsp" %>
	
	</div>
	
	<div class="col-md-9">
	
		<div class="row">
		
			<div class="col-lg-12">
				
				<c:if test="${userClickAllProducts == true}">
				
					<script>
						window.categoryID = '';
					</script>
				
					<ol class="breadcrumb">
						
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
						
					</ol>
				
				</c:if>
				
				<c:if test="${userClickCategoryProducts == true}">
				
					<script>
						window.categoryID = '${category.categoryID}';
					</script>
				
					<ol class="breadcrumb">
						
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">category</li>
						<li class="active">${category.categoryName}</li>
						
					</ol>
				
				</c:if>
				
			</div>	
			
		</div>
	
		<div class="row">
		
			<div class="col-xs-12">
		
				<div class="container-fluid">
				
					<div class="table-responsive">
					
						<table id="productsTable" class="table table-striped table-bordered">
		
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th></th>
								</tr>
							</thead>
							
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th></th>				
								</tr>
							</tfoot>
						
						</table>
		
					
					</div>
				
				</div>
				
				
			</div>
		
		</div>
	
	</div>
	
</div>
<br><br><br>