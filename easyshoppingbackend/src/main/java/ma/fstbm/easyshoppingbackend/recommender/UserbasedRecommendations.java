package ma.fstbm.easyshoppingbackend.recommender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.List; 

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel; 
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood; 
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender; 
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity; 
import org.apache.mahout.cf.taste.model.DataModel; 
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood; 
import org.apache.mahout.cf.taste.recommender.RecommendedItem; 
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender; 
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;

import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.User;

//class for generating User Based Recommendation 
public class UserbasedRecommendations { 
   
	public void getRecommendedProds(Long user_id) throws IOException, TasteException{
		
		  //creating data model 
	    DataModel model = new FileDataModel(new File("data/predicted_ratings_.csv"));      
	    
	    // creating Euclidean distance similarity between users  
	    UserSimilarity similarity = new EuclideanDistanceSimilarity(model); 
	   
	    //creating user neighborhood 
	    UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, model); 
	    
	    // creating recommender model 
	    UserBasedRecommender recommender = 
	    		new GenericUserBasedRecommender(model, neighborhood, similarity); 
	    
	    //generating 3 recommendations for user 4 
	    List<RecommendedItem> recommendations = recommender.recommend(user_id, 5); 
	    
	    BufferedWriter bw = 
	    		new BufferedWriter(
	    				new FileWriter("data/recommendations.csv"));
	    
	 /* for all users
	    for (LongPrimitiveIterator it = model.getUserIDs(); it.hasNext();){
	    	long userId = it.nextLong();
	    } */
	    
	    // if empty write something
	    if (recommendations.size() == 0){
		    System.out.print("User ");
		    System.out.print(user_id);
		    System.out.println(": no recommendations");
	    }
	    
	    // print the list of recommendations for each
	    for (RecommendedItem recommendedItem : recommendations) {
	
		    bw.write(	user_id+ "," +recommendedItem.getItemID()+ "," 
		    			+recommendedItem.getValue()+ "\n"	);
	
	    }
	    
	    
//	    for (RecommendedItem recommendation : recommendations) { 
//	     
//	    	System.out.println(recommendation); 
//	    
//	    }
	    
		
	}
	
	
}