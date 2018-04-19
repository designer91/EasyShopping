package ma.fstbm.easyshoppingbackend.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.fstbm.easyshoppingbackend.dao.ShoppingCartLineDAO;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDaoService implements ShoppingCartLineDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<ShoppingCartLine> list(Long cartId) {
		String query = "FROM ShoppingCartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, ShoppingCartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();	
	}

	@Override
	public ShoppingCartLine get(Long id) {
		
		return sessionFactory.getCurrentSession().get(ShoppingCartLine.class, Long.valueOf(id));
	
	}

	@Override
	public boolean addCartLine(ShoppingCartLine cartLine) {
		
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCartLine(ShoppingCartLine cartLine) {
		
		try {			
			sessionFactory.getCurrentSession().update(cartLine);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	
	}

	@Override
	public boolean removeCartLine(ShoppingCartLine cartLine) {

		try {			
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}	
		
	}

	@Override
	public ShoppingCartLine getByCartAndProduct(Long cartId, Long productId) {

		String query = "FROM ShoppingCartLine WHERE cartId = :cartId AND product.productID = :productId";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,ShoppingCartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	@Override
	public List<ShoppingCartLine> listAvailable(Long cartId) {

		String query = "FROM ShoppingCartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, ShoppingCartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();
		
	}


	@Override
	public boolean updateShoppingCart(ShoppingCart cart) {
		try {			
			sessionFactory.getCurrentSession().update(cart);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


	
	
}
