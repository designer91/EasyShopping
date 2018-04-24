package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.Product;

public interface ProductDAO {
	
	
	Product getProduct(Long productID);
	List<Product> list();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> getListActiveProducts();
	List<Product> getListActiveProductsByCategory(Long categoryID);
	List<Product> getLatestActiveProducts(int count);
	List<Product> getProductsByParam(String param, int count);
	
	// reviews
	Product getProductByReview(Long id);
	
}
