<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="lead">Categories</p>
<div class="list-group">

	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.categoryID}/products" 
		  	class="list-group-item"
		  	 id="a_${category.categoryName}">${category.categoryName}</a> 		
	</c:forEach>

</div>
