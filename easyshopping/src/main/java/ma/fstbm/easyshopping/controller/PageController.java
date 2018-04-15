package ma.fstbm.easyshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.fstbm.easyshopping.exception.ProductNotAvailableException;
import ma.fstbm.easyshoppingbackend.dao.CategoryDAO;
import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.domain.Category;
import ma.fstbm.easyshoppingbackend.domain.Product;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * load all category's products 
	 */
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{catID}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("catID") Long catID) {
		ModelAndView mv = new ModelAndView("page");
		
		// fetch a single category
		Category category = null;
		category = categoryDAO.getCategoryById(catID);
		
		mv.addObject("title", category.getCategoryName());
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing a single categorie
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/*
	 *     showing single product 
	 * */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView viewSingleProduct(@PathVariable("id") Long id) throws ProductNotAvailableException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.getProduct(id);
		
		if (product == null) {
			throw new ProductNotAvailableException();
		}
		
		/* update the count of views */
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);
		
		mv.addObject("title", product.getProductName());
		mv.addObject("product", product);
		
		mv.addObject("userClickViewProduct", true);
		
		return mv;
		
	}
	
	
}
