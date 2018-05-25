package ma.fstbm.easyshopping.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploading {

	private static final String ABSOLUTE_PATH = "C:\\Users\\Nabil\\Documents\\my_workspace\\EasyShopping\\easyshopping\\src\\main\\webapp\\assets\\images\\";
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
	
	
	public static void uploadNoImage(HttpServletRequest request, String code) {
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
	
		String imageURL = "C:\\Users\\Nabil\\Documents\\my_workspace\\EasyShopping\\easyshopping\\src\\main\\webapp\\assets\\images\\640X480.png";
		String destinationServerFile = REAL_PATH + code + ".jpg";
		String destinationProjectFile = REAL_PATH + code + ".jpg";
				
		try {
			URL url = new URL(imageURL);				
			try (	
					InputStream is = url.openStream();
					OutputStream osREAL_PATH = new FileOutputStream(destinationServerFile);
					OutputStream osABS_PATH = new FileOutputStream(destinationProjectFile);
				){
			
				byte[] b = new byte[2048];
				int length;
				while((length = is.read(b))!= -1) {
					osREAL_PATH.write(b, 0, length);
					osABS_PATH.write(b, 0, length);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
