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
	default:
		$('#home').addClass('active');
		break;
	}
});
