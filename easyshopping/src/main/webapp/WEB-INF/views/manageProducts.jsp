<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
		
		<div class="row">
			
			<c:if test="${not empty message}">
						
				<div class="col-xs-12 col-md-offset-2 col-md-8">			
					<div class="alert alert-info fade in">
						${message}
					</div>				
				</div>
			
			</c:if>
				
		</div>
	
	
	<div class="row">

		<div class="col-md-offset-2 col-md-8">
	
		<!-- panel start -->

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Manage Products</h4>

				</div>

				<div class="panel-body">
				
					 <sf:form class="form-horizontal" modelAttribute="product" 
								action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
				
						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								
								<sf:input type="text" path="productName" class="form-control" placeholder="Product Name" />
								<sf:errors path="productName" cssClass="help-block" element="em"/> 
							
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">SKU</label>
							<div class="col-md-8">
								
								<sf:input type="text" path="productSKU" class="form-control" placeholder="Product SKU" />
								<sf:errors path="productSKU" cssClass="help-block" element="em"/> 
							
							</div>
						</div>
					
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								
								<sf:textarea path="productDesc" class="form-control" rows="5"
												placeholder="Enter a description for product" /> 
								<sf:errors path="productDesc" cssClass="help-block" element="em"/>
							
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Price</label>
							<div class="col-md-8">
							
								<sf:input type="number" path="productPrice" class="form-control"
									placeholder="Enter a Price" />
								<sf:errors path="productPrice" cssClass="help-block" element="em"/>
							
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity</label>
							<div class="col-md-8">
							
								<sf:input type="number" path="productQuantity" class="form-control"
												placeholder="Enter Quantity" />
								<sf:errors path="productQuantity" cssClass="help-block" element="em"/> 
							
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Upload image</label>
							<div class="col-md-8">
							
								<sf:input type="file" path="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								
								<sf:select path="categoryID" items="${categories}" itemLabel="categoryName" 
											itemValue="categoryID" class="form-control"/>
							
								<div class="text-right">
									<br/>		
									<sf:hidden path="productID"/>
									<sf:hidden path="productSKU"/>
									<sf:hidden path="supplierID"/>
									<sf:hidden path="active"/>														
									<button type="button" class="btn btn-warning btn-xs" data-toggle="modal" 
												data-target="#myCategoryModal">Add New Category</button>
								</div>							
							</div>
							
						</div>
					
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-4">
							
								<input type="submit" name="submit" value="Save" class="btn btn-primary"/>
								
							</div>
						</div>						
										
					</sf:form>

				</div>

			</div>
		
		<!-- .panel end -->
		
		</div>

	</div>

	
	<!-- Admin Table Control -->
	
	<hr/>	
	<h1>Available Products</h1>
	<hr/>
	
	<div class="row">
				
		<div class='col-xs-12'>
		
			<table id="productsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>SKU</th>
						<th>Qty. </th>
						<th>Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>

				<tbody>					
					
					<tr>					
						<th>13</th>
						<th>
							<img class="adminTableImg" src="${contextRoot}/resources/images/PRD-1AD47AE8FC.jpg" />
						</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>
							<label class="switch">
								<input type="checkbox" checked="checked" value="13"/>
								<div class="slider"></div>
							</label>
						</th>				
						<th>
							<a href="${contextRoot}/manage/13/product" class="btn btn-warning">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
						</th>
					</tr>									
					<tr>					
						<th>13</th>
						<th>
							<img class="adminTableImg" src="${contextRoot}/resources/images/PRD-1AD47AE8FC.jpg" />
						</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>
							<label class="switch">
								<input type="checkbox" value="13"/>
								<div class="slider"></div>
							</label>
						</th>				
						<th>
							<a href="${contextRoot}/manage/13/product" class="btn btn-warning">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
						</th>
					</tr>				
							
				</tbody>
				
				<tfoot>
				
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>SKU</th>
						<th>Qty. </th>
						<th>Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>	
					
												
				</tfoot>
				
							
			</table>
		
		
		</div>
	
	

<%-- 	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">New Category</h4>
	      </div>
	      <div class="modal-body">
	        
	        <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	        	        
	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>	        
	        </sf:form>
	      </div>
	    </div>
	  </div>
	</div>
	
	

	
	</div> --%>

</div>