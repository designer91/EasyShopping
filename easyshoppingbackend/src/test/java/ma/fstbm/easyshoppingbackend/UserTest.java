package ma.fstbm.easyshoppingbackend;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.User;
import ma.fstbm.easyshoppingbackend.domain.UserAddress;

public class UserTest {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private ShoppingCart cart = null;
	private UserAddress address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ma.fstbm.easyshoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	
	/*@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setUserEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setUserPassword("12345");
		
		
		address = new UserAddress();
		address.setAddressOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setRegion("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		
		// adding user
		assertEquals("failure! cannot add the user", true, userDAO.addUser(user));
		
		// add the shipping address
		address = new UserAddress();
		address.setAddressOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setRegion("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		assertEquals("Failure! cannot add the shipping address!", true, userDAO.addAddress(address));
		
		if (user.getRole().equals("CUSTOMER")) {
			
			ShoppingCart cart = new ShoppingCart();
			cart.setUser(user);
			
			assertEquals("Failure! cannot add the shipping cart!", true, userDAO.addCart(cart));
			
			
			address = new UserAddress();
			address.setAddressOne("301/B Jadoo Society, King Uncle Nagar");
			address.setAddressTwo("Near Store");
			address.setCity("Mumbai");
			address.setRegion("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			
			// link the address with the user
			address.setUserID(user.getUserID());
			
			assertEquals("Failure! cannot add the shipping address!", true, userDAO.addAddress(address));
			
			
			
		}
		
		
	}*/
	
	
	
	/*@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setUserPassword("12345");
		
		
		if (user.getRole().equals("CUSTOMER")) {
			
			ShoppingCart cart = new ShoppingCart();
			cart.setUser(user);
			
			// link the cart with the user
			user.setCart(cart);
			
		}
		
		
		// adding user
		assertEquals("failure! cannot add the user", true, userDAO.addUser(user));
		
		
	}*/
	
	
	/*@Test
	public void testUpdateCart() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		// get the cart
		
		cart = user.getCart();
		
		cart.setGrandTotal(5000);
		
		cart.setCartLines(4);
		

		assertEquals("update failed! cannot update the cart", true, userDAO.updateCart(cart));
		
		
	}*/
	
	
	/*
	@Test
	public void testAddAddress() {
		user = userDAO.get(1L);
		
		address = new UserAddress();
		address.setAddressOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressTwo("Near Store");
		address.setCity("Mumbai");
		address.setRegion("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	

		
		address = new UserAddress();
		address.setAddressOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressTwo("Near Store");
		address.setCity("Mumbai");
		address.setRegion("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		
		
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
	
	
	}
	*/

	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("nabil@gmail.com");
		
		address = new UserAddress();
		address.setAddressOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressTwo("Near Store");
		address.setCity("Settat");
		address.setRegion("Chaouia");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
				
		address.setUserId(user.getUserID());
		
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	

	}
	
}
