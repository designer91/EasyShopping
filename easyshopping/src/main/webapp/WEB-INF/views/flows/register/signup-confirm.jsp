<%@ include file="../shared/flows-header.jsp" %>	
			
<div class="container-fluid">

	<div class="row">

		<!-- column to display the personal details -->
		<div class="col-sm-6">

			<div class="panel panel-warning">
				<div class="panel-heading">
					<h4>Personal Informations Details</h4>
				</div>
				<div class="panel-body">
					
					<!-- code to display the personal details -->
					<div class="text-center">
					
						<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
						<h4>E-mail: ${registerModel.user.email} </h4>
						<h4>Contact Number: ${registerModel.user.contactNumber}</h4>
						<h4>Role: ${registerModel.user.role}</h4>
						
					</div>
					
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of personal details -->
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
				</div>
			</div>

		</div>

		<!-- column to display the address  -->
		<div class="col-sm-6">

			<div class="panel panel-warning">
				<div class="panel-heading">
					<h4>Billing Address Informations</h4>
				</div>
				<div class="panel-body">
					
					<!-- code to display the communication address -->
					<div class="text-center">
					
						<h4>${registerModel.billing.addressOne}</h4>
						<h4>${registerModel.billing.addressTwo}</h4>
						<h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
						<h4>${registerModel.billing.region} - ${registerModel.billing.country}</h4>
						
					</div>
					
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of address -->
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				
				</div>
			</div>

		</div>

	</div>

	<!-- to provide the confirm button after displaying the details -->
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">

			<div class="text-center">

				<!--  go to the success page -->
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-default">Confirm</a>

			</div>

		</div>
	</div>

</div>
		  
<%@ include file="../shared/flows-footer.jsp" %>	