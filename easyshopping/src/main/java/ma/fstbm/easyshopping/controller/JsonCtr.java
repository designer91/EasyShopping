package ma.fstbm.easyshopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.dao.RecommendationDAO;
import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.Recommendation;
import ma.fstbm.easyshoppingbackend.domain.User;

@Controller
@RequestMapping("/json/data")
public class JsonCtr {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RecommendationDAO recDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllPrpducts(){
		return productDAO.getListActiveProducts(); 
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {		
		return productDAO.list();
				
	}	
	
	@RequestMapping("/category/{categoryID}/products")
	@ResponseBody
	public List<Product> getPrpductsByCategory(@PathVariable Long categoryID){
		return productDAO.getListActiveProductsByCategory(categoryID); 
	}
	
	
	@RequestMapping("/mostviewd/products")
	@ResponseBody
	public List<Product> getMostViewedProducts() {		
		return productDAO.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mostpurchased/products")
	@ResponseBody
	public List<Product> getMostPurchasedProducts() {		
		return productDAO.getProductsByParam("purchases", 5);				
	}
	
	/*=============================*
	 *  Get recommended products   *
	 *=============================*/
	
	@RequestMapping("/recommendations")
	@ResponseBody
 	public List<Recommendation> getRecommendations() 
 									throws Exception {
		
 		return recDAO.getAllRecommendations();
 		
	}
	
	
	@RequestMapping("/recommendations/{id}/products")
	@ResponseBody
	public List<Product> getRecommendedProducts(@PathVariable Long id) {	
	
		List<Recommendation> rec = recDAO.getRecommendationsByUserId(id);
		
		List<Product> products = new ArrayList<Product>(); 
		
		for (Recommendation recommendation : rec) {
			
			Product product = productDAO.getProduct(recommendation.getProduct_id());
			
			products.add(product);
			
		}
		
		return products;				
	
	}
	
	@RequestMapping("/recommendations/products")
	@ResponseBody
	public List<Product> getRecommendedProductsForUser() throws IOException, TasteException {	
	
		/*======== get the current user ===========*/
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User currentUser = userDAO.getByEmail(email);
		
		List<Recommendation> recs = recDAO.getRecommendationsByUserId(currentUser.getUserID());
		
		List<Product> products = new ArrayList<Product>(); 
		
		for (Recommendation rec : recs) {
			
			Product product = productDAO.getProduct(rec.getProduct_id());
			
			if (product.isActive() == true) {
				
				products.add(product);
			
			}
			
			logger.info("product with id: " + product.getProductID() + " has rate: " + rec.getRec());
			
		}
		
		return products;				
	
	}
	
	@RequestMapping("all/recommendations/products")
	@ResponseBody
	public List<Product> getAllRecommendedProductsForUser() throws IOException, TasteException {	
	
		/*======== get the current user ===========*/
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User currentUser = userDAO.getByEmail(email);
		
		List<Recommendation> recs = recDAO.getAllRecommendationsByUserId(currentUser.getUserID());
		
		List<Product> products = new ArrayList<Product>(); 
		
		for (Recommendation rec : recs) {
			
			Product product = productDAO.getProduct(rec.getProduct_id());
			
			if (product.isActive() == true) {
				
				products.add(product);
			
			}
			
			logger.info("product with id: " + product.getProductID() + " has rating = : " + rec.getRec());
			
		}
		
		return products;				
	
	}
	
}
