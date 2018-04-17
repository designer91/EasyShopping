package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long cartID;
	@Column(name = "grand_total")
	private double grandTotal;
	@Column(name = "cart_lines")
	private int cartLines;
	
	/* unidirectional 1-1 mapping*/
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	

	public ShoppingCart() {
		
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getCartID() {
		return cartID;
	}


	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public int getCartLines() {
		return cartLines;
	}


	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	
}
