package ma.fstbm.easyshopping.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.fstbm.easyshopping.exception.ProductNotAvailableException;
import ma.fstbm.easyshoppingbackend.dao.CategoryDAO;
import ma.fstbm.easyshoppingbackend.dao.ProductDAO;
import ma.fstbm.easyshoppingbackend.dao.ReviewDAO;
import ma.fstbm.easyshoppingbackend.dao.UserDAO;
import ma.fstbm.easyshoppingbackend.domain.Category;
import ma.fstbm.easyshoppingbackend.domain.Product;
import ma.fstbm.easyshoppingbackend.domain.Review;
import ma.fstbm.easyshoppingbackend.domain.User;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;	
	
	
	
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
	 * load all products 
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
	@ResponseBody
	@RequestMapping(value="/show/{id}/product", method=RequestMethod.GET)
	public ModelAndView viewSingleProduct(@PathVariable("id") Long id) 
													throws ProductNotAvailableException {
		
		
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
		
		/*=== Create New Review ===*/
		
		Review review = new Review();
		
		mv.addObject("review", review);
		
		review.setProduct(product);
		
		mv.addObject("userClickViewProduct", true);
		
		return mv;
		
	}
	
	
	/*========================
	  * 	Login Method      *
	   =========================*/
	
	@RequestMapping(value="/login")
	public ModelAndView login( @RequestParam(name="error", required=false) String error,
							   @RequestParam(name="logout", required = false) String logout ) {
		
		ModelAndView mv = new ModelAndView("login");
		
		if (error != null) {
			mv.addObject("message", "invalid credentials! verify username and password and try again.");
		}

		if (logout != null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		
		mv.addObject("title", "login");
		
		return mv;
		
	}

	
	/*========================
	  * 	 Access Denied     *
	   =========================*/
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		
		ModelAndView mv = new ModelAndView("errors");
		
		mv.addObject("title", "403 - Access Denied");

		mv.addObject("errorTitle", "Page not accessible.");
		
		mv.addObject("errorDescription", "Sorry !  You are not allowed to view this page.");
		
		return mv;
		
	}

	
	/*========================
	  * 	Logout Method     *
	   =========================*/
	
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(req, res, auth);
	    }
		
		return "redirect:/login?logout";
		
	}
	
	
	
	/*======== Send Reviews ========*/
	
	@RequestMapping(value="/product/review", method=RequestMethod.POST)
	public ModelAndView sendReview(@Valid @ModelAttribute("review") Review review,
									 @RequestParam("hiddenRating") float hiddenRating,
									 	@RequestParam(value="id", required = true) Long id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		/*======== get the current user ===========*/
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User currentUser = userDAO.getByEmail(email);
		
		
		/*========= get the current product =============*/ 
	
		
		Product p = productDAO.getProduct(id);		
		
		review.setProduct(p);
		
		review.setUser(currentUser);
			
		review.setPreference(hiddenRating);
		
		review.setDatePost(new Date());
			
		reviewDAO.createReview(review);
	
		
		return mv;
		
	}
	

	
	
}
