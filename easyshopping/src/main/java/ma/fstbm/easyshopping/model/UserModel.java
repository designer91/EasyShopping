package ma.fstbm.easyshopping.model;

import java.io.Serializable;

import ma.fstbm.easyshoppingbackend.domain.ShoppingCart;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String fullName;
	private String role;
	private String email;
	private ShoppingCart cart;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", role=" + role + ", email=" + email + ", cart="
				+ cart + "]";
	}
	
	
}
