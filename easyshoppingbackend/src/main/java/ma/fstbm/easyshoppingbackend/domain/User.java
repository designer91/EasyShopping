package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user_detail")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	@NotBlank(message = "Please enter your first name!")
	@Column(name = "first_name")
	private String firstName;
	@NotBlank(message = "Please enter your last name!")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank(message = "Please enter an email address!")	
	private String email;
	@NotBlank(message = "Please enter a contact number!")
	@Column(name = "contact_number")
	private String contactNumber;
	private String role;
	@NotBlank(message = "Please enter a password!")
	private String userPassword;
	private boolean enabled = true;
	
	@Transient
	private String confirmPassword;
	
	

	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private ShoppingCart cart;
	


	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public User() {
		
	}
	
	public User(Long userID, String firstName, String lastName, String userEmail, String contactNumber, String role,
			String userPassword, boolean enabled) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = userEmail;
		this.contactNumber = contactNumber;
		this.role = role;
		this.userPassword = userPassword;
		this.enabled = enabled;
	}
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail="
				+ email + ", contactNumber=" + contactNumber + ", role=" + role + ", userPassword=" + userPassword
				+ ", enabled=" + enabled + "]";
	}

	

}
