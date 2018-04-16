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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			}
		}
		
		return mv;
		
	}
	
	/*
	 *  	manage product submission 
	 * */
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String ManageProductSubmission(@Valid @ModelAttribute("product") Product modifiedProduct, 
												BindingResult results, Model model, HttpServletRequest request) {
		
		
		/*
		 * 		call of the product validator
		 */
		new ProductValidator().validate(modifiedProduct, results);
		
		
		/*
		 *      check if ther are errors
		 */
		if (results.hasErrors()) {
			
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Mnage Products");
			model.addAttribute("message", "saving product failed!");
			
			return "page";
		}
		
		logger.info(modifiedProduct.toString());
		
		productDAO.addProduct(modifiedProduct);
		
		if (!modifiedProduct.getFile().getOriginalFilename().equals("")) {
			FileUploading.uploadFile(request, modifiedProduct.getFile(), modifiedProduct.getProductCode());
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {		
		
		return categoryDAO.list();
		
	}
	
}
