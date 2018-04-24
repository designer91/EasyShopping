package ma.fstbm.easyshoppingbackend.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.fstbm.easyshoppingbackend.dao.ReviewDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.Review;

@Repository("reviewDAO")
@Transactional
public class ReviewDaoService implements ReviewDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean createReview(Review review) {

		try {			
			sessionFactory
					.getCurrentSession()
						.persist(review);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
		
	}

	@Override
	public Review getReview(Long id) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Review.class,Long.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}


	@Override
	public Review getReviewByProductAndUser(Long userId, Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewByProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
