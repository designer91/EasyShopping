package ma.fstbm.easyshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import ma.fstbm.easyshopping.model.RegisterModel;
import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;
import ma.fstbm.easyshoppingbackend.domain.User;
import ma.fstbm.easyshoppingbackend.domain.UserAddress;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	

	public RegisterModel init() {
		
		return new RegisterModel();
		
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
		
	}
	
	public void addBilling(RegisterModel registerModel, UserAddress billing) {
		
		registerModel.setBilling(billing);
		
	}

	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		
		/*  get the user  
		 * ===============*/
		
		User user = model.getUser();
		
		if (user.getRole().equals("USER")) {
			
			ShoppingCart cart = new ShoppingCart();
			
			cart.setUser(user);
			
			user.setCart(cart);
		
		}
		
		/*  save the user  
		 * ===============*/
		
		userDAO.addUser(user);
		
		
		/*	get address
		 ===================*/
		
		UserAddress billingAddress = model.getBilling();
		
		billingAddress.setUserId(user.getUserID());
		
		billingAddress.setBilling(true);
		
		
		/*	get address
		 ===================*/
		
		userDAO.addAddress(billingAddress);
		
		
		return transitionValue;
		
	}
	
	/* 	validate user's informations
	 ===============================*/
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		// test the password given matches the confirmed one
		
		if(!user.getUserPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Passwords are not matching! Please make sure that the *password* matches the *confirm password*.").build());
		    transitionValue = "failure";    
		}  
		
		// test if the email given is already taken or not
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
		    error.addMessage(new MessageBuilder().error().source("email")
		    		.defaultText("Email address is already taken! Please choose another one.").build());
		    transitionValue = "failure";
	   }
	
		return transitionValue;
		
	}
	
	
	

}
