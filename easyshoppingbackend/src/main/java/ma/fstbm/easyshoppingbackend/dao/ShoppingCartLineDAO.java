package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCartLine;

public interface ShoppingCartLineDAO {

	public List<ShoppingCartLine> list(Long cartId);
	public ShoppingCartLine get(Long id);	
	public boolean addCartLine(ShoppingCartLine cart);
	public boolean updateCartLine(ShoppingCartLine cart);
	public boolean removeCartLine(ShoppingCartLine cart);
	
	// fetch the CartLine based on cartId and productId
	public ShoppingCartLine getByCartAndProduct(Long cartId, Long productId);		
		
	// list of available cartLine
	public List<ShoppingCartLine> listAvailable(Long cartId);
	
	/*// adding order details
	boolean addOrderDetail(Order order);*/
	
	// updating the cart
	boolean updateShoppingCart(ShoppingCart cart);
	
	
}
