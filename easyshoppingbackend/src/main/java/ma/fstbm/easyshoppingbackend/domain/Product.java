package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productID;
	private String productSKU;
	private String productName;
	@JsonIgnore
	private String productDesc;
	private double productPrice;
	private int productQuantity;
	@Column(name="is_active")
	@JsonIgnore
	private boolean active;
	@JsonIgnore
	private Long categoryID;
	@JsonIgnore
	private Long supplierID;
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	/*
	 * 		Constructors
	 */

	public Product() {
		this.productSKU = "PRDOUDCT" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public Product(String productSKU, String productName, String productDesc, double productPrice, int productQuantity,
			boolean active, Long categoryID, Long supplierID, int purchases, int views) {
		super();
		this.productSKU = productSKU;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.active = active;
		this.categoryID = categoryID;
		this.supplierID = supplierID;
		this.purchases = purchases;
		this.views = views;
	}

	/*
	 * 		 getters and setters
	 */
	
	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public Long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Long supplierID) {
		this.supplierID = supplierID;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
}
