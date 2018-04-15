package ma.fstbm.easyshoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;

public class ProductTest {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ma.fstbm.easyshoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		// create operation
		product = new Product();
				
		product.setProductSKU("GB-R123");
		product.setProductName("Oppo Selfie S53");
		product.setProductDesc("This is some description for oppo mobile phones!");
		product.setProductPrice(25000);
		product.setActive(true);
		product.setCategoryID(1L);
		product.setSupplierID(2L);
		product.setPurchases(13);
		product.setViews(100);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.addProduct(product));		
		
		product = productDAO.getProduct(1L);
		product.setProductName("Samsung Galaxy S8");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.updateProduct(product));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.deleteProduct(product));		
		
		// list
		assertEquals("Something went wrong while fetching the list of products!",
				8,productDAO.list().size());		
				
	}
			
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				4,productDAO.getListActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				1,productDAO.getListActiveProductsByCategory(3L).size());
		assertEquals("Something went wrong while fetching the list of products!",
				1,productDAO.getListActiveProductsByCategory(1L).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				4,productDAO.getLatestActiveProducts(4).size());
		
	} 
	
}
