package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="address")
public class UserAddress implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adressID;
	@NotBlank(message = "Please enter the first address!")
	@Column(name = "address_one")
	private String addressOne;
	@NotBlank(message = "Please enter the second address!")	
	@Column(name = "address_two")
	private String addressTwo;
	@NotBlank(message = "Please enter yor City!")	
	private String city;
	@NotBlank(message = "Please enter your Region!")	
	private String region;
	@NotBlank(message = "Please enter your country!")	
	private String country;
	@Column(name ="postal_code")
	@NotBlank(message = "Please enter Postal Code!")	
	private String postalCode;
	@Column(name="is_shipping")
	private boolean shipping;
	@Column(name="is_billing")
	private boolean billing;
	
	@Column(name = "user_id")
	private Long userId;
	
	/* this is an alternative to -- @Column(name = "user_id") --
	 *                                                         *
	 *	@ManyToOne                                             *
	 *	@JoinColumn(name="user_id")                            *
	 *	private User user;                                     *
	 *  													   *
	 *  // Getters and Setters                                 *
	 *  =======================                                *
	 *                                                         *
	 *  public User getUser() {                                *
	 *		return user;                                       *
	 *	}                                                      *
     *                                                         *
	 *	public void setUser(User user) {                       *
     *   	this.user = user;                                  *
	 *	}                                                      *
     *                                                         *
	 *                                                         *
	 **********************************************************/
	
	
	
	/*
	 * 		Constructors
	 */
	

	
	public UserAddress() {
		super();
	}
	
	public UserAddress(Long adressID, Long userID, String addressOne, String addressTwo, String city, String region,
			String country, String postalCode, boolean shipping, boolean billing) {
		super();
		this.adressID = adressID;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.region = region;
		this.country = country;
		this.postalCode = postalCode;
		this.shipping = shipping;
		this.billing = billing;
	}

	/*
	 *    Getters and Setters
	 */
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	public Long getAdressID() {
		return adressID;
	}


	public void setAdressID(Long adressID) {
		this.adressID = adressID;
	}



	public String getAddressOne() {
		return addressOne;
	}


	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}


	public String getAddressTwo() {
		return addressTwo;
	}


	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public boolean isShipping() {
		return shipping;
	}


	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}


	public boolean isBilling() {
		return billing;
	}


	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "UserAddress [adressID=" + adressID + ", addressOne=" + addressOne + ", addressTwo=" + addressTwo
				+ ", city=" + city + ", region=" + region + ", country=" + country + ", postalCode=" + postalCode
				+ ", shipping=" + shipping + ", billing=" + billing + ", userId=" + userId + "]";
	}


}
