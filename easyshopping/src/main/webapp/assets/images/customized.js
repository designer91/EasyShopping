/* JS Script */

$(document).ready(function() {
	//alert("working !");
	
	$('.animated-icon1').click(function(){
        $(this).toggleClass('open');
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
	default:
		if (menu == "Home" ) { break; }
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	/*
	 * 		DataTable Code
	 */

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
								data : 'id',
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
									
									str+= '<a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">';
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
								        bootbox.alert({
								        	size: 'medium',
								        	title: 'information',
								        	message: 'operation about to be done on product ' + value
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
	
	
	

	
});
