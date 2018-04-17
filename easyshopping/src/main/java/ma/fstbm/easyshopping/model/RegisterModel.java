package ma.fstbm.easyshopping.model;

import java.io.Serializable;

import ma.fstbm.easyshoppingbackend.domain.User;
import ma.fstbm.easyshoppingbackend.domain.UserAddress;

public class RegisterModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private UserAddress billing;
	
	/*
	 * 		Getters and Setters
	 */
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserAddress getBilling() {
		return billing;
	}
	public void setBilling(UserAddress billing) {
		this.billing = billing;
	}

	
}
