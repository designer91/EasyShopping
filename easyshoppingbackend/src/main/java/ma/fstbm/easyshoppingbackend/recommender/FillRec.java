package ma.fstbm.easyshoppingbackend.recommender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ma.fstbm.easyshoppingbackend.domain.Recommendation;

public class FillRec {
	
public ArrayList<Recommendation> GetRecommendations() throws NumberFormatException, IOException{
		
		BufferedReader br = 
				new BufferedReader(
						new FileReader("C:\\Users\\aazri\\Downloads\\EasyShopping\\easyshopping\\" 
								     + "src\\main\\webapp\\dataset\\recommendations.csv"));
		
		ArrayList<Recommendation> rList = new ArrayList<Recommendation>();

		String line;
		
		rList.clear();
		
		while((line = br.readLine()) != null){
		
			String[] elements = line.split(",");
			
			Long user_id = Long.parseLong(elements[0]);
			Long product_id = Long.parseLong(elements[1]);
			float rating = Float.parseFloat(elements[2]);
			
			Recommendation rec = new Recommendation();
			
			rec.setUser_id(user_id);
			rec.setProduct_id(product_id);
			rec.setRec(rating);
			
			rList.add(rec);
			
		}
		
		br.close();
		
		return rList;
		
	}

}
