<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="bootstrap" value="/resources/bootstrap"/>
<spring:url var="images" value="/resources/images/"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>    

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EasyShopping - ${title}</title>

	<script type="text/javascript">
		window.menu = '${title}';
		window.contextRoot = '${contextRoot}';
	</script>
	
    <!-- Bootstrap Core CSS -->
    <link href="${bootstrap}/css/bootstrap.min.css" rel="stylesheet">
 
    <!-- Bootstrap DataTable CSS -->
    <link href="${bootstrap}/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${bootstrap}/css/app.css" rel="stylesheet">
    
    <!-- less CSS 
    <link href="${bootstrap}/less/bootstrap.less" rel="stylesheet/less"/> -->

</head>

<body>

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
		  
		</div>
	
		<!-- Footer -->
		
	    <%@ include file="./shared/footer.jsp" %>
	
		<!--// js files //-->
		
	    <!-- jQuery -->
	    <script src="${bootstrap}/js/jquery.js"></script>
	    
	    <!-- Bootstrap Core JavaScript -->
	    <script src="${bootstrap}/js/bootstrap.min.js"></script>
	    
	   	<!-- jQuery DataTables -->
	    <script src="${bootstrap}/js/jquery.dataTables.js"></script>
	    <script src="${bootstrap}/js/dataTables.bootstrap.js"></script>
	    
	    <!-- less bootstrap
	    <script src="${bootstrap}/js/less.js"></script> --> 
	    
	    <!-- customized js -->
	    <script src="${bootstrap}/js/customized.js"></script>
	
	</div>
</body>

</html>
