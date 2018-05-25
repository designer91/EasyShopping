package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.Recommendation;;

public interface RecommendationDAO {
	
	List<Recommendation> getAllRecommendations();
	
	List<Recommendation> getRecommendationsByUserId(Long id);
	
	List<Recommendation> getAllRecommendationsByUserId(Long id);

}
