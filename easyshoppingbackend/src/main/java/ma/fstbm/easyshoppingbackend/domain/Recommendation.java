package ma.fstbm.easyshoppingbackend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommendations")
public class Recommendation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long user_id;
	@Id
	private Long product_id;
	private float rec;
	
	
	public Recommendation() {
		super();
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public float getRec() {
		return rec;
	}
	public void setRec(float rec) {
		this.rec = rec;
	}
	
}
