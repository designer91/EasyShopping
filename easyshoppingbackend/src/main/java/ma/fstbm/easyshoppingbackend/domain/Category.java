package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

public class Category implements Serializable{
	
	private Long categoryID;
	private String categoryName;
	private String categoryDesc;
	private String categoryImage;
	private boolean active = true;
	
	public Category() {
		super();
	}

	public Category(String categoryName, String categoryDesc, String categoryImage, boolean active) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		categoryDesc = categoryImage;
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

	public String getCategoryImage() {
		return categoryDesc;
	}

	public void setCategoryImage(String categoryImage) {
		categoryDesc = categoryImage;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
