package ma.fstbm.easyshopping.exception;

import java.io.Serializable;

public class ProductNotAvailableException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotAvailableException() {
		this("Product is not available!");
	}
	
	public ProductNotAvailableException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}
	
}
