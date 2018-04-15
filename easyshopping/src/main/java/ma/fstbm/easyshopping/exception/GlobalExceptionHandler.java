package ma.fstbm.easyshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("errors");
		
		mv.addObject("errorTitle", "The page is not available yet!");
		
		mv.addObject("errorDescription", "Page is not available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotAvailableException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("errors");
		
		mv.addObject("errorTitle", "Product not available!");
		
		mv.addObject("errorDescription", "The product is unavailable right now! please give it a try later ;)");
		
		mv.addObject("title", "Product not available");
		
		return mv;
	}
		
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("errors");
		
		mv.addObject("errorTitle", "Error! Contact Your Administrator for additional informations!");
		
		
		//only for debugging your application
		/*StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
						
		mv.addObject("errorDescription", sw.toString());*/
		
		mv.addObject("title", "Error");
		
		return mv;
	}	
	
}
