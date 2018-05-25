package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.User;
import ma.fstbm.easyshoppingbackend.domain.UserAddress;

public interface UserDAO {
	
		// user related operations
		User getByEmail(String email);
		User get(Long id);
		
		// add a user
		boolean addUser(User user);
		
		List<User> getAllUsers();
		
//		UserAddress getBillingAddress(User user);
//		
//		List<UserAddress> listShippingAddresses(User user);
		
		UserAddress getBillingAddress(Long id);
		
		List<UserAddress> listShippingAddresses(Long id);
		
		// adding and updating a new address
		UserAddress getAddress(Long addressId);
		
		boolean addAddress(UserAddress address);
		boolean updateAddress(UserAddress address);
		

}
