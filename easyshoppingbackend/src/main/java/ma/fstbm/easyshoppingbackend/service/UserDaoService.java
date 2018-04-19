package ma.fstbm.easyshoppingbackend.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.User;
import ma.fstbm.easyshoppingbackend.domain.UserAddress;

@Repository("userDAO")
@Transactional
public class UserDaoService implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Override
	public boolean addUser(User user) {
		try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean addAddress(UserAddress address) {
		try {	
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	@Override
	public User get(Long id) {
		return null;
	}
	
	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(selectQuery, User.class)
										.setParameter("email", email)
											.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public UserAddress getAddress(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean updateAddress(UserAddress address) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<UserAddress> listShippingAddresses(Long userId) {
		
		String selectQuery = "FROM Adress WHERE userId = :userId AND shipping = :shipping ORDER BY id DESC";
		
		try {
			
			return sessionFactory.getCurrentSession()
							.createQuery(selectQuery, UserAddress.class)
								.setParameter("userId", userId)
									.setParameter("shipping", true)
										.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public UserAddress getBillingAddress(Long userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery, UserAddress.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
		
	}
	
	
//	@Override
//	public List<UserAddress> listShippingAddresses(User user) {
//		
//		String selectQuery = "FROM Adress WHERE user = :user AND shipping = :shipping";
//		
//		try {
//			
//			return sessionFactory.getCurrentSession()
//							.createQuery(selectQuery, UserAddress.class)
//								.setParameter("user", user)
//									.setParameter("shipping", true)
//										.getResultList();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//
//
//	@Override
//	public UserAddress getBillingAddress(User user) {
//		String selectQuery = "FROM Adress WHERE user = :user AND billing = :billing";
//		
//		try {
//			
//			return sessionFactory.getCurrentSession()
//							.createQuery(selectQuery, UserAddress.class)
//								.setParameter("user", user)
//									.setParameter("billing", true)
//										.getSingleResult();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//	
	
}
