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
 
    <!-- Bootstrap DataTable CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/app.css" rel="stylesheet">
    
    <!-- less CSS -->
    <link href="${less}/bootstrap.less" rel="stylesheet/less"/>

</head>

<body>

	<div class="wrapper">
	
		<!-- Navigation -->

		<%@ include file="flows-navbar.jsp" %>
	
		<!-- Page Content -->
		
		<div class="content">
		
		</div>
		
	</div>