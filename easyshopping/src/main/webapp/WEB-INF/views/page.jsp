<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="less" value="/resources/less"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images/"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>    

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Nabil Azri">

	<meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}">

    <title>EasyShopping - ${title}</title>

	<script type="text/javascript">
		window.menu = '${title}';
		window.contextRoot = '${contextRoot}';
	</script>
	
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
 
    <!-- Bootstrap DataTable CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/app.css" rel="stylesheet">
    
    <!-- less CSS -->
    <link href="${less}/bootstrap.less" rel="stylesheet/less"/>
    

</head>

<body>

	<!-- Loader -->
	<div class="se-pre-con"></div>

	<div class="wrapper">

	    <!-- Navigation -->
	  	<%@ include file="./shared/navbar.jsp" %>
	
		<!-- Page Content -->
		
		<div class="content">
			
		    <c:if test="${userClickHome == true}">
		    	<%@ include file="home.jsp" %>
		    </c:if>
		    <!-- load only when the user click about -->
		    <c:if test="${userClickAbout == true}">
		    	<%@ include file="about.jsp" %>
		    </c:if>
		    <!-- load only when the user click contact -->
		    <c:if test="${userClickContact == true}">
		    	<%@ include file="contact.jsp" %>
		    </c:if>
		    <!-- load only when the user click view products -->
		    <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
		    	<%@ include file="products.jsp" %>
		    </c:if>
		    <!-- load when a user click view a ingle product -->
		    <c:if test="${userClickViewProduct == true}">
		    	<%@ include file="singleProduct.jsp" %>
		    </c:if>
		    <!-- load when a user click manage products -->
		    <c:if test="${userClickManageProduct == true}">
		    	<%@ include file="manageProducts.jsp" %>
		    </c:if>
		    <!-- load when a user click show cart -->
		    <c:if test="${userClickShowCart == true}">
		    	<%@ include file="cart.jsp" %>
		    </c:if>
		  
		</div>
	
		<!-- Footer -->
		
	    <%@ include file="./shared/footer.jsp" %>
	
		<!--============= js files =============-->
		
	    <!-- jQuery -->
	    <script src="${js}/jquery.js"></script>

	    <!-- jQuery Validator -->
	    <script src="${js}/jquery.validate.min.js"></script>
	    
	    <!-- Bootstrap Core JavaScript -->
	    <script src="${js}/bootstrap.min.js"></script>
  
	   	<!-- jQuery DataTables -->
	    <script src="${js}/jquery.dataTables.min.js"></script>
	    <script src="${js}/dataTables.bootstrap.min.js"></script>
	    
	    <!-- less bootstrap --> 
	    <script src="${js}/less.js"></script> 
	   
	    <!-- bootbox js -->
	    <script src="${js}/bootbox.min.js"></script>
	    
	    <!-- customized js -->
	    <script src="${js}/customized.js"></script>
	   
	
	</div>
</body>

</html>
