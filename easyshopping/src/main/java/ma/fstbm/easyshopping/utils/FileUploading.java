package ma.fstbm.easyshopping.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploading {

	private static final String ABSOLUTE_PATH = "D:\\Projects\\EasyShopping\\easyshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = null;
	private static final Logger logger = LoggerFactory.getLogger(FileUploading.class);
	
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String productCode) {
	
				// get the real server path
				REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
				
				logger.info(REAL_PATH);	
				
				// create the directories if it does not exist
				
				if(!new File(REAL_PATH).exists()) {
					new File(REAL_PATH).mkdirs();
				}
				
				if(!new File(ABSOLUTE_PATH).exists()) {
					new File(ABSOLUTE_PATH).mkdirs();
				}
				
				try {
					//transfer the file to both locations : server and local
					file.transferTo(new File(REAL_PATH + productCode + ".jpg"));
					file.transferTo(new File(ABSOLUTE_PATH + productCode + ".jpg"));
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
				
				return true;
		
	}
	
	
}
