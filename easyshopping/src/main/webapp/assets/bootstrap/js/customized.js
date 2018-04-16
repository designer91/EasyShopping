/* JS Script */

$(document).ready(function() {
	//alert("working !");
	
	$('.animated-icon1').click(function(){
        $(this).toggleClass('open');
    });
	
});

$(function() {
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
	default:
		if (menu == "Home" ) { break; }
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	// code for jquery dataTable
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

		$table
				.DataTable({

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
									return  data + ' dhs'
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
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&nbsp';
									
									if (row.productQuantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
							
									
//									if(userRole !== 'ADMIN') {
//										if (row.quantity < 1) {
//											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
//										} else {
//	
//											str += '<a href="'
//													+ window.contextRoot
//													+ '/cart/add/'
//													+ data
//													+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
//										}
//									}
//									else {
//										str += '<a href="'
//											+ window.contextRoot
//											+ '/manage/'
//											+ data
//											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
//									}
									
									return str;

								}

							} ]
				});
	}
	
	/*
	 * 		dismiss alert after 3s
	 */
	$alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
	    	$alert.fadeOut('slow');
		   }, 3000
		);		
	}
	
	/*
	 *     admin table alerts and switches
	 */

		$('.switch input[type="checkbox"]').on('change' , function() {	
			
			var checkbox = $(this);
			var checked = checked.prop('checked');
			var dText = (checked)? 'You want to activate the Product?': 
								   'You want to de-activate the Product?';
		
		    bootbox.confirm({
		    	size: 'medium',
		    	title: 'Product Activation/Deactivation',
		    	message: dText,
		    	callback: function (confirmed) {
			        if (confirmed) {
			         console.log(value);
			         bootbox.alert({
			        	 size: 'medium',
				    	 title: 'information',
				    	 message: 'operation about to be done on' + value
			         });
			        }
			        else{
			        	checkbox.prop('checked', !checked);
			        }
		    	}
		
		    });
		    
		});	        
	
});
