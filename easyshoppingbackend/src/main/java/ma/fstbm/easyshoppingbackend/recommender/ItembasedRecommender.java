package ma.fstbm.easyshoppingbackend.recommender;

import java.io.File; 
import java.io.IOException; 
import java.util.List; 

import org.apache.mahout.cf.taste.common.TasteException; 
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel; 
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender; 
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity; 
import org.apache.mahout.cf.taste.model.DataModel; 
import org.apache.mahout.cf.taste.recommender.RecommendedItem; 
import org.apache.mahout.cf.taste.similarity.ItemSimilarity; 

public class ItembasedRecommender { 
	
	public static void main(String[] args) throws TasteException, IOException { 
		
		DataModel model = new FileDataModel(new File("data/ratings.csv")); 
		
		ItemSimilarity similarity = new LogLikelihoodSimilarity(model); 
		 
		GenericItemBasedRecommender recommender = 
						new GenericItemBasedRecommender(model, similarity); 
		
		System.out.println("*********Recommend Items to Users********"); 
		
		List<RecommendedItem> recommendations = recommender.recommend(2, 5); 
		
		for(RecommendedItem recommendation : recommendations) { 
	      
			System.out.println(recommendation); 
		
		} 
		
		System.out.println("*********Most Similar Items********"); 
		
		List<RecommendedItem> similarItems = recommender.mostSimilarItems(13, 5); 
		
		for (RecommendedItem similarItem : similarItems) { 
		
			System.out.println(similarItem); 
		
		} 
		
	}

} 