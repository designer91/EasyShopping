package ma.fstbm.easyshoppingbackend.recommender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import ma.fstbm.easyshoppingbackend.domain.Recommendation;

public class ItemRec {
	
	ArrayList<Recommendation> listRecommendations;
	
	public ArrayList<Recommendation> getRecommendations(Long user_id) throws IOException, TasteException{

			DataModel dm = 
					new FileDataModel(
							new File("C:\\Users\\aazri\\Downloads\\EasyShopping\\easyshopping"
									+ "\\src\\main\\webapp\\dataset\\ratings.csv"));
			
			UserSimilarity similarity = new PearsonCorrelationSimilarity(dm);
		
	        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.4, similarity, dm);
	        
	        UserBasedRecommender recommender = new GenericUserBasedRecommender(dm, neighborhood, similarity);
	       
	        List<RecommendedItem> lr = recommender.recommend(user_id, 5);

	        BufferedWriter bw = 
	        		new BufferedWriter(
	        				new FileWriter("C:\\Users\\aazri\\Downloads\\EasyShopping\\easyshopping\\"
	        								+ "src\\main\\webapp\\dataset\\recommendations.csv"));     

	        for(RecommendedItem item : lr)
	        {
	            System.out.println(item);
	            bw.write(user_id+ "," +item.getItemID()+ "," +item.getValue()+ "\n");
	        }
	        
	        bw.close();
		
	        return listRecommendations;
	
	}

}
