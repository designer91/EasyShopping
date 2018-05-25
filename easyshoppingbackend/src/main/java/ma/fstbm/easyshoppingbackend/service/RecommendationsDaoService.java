package ma.fstbm.easyshoppingbackend.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.fstbm.easyshoppingbackend.dao.RecommendationDAO;
import ma.fstbm.easyshoppingbackend.domain.Recommendation;

@Repository("recDAO")
@Transactional
public class RecommendationsDaoService implements RecommendationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Recommendation> getAllRecommendations() {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Recommendation" , Recommendation.class)
						.getResultList();
		
	}

	@Override
	public List<Recommendation> getRecommendationsByUserId(Long user_id) {
		
		try {
			
			String selectRecs = "FROM Recommendation WHERE user_id = :user_id ORDER BY rec DESC";
			
			Query query = sessionFactory
							.getCurrentSession()
								.createQuery(selectRecs)
									.setParameter("user_id", user_id);
									
			query.setFirstResult(1);
			query.setMaxResults(5);
			
			List result = query.getResultList();
			
			return result;
			
		} catch (HibernateException he) {
			
			he.printStackTrace();
			
		}
		
		return null;
	
	}

	@Override
	public List<Recommendation> getAllRecommendationsByUserId(Long user_id) {

		try {
			String selectRecs = "FROM Recommendation WHERE user_id = :user_id ORDER BY rec DESC";
			
			Query query = sessionFactory
							.getCurrentSession()
								.createQuery(selectRecs)
									.setParameter("user_id", user_id);
			
			List result = query.getResultList();
			
			return result;
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		
		return null;
		
	}
	
	

}
