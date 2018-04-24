package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.Review;

public interface ReviewDAO {
	
	Review getReview(Long id);
	
	public boolean createReview(Review review);
	
	public Review getReviewByProductAndUser(Long userId, Long productId);
	
	List<Review> getReviewByProduct(Product p);

}
