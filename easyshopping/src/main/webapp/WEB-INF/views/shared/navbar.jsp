<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

	<div class="container">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#the-menu" aria-expanded="false"
				aria-label="Toggle navigation">
				<div class="animated-icon1">
					<span></span><span></span><span></span>
				</div>
			</button>
			

			<a class="navbar-brand" href="${contextRoot}/home">EasyShopping</a>

		</div>

		<div class="collapse navbar-collapse" id="the-menu">

			<ul class="nav navbar-nav">
			
				<li id="about"><a href="${contextRoot}/about">About</a></li>
			
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
			
				<li id="listProducts"><a href="${contextRoot}/show/all/products">Show Products</a></li>
			
				<security:authorize access="hasAuthority('ADMIN')">
			
					<li id="manageProducts"><a href="${contextRoot}/manage/products">manage products</a></li>
				
				</security:authorize>
			
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				
				<security:authorize access="isAnonymous()">
				
					<li id="register"><a href="${contextRoot}/register">sign up</a></li>
					
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
				
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">				
				
					<li class="dropdown" id="userCart">
						
						<a href="javascript.void(0)" class="dropdown-toggle"
							id="dropdownMenu1" data-toggle="dropdown">
							${userModel.fullName}
							<span class="caret"></span>
						</a>
						
						<ul class="dropdown-menu">
							
							<security:authorize access="hasAuthority('USER')">
							
								<li>
									
									<a href="${contextRoot}/cart/show">
										
										<span class="glyphicon glyphicon-shopping-cart"></span>
										
										<span class="badge">${userModel.cart.cartLines}</span> - ${userModel.cart.grandTotal} dhs
										
									</a>
									
								</li>
								
							
								<li class="divider" role="separator"></li>
	
							</security:authorize>	
				
	
							<li>
							
								<a href="${contextRoot}/perform-logout">Logout</a>	
							
							</li>
							
						</ul>
							
					</li>
				
				
				</security:authorize>
				
				
			</ul>
		
		</div>
		
		<!-- /.navbar-collapse -->
	
	</div>
	
	<!-- /.container -->

</nav>

<script>

	window.userRole = '${userModel.role}';
	
</script>


