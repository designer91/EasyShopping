package ma.fstbm.easyshoppingbackend.recommender;

import java.io.File; 
import java.io.IOException; 
import java.util.List; 

import org.apache.mahout.cf.taste.common.TasteException; 
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel; 
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer; 
import org.apache.mahout.cf.taste.model.DataModel; 
import org.apache.mahout.cf.taste.recommender.RecommendedItem; 

public class SVDRecommender { 
	
	public static void main(String[] args) throws TasteException, IOException { 
	
	    DataModel model = new FileDataModel(new File("data/dataset.csv"));    
	    
	    ALSWRFactorizer factorizer = new ALSWRFactorizer(model, 50, 0.065, 15); 
	    
	    SVDRecommender recommender = new SVDRecommender();    
	    
	    /*List<RecommendedItem> recommendations = recommender.recommend(2, 3); 
	    
	    for (RecommendedItem recommendation : recommendations) { 
	        
	    	System.out.println(recommendation); 
	    
	    } */
	    
	} 
	
} 
