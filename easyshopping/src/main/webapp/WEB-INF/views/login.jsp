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
    <meta name="author" content="">
	
	<link rel="icon" href="${images}/easyshopping-logo.png" type="image/png" sizes="16x16">
	
    <title>EasyShopping - ${title}</title>

	<script type="text/javascript">
		window.menu = '${title}';
		window.contextRoot = '${contextRoot}';
	</script>
	
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/app.css" rel="stylesheet"> 
    
    <!-- less CSS -->
    <link href="${less}/bootstrap.less" rel="stylesheet/less"/> 

</head>

<body>

	<div class="wrapper">

	    <!-- Navigation -->
		    
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	       <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
		            <a class="navbar-brand" href="${contextRoot}/home">EasyShopping</a>
		        </div>
			</div>
		</nav>	
	
	
		<!-- Page Content -->
		
		<div class="content">

			<div class="container">
				
				<!-- error message displayed when the user provide wrong credentials -->
				
				<c:if test="${not empty message}">
					
					<div class="row">

						<div class="col-md-offset-3 col-md-6">
						
							<div class="alert alert-danger alert-dissmissible">
								<button type="button" class="close" data-dissmiss="alert">&times;</button>
								${message}
							</div>
						
						</div>
					
					</div>
					
				</c:if>
				
				<!-- this message displayed when the user logged out -->
				
				<c:if test="${not empty logout}">
					
					<div class="row">

						<div class="col-md-offset-3 col-md-6">
						
							<div class="alert alert-success alert-dissmissible">
								<button type="button" class="close" data-dissmiss="alert">&times;</button>
								${logout}
							</div>
						
						</div>
					
					</div>
					
				</c:if>
				
				<div class="row">

					<div class="col-md-offset-3 col-md-6">
	
						<div class="panel panel-warning">
	
							<div class="panel-heading">
								<h4>Login</h4>
							</div>
	
							<div class="panel-body">
							
								<form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
								
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-default" />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
										</div>
									</div>
								</form>
	
							</div>
							
							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register</a>
								</div>
							</div>
	
						</div>
	
					</div>
	
				</div>
				
				
			</div>

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

	    
	    <!-- less bootstrap -->
	    <script src="${js}/less.js"></script>  
	    
	    <!-- customized js -->
	    <script src="${js}/customized.js"></script>
	   
	
	</div>
</body>

</html>

