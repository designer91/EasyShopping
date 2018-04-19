package ma.fstbm.easyshoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.dao.ShoppingCartLineDAO;
import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCartLine;
import ma.fstbm.easyshoppingbackend.domain.User;

public class ShoppingCartLineTest {
	
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static ShoppingCartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	
	private ShoppingCartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ma.fstbm.easyshoppingbackend");
		context.refresh();
		cartLineDAO = (ShoppingCartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("n2ve@live.com");		
		ShoppingCart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.getProduct(3L);
		
		// Create a new CartLine
		cartLine = new ShoppingCartLine();
		
		cartLine.setCartId(cart.getCartID());
		cartLine.setProduct(product);
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setBuyingPrice(product.getProductPrice());
		cartLine.setAvailable(true);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getProductPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.addCartLine(cartLine));
		assertEquals("Failed to update the cart!",true, cartLineDAO.updateShoppingCart(cart));
		
	}
	
	
	
	/*@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		ShoppingCart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getCartID(), 2L);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getProductPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.updateCartLine(cartLine));	

		
	}*/
	

}
