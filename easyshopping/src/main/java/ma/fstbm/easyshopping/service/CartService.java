package ma.fstbm.easyshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.fstbm.easyshopping.model.UserModel;
import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.dao.ShoppingCartLineDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCartLine;

@Service("cartService")
public class CartService {
	
	/*==================
	  * Private Fields  *
	   ===================*/
	
	@Autowired
	private ShoppingCartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
		
	@Autowired
	private HttpSession session;
	
	
	
	private ShoppingCart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	
	public List<ShoppingCartLine> getCartLines() {

		ShoppingCart cart = this.getCart();
		return cartLineDAO.list(cart.getCartID());

	}

	
	/*=========================
	  * Update the Cart Count  *
	   =========================*/
	
	public String manageCartLine(Long cartLineId, int count) {
		
		ShoppingCartLine cartLine = cartLineDAO.get(cartLineId);		

		double oldTotal = cartLine.getTotal();

		
		Product product = cartLine.getProduct();
		
		// check if that much quantity is available or not
		if(product.getProductQuantity() < count) {
			return "result=unavailable";		
		}	
		
		// update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getProductPrice());
		cartLine.setTotal(product.getProductPrice() * count);
		cartLineDAO.updateCartLine(cartLine);

	
		// update the cart
		ShoppingCart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
		cartLineDAO.updateShoppingCart(cart);
		
		return "result=updated";
		
	}


	/*=====================
	 *  Add the Cart Line  *
	  ======================*/
	
	public String addCartLine(Long productId) {	
		
		ShoppingCart cart = this.getCart();
		String response = null;
		ShoppingCartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getCartID(), productId);
		
		if(cartLine == null) {
			
			// add a new cartLine if a new product is getting added
			cartLine = new ShoppingCartLine();
			Product product = productDAO.getProduct(productId);
			
			// transfer the product details to cartLine
			cartLine.setCartId(cart.getCartID());
			cartLine.setProduct(product);
			cartLine.setProductCount(1);
			cartLine.setBuyingPrice(product.getProductPrice());
			cartLine.setTotal(product.getProductPrice());
			
			// insert a new cartLine
			cartLineDAO.addCartLine(cartLine);
			
			// update the cart
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() + 1);
			cartLineDAO.updateShoppingCart(cart);

			response = "result=added";		
			
		} 
		else {
			
			// check if the cartLine has been already reached to maximum count
			if(cartLine.getProductCount() < 3) {
				// call the manageCartLine method to increase the count
				response = this.manageCartLine(cartLine.getCartLineID(), cartLine.getProductCount() + 1);				
			}			
			else {				
			
				response = "result=maximum";				
		
			}						
	
		}
		
		return response;
	}
	
	
	/*=========================
	  *  Remove the Cart Line  *
	   =========================*/
	
	public String removeCartLine(Long cartLineId) {
		
		ShoppingCartLine cartLine = cartLineDAO.get(cartLineId);
		
		if (cartLine == null) {
			
			return "result=error";
		
		}else {
		
		// deduct the cart
		// update the cart
		ShoppingCart cart = this.getCart();	
		cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() - 1);		
		cartLineDAO.updateShoppingCart(cart);
		
		// remove the cartLine
		cartLineDAO.removeCartLine(cartLine);
				
		return "result=deleted";
		
		}

	}
	
	
	
	/*=========================
	  *  Validate the Cart Line  *
	   =========================*/
	
	public String validateCartLine() {
		
		ShoppingCart cart = this.getCart();
		List<ShoppingCartLine> cartLines = cartLineDAO.list(cart.getCartID());
		
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
		
		for(ShoppingCartLine cartLine : cartLines) {	
			
			product = cartLine.getProduct();
			changed = false;
			
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			
			if((!product.isActive() && product.getProductQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			
			// check if the cartLine is not available
			// check whether the product is active and has at least one quantity available
			
			if((product.isActive() && product.getProductQuantity() > 0) && !(cartLine.isAvailable())) {
				
					cartLine.setAvailable(true);
					changed = true;
			
			}
			
			// check if the buying price of product has been changed
			
			if(cartLine.getBuyingPrice() != product.getProductPrice()) {
				
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getProductPrice());
				
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getProductPrice());
				changed = true;				
			
			}
			
			// check if that much quantity of product is available or not
			
			if(cartLine.getProductCount() > product.getProductQuantity()) {
				
				cartLine.setProductCount(product.getProductQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getProductPrice());
				changed = true;
				
			}
			
			// changes has happened
			
			if(changed) {		
				
				//update the cartLine
				cartLineDAO.updateCartLine(cartLine);
				// set the result as modified
				response = "result=modified";
			
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		
		cartLineDAO.updateShoppingCart(cart);

		return response;
	
	}	
	
	
	
}
