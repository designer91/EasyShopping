package ma.fstbm.easyshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.fstbm.easyshopping.utils.FileUploading;
import ma.fstbm.easyshopping.validator.ProductValidator;
import ma.fstbm.easyshoppingbackend.dao.CategoryDAO;
import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.domain.Category;
import ma.fstbm.easyshoppingbackend.domain.Product;

@Controller
@RequestMapping("/manage")
public class ManagerController {

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation) {		

		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Manage Products");		
		mv.addObject("userClickManageProduct", true);
			
		Product newProduct = new Product();
		newProduct.setSupplierID(1L);
		newProduct.setActive(true);
		
		mv.addObject("product", newProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product added successfully!");
			}else if(operation.equals("category")){
				mv.addObject("message", "Category added successfully!");				
			}
		}
		
		return mv;
		
	}
	
	
	/*******************************
	  *  Activate a product method  *
	   *******************************/
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable Long id) {		

		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Manage Products");		
		mv.addObject("userClickManageProduct", true);
			
		Product newProduct = productDAO.getProduct(id);
		
		mv.addObject("product", newProduct);
		
		return mv;
		
	}
	
	
	/**************************************************
	  *   Handling submission of a new/edited product  *
	   * ************************************************/

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String ManageProductSubmission(@Valid @ModelAttribute("product") Product modifiedProduct, 
												BindingResult results, Model model, HttpServletRequest request) {
		
		
		/**** handle image validation : call of the product validator ****/
		
		if (modifiedProduct.getProductID() == null) {
			new ProductValidator().validate(modifiedProduct, results);
		}else {
			if (!modifiedProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(modifiedProduct, results);
			}
		}
		
		
		/****** check if there are errors ********/
		
		if (results.hasErrors()) {
			
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Mnage Products");
			model.addAttribute("message", "saving product failed!");
			
			return "page";
		}
		
		logger.info(modifiedProduct.toString());
		
		/************* create a new product *************/
		
		if (modifiedProduct.getProductID() == null) {
		
			productDAO.addProduct(modifiedProduct);
		
		}else {
			
			/************* update the product *************/
			
			productDAO.updateProduct(modifiedProduct);
		
		}
		
		
		if (!modifiedProduct.getFile().getOriginalFilename().equals("")) {
			FileUploading.uploadFile(request, modifiedProduct.getFile(), modifiedProduct.getProductCode());
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	/*******************************
	  *  Activate a product method  *
	   *******************************/
	
	@RequestMapping(value="/product/{id}/activate", method=RequestMethod.POST)
	@ResponseBody
	public String  ManageProductActivation(@PathVariable Long id ){
		
		Product product = productDAO.getProduct(id);
		
		boolean isActive = product.isActive();
		
		product.setActive(!isActive);
		
		productDAO.updateProduct(product);
		
		return (isActive)? 
							"product "+product.getProductID()+" deactivated successfully!":
								"product "+product.getProductID()+" activated successfully!";		
		
	}
	

	/******************************************
	  *  handle submission of a new category   *
	   ******************************************/
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category category, HttpServletRequest req) {					
		categoryDAO.addCategory(category);		
		return "redirect:/manage/products?operation=category";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {		
		
		return categoryDAO.list();
		
	}
	
	/*************************
	  *  add a new category   *
	   *************************/
	
	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}
	
}
