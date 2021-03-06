package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryID;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_description")
	private String categoryDesc;
	@Column(name = "is_active")
	private boolean active = true;

	public Category() {
		super();
	}

	public Category(String categoryName, String categoryDesc, String categoryImage, boolean active) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.active = active;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc + ", active=" + active + "]";
	}
	
}
