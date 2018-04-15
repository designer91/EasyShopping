package ma.fstbm.easyshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.domain.Product;

@Controller
@RequestMapping("/json/data")
public class JsonCtr {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllPrpducts(){
		return productDAO.getListActiveProducts(); 
	}
	
	@RequestMapping("/category/{categoryID}/products")
	@ResponseBody
	public List<Product> getPrpductsByCategory(@PathVariable Long categoryID){
		return productDAO.getListActiveProductsByCategory(categoryID); 
	}
	
}
