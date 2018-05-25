<div class="container">
	<h1 class="mt-4 mb-3">
		Contact <small>feel free to contact us</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Contact</li>
	</ol>

	<!-- Content Row -->
	<div class="row">
		
		<!-- Contact Details Column -->
		<div class="col-md-4">
			<h4 class="contact-text">Contact Details</h4>
			<p>El Akkari, Rabat</p>
			<p>
				<abbr title="Phone">P</abbr>: (+212) 6-15373720
			</p>
			<p>
				<abbr title="Email">E</abbr>: 
				<a href="mailto:nabil.azri2016@gmail.com">nabil.azri2016@gmail.com</a>
			</p>
			<p>
				<abbr title="Hours">H</abbr>: Monday - Friday: 9:00 AM to 5:00 PM
			</p>
		</div>
		
		<!-- Map Column -->
		<div class="col-md-8">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d13229.613651996251!2d-6.869479265905947!3d34.00785448988668!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xda76c5f408b9627%3A0x546c7f099bae1f3d!2sEl+Akkari%2C+Rabat!5e0!3m2!1sen!2sma!4v1527013052117" width="750" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
		
	</div>
	<!-- /.row -->

	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact 
		 form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-lg-8 mb-4">
			<h4 class="contact-text">Send us a Message</h4>
			<form name="sentMessage" id="contactForm" novalidate>
				<div class="control-group form-group">
					<div class="controls">
						<label>Full Name:</label> <input type="text" class="form-control"
							id="name" required
							data-validation-required-message="Please enter your name.">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>Phone Number:</label> <input type="tel"
							class="form-control" id="phone" required
							data-validation-required-message="Please enter your phone number.">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>Email Address:</label> <input type="email"
							class="form-control" id="email" required
							data-validation-required-message="Please enter your email address.">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>Message:</label>
						<textarea rows="10" cols="100" class="form-control" id="message"
							required
							data-validation-required-message="Please enter your message"
							maxlength="999" style="resize: none"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" class="btn btn-primary" id="sendMessageButton">Send
					Message</button>
			</form>
		</div>

	</div>
	<!-- /.row -->

</div>