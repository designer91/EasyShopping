package ma.fstbm.easyshoppingbackend.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class itemRecommender {
	
	/*ArrayList<Recommendation> listRecomendations;
	
	public ArrayList<Recommendation> getRecommendations(String user) throws IOException, TasteException{

			DataModel dataModel = 
					new FileDataModel(
							new File("D:\\Projects\\EasyShopping\\easyshopping\\src\\main"
									+ "\\webapp\\recommender_dataSet\\imported_data.csv"));
			
			UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
			
	        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.4, similarity, dataModel);
	   
	        UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
	       
	        List<RecommendedItem> listOfRecommendations = recommender.recommend(Long.valueOf(user), 5);
	        
	        BufferedWriter bw = 
	        		new BufferedWriter(
	        				new FileWriter("D:\\Projects\\EasyShopping\\easyshopping\\src\\main"
	        							 + "\\webapp\\recommender_dataSet\\recommendations.csv"));     

	        for(RecommendedItem item : listOfRecommendations){
	            System.out.println(item);
	            bw.write(user+ "," +item.getItemID()+ "," +item.getValue()+ "\n");
	        }
	        
	        bw.close();
		
	        return listRecomendations;
	
	}*/
	
	public static void main(String[] args) throws IOException, TasteException {
		
		DataModel model = 
				new FileDataModel(
						new File("D:\\Datasets\\e-commerce\\ratings_Electronics.csv"));
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity (model);
		
		UserNeighborhood neighborhood = 
				new NearestNUserNeighborhood (2, similarity, model);
		
		Recommender recommender = 
				new GenericUserBasedRecommender (model, neighborhood, similarity);
		
		List<RecommendedItem> recommendations = recommender.recommend(3, 2);
		
		for (RecommendedItem recommendation : recommendations) {
		
			System.out.println(recommendation);
		
		}
        
	}

}
