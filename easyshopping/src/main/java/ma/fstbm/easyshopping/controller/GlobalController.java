package ma.fstbm.easyshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ma.fstbm.easyshopping.model.UserModel;
import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.User;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	private UserModel userModel = null;
	private User user = null;	
	
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {		
		
		if(session.getAttribute("userModel") == null) {
			
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(!authentication.getPrincipal().equals("anonymousUser")){
				
				// get the user from the database
				
				user = userDAO.getByEmail(authentication.getName());
				
				
				if(user != null) {
				
					// create a new model
					
					userModel = new UserModel();
					
					// set the name and the id
					
					userModel.setId(user.getUserID());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setRole(user.getRole());
					userModel.setEmail(user.getEmail());
					
					if(user.getRole().equals("USER")) {
						userModel.setCart(user.getCart());					
					}				
	
					session.setAttribute("userModel", userModel);
					 
					return userModel;
			
				}			
			}
		}
		
		return (UserModel) session.getAttribute("userModel");		
	}

}
