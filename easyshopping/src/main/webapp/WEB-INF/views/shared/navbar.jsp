<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

	<div class="container">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#the-menu" aria-expanded="false"
				aria-label="Toggle navigation">
				  <span class="icon-bar top-bar"></span>
				  <span class="icon-bar middle-bar"></span>
				  <span class="icon-bar bottom-bar"></span>
			</button>

			<a class="navbar-brand" href="${contextRoot}/home">
				EasyShopping
			</a>
			
			<%-- <a class="navbar-brand" href="${contextRoot}/home">
				<img class="logo" src="${images}/logo-2.png" alt="">
			</a> --%>

		</div>

		<div class="collapse navbar-collapse" id="the-menu">

			<ul class="nav navbar-nav">
			
				<li id="listProducts">
					<a href="${contextRoot}/show/all/products">
						<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
						&#160;Show Products
					</a>
				</li>
			
				<security:authorize access="hasAuthority('ADMIN')">
			
					<li id="manageProducts">
						<a href="${contextRoot}/manage/products">
							<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							&#160;manage products
						</a>
					</li>
				
				</security:authorize>
				
				<security:authorize access="hasAuthority('USER')">
			
					<li id="recommendations">
						<a href="${contextRoot}/all/recommendations">
							<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
							&#160;recommended products
						</a>
					</li>
				
				</security:authorize>
				
				<li id="about">
					<a href="${contextRoot}/about">
						<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
						&#160;About
					</a>
				</li>
			
				<li id="contact">
					<a href="${contextRoot}/contact">
						<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
						&#160;Contact
					</a>
				</li>
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				
				<security:authorize access="isAnonymous()">
				
					<li id="register">
						<a href="${contextRoot}/register">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							&#160;sign up
						</a>
					</li>
					
					<li id="login">
						<a href="${contextRoot}/login">
							<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
							&#160;Login
						</a>
					</li>
				
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">				
				
					<li class="dropdown" id="userCart">
						
						<a href="javascript.void(0)" class="dropdown-toggle"
							id="dropdownMenu1" data-toggle="dropdown">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							&#160;${userModel.fullName}
							<span class="caret"></span>
						</a>
						
						<ul class="dropdown-menu">
							
							<security:authorize access="hasAuthority('USER')">
							
								<li>
									
									<a href="${contextRoot}/cart/show">
										
										<span class="glyphicon glyphicon-shopping-cart"></span>
										&#160;
										<span class="badge">${userModel.cart.cartLines}</span> 
										- ${userModel.cart.grandTotal} dhs
										
									</a>
									
								</li>
								
							
								<li class="divider" role="separator"></li>
	
							</security:authorize>	
				
	
							<li>
							
								<a href="${contextRoot}/perform-logout">
									<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
									&#160;Logout
								</a>	
							
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


