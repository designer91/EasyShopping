/* JS Script */

$(function(){
	//alert("working !");
	
	// for adding a loader
	$(window).load(function(){
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);			
	});	

	
	/*
	 *		switch between navigation menus 
	 */
	
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == "Home" ) { break; }
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	/*=========*
	  *  #CSRF  *
	   *=========*/
	
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}

	
	/*=======================*
	  * 	DataTable Code    *
	   *========================*/

	var $table = $('#productsTable');
	
	// execute the below code only where we have this table
	if ($table.length) {
		//console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryID == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryID + '/products';
		}

		$table.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					
					/*
					 *     ajax
					 * */
					
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					
					/*  
					 *   collection of data
					 */
					
					columns : [
							{
								data : 'productCode',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';

								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productPrice',
								mRender : function(data, type, row) {
									return  data
								}
							},
							{
								data : 'productQuantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'productID',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									
									if(userRole == 'ADMIN'){
										
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
									} 
									
									else {
										
										if (row.productQuantity < 1) {
											
											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										
										} else {
											
											str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
											
													
										}
												
									}
								
									
									return str;

								}

							} ]
				});
	}
	
	
	
	/*************************************
	 * 	dismiss alert after 3s version 1  *
	  **************************************/
	
	$alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
	    	$alert.fadeOut('slow');
		   }, 5000
		);	
	}
		
	
	/***********************
	  *   admin data table  *
	   ***********************/
	
	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {
		//console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable.DataTable({

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					
					/*
					 *     ajax
					 * */
					
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					
					/*  
					 *   collection of data
					 */
					
					columns : [
							
							{
								data : 'productID',
							},
							{
								data : 'productCode',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="adminTableImg"/>';

								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productSKU'
							},
							{
								data : 'productQuantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'productPrice',
								mRender : function(data, type, row) {
									return  data + ' dhs'
								}
							},
							{
								data : 'active',
								mRender: function(data, type, row) {
									
									var str = '';
								
									str+= '<label class="switch">';
									
									if (data) {
										str+= '<input type="checkbox" checked="checked" value="'+row.productID+'"/>';
									}else {
										str+= '<input type="checkbox" value="'+row.productID+'"/>';
									}
									
									
									str+= '<div class="slider"></div></label>';
									
									return str;
								
								}

							},
							{
								data: 'productID',
								bSortable: false,
								mRender: function(data, type, row) {
									
									var str = '';
									
									str+= '<a href="' + window.contextRoot + '/manage/'+data+'/product" class="btn btn-warning">';
									str+= '<span class="glyphicon glyphicon-pencil"></span></a>';
								
									return str;
									
								}
								
							}

					],
					
					initComplete: function() {
						
						var api = this.api();
						
						api.$('.switch input[type="checkbox"]').on('change' , function() {	
							
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dialogText = (checked)? 'You want to activate the Product?': 
												   		'You want to de-activate the Product?';
							
							var value = checkbox.prop('value');
								
						    bootbox.confirm({
							    size: 'medium',
							   	title: 'Product Activation/Deactivation',
							   	message: dialogText,
							   	callback: function(confirmed) {
							        if (confirmed) {
								        console.log(value);
								        
								        var activateUrl = window.contextRoot + '/manage/product/' + value + '/activate';
								        
								        $.post(activateUrl, function(data) {
								        	 bootbox.alert({
											     size: 'medium',
											     title: 'information',
											     message:  data
										     });
										});
								    }
								     else{
								        checkbox.prop('checked', !checked);
								    }
							    }
							
						   });
							    
						});    
						
						
					}
					
					
					
				});
	
	
	}
	
	
	/*********************************
	  *   category modal validation   *
	   *********************************/
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length) {
		
		$categoryForm.validate({			
				rules: {
					categoryName: {
						required: true,
						minlength: 5
					},
					categoryDesc: {
						required: true,
						minlength: 5					
					}				
				},
				messages: {					
					name: {
						required: 'Please enter a category name!',
						minlength: 'Please enter at least five characters'
					},
					description: {
						required: 'Please enter category description!',
						minlength: 'Please enter at least five characters'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					error.addClass('help-block');
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
		
	
	/******************************
	  * validating the login form  *
	   * ****************************/
	
	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					error.addClass("help-block");
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
	
	
	
	/* handle refresh cart*/	
	$('button[name="refreshCart"]').click(function(){
		var cartLineId = $(this).attr('value');
		var countField = $('#count_' + cartLineId);
		var originalCount = countField.attr('value');
		
		
		// do the checking only the count has changed
		
		if(countField.val() !== originalCount) {	
		
			// check if the quantity is within the specified range
			
			if(countField.val() < 1 || countField.val() > 3) {
			
				// set the field back to the original field
				
				countField.val(originalCount);
				bootbox.alert({
					size: 'medium',
			    	title: 'Error',
			    	message: 'Product Count should be minimum 1 and maximum 3!'
				});
			}
			else {
				
				// use the window.location.href property to send the request to the server
				
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
				
				window.location.href = updateUrl;
			
			}
		}
	});			
	
	
	
	
	/*****************
	  *    ratings    *
	   * ***************/
	
	$("#rating").rateYo({
		rating: 0,
	    maxValue: 5,
	    numStars: 5,
	    halfStar: true,
	    starWidth: "40px",
	    onChange: function (rating, rateYoInstance) {
			$('#hiddenRating').val(rating);
		}
	  });
	
	
	
	
});
