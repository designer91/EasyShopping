package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewID;
	
	private Date datePost;
	
	private String content;

	private float preference;

	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	/*@Column(name="product_id")
	private Long productId;
	
	@Column(name="user_id")
	private Long userId;
	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long user) {
		this.userId = user;
	}	
	*/
	
	


	public Review() {
		super();
	}

	
	
	public Long getReviewID() {
		return reviewID;
	}


	public void setReviewID(Long reviewID) {
		this.reviewID = reviewID;
	}
	

	public float getPreference() {
		return preference;
	}

	public void setPreference(float preference) {
		this.preference = preference;
	}

	public Date getDatePost() {
		return datePost;
	}


	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	
}
