package org.lavignelibrary.utilities;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.lavignelibrary.domain.Picture;
import org.springframework.web.multipart.MultipartFile;

public class PictureUtil {
	
	public static Picture saveImage(HttpServletRequest request, String filename, MultipartFile image) throws Exception {
		
		Picture picture = new Picture();
		
		String webRootPath =  request.getSession().getServletContext().getRealPath("/");
						
		picture.setLocation("/resources/uploaded_pictures/" + filename);
		picture.setDescription(filename);
		
		try{
			File file = new File(webRootPath + "/resources/uploaded_pictures/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			
		} catch(IOException e) { throw new Exception("Unable to save image", e); }
		
		return picture;
		
	}

	public static Picture saveDefaultProfileImage() {

		Picture picture = new Picture();
					
		picture.setLocation("/resources/images/human.jpg");
		picture.setDescription("human.jpg");
		
		return picture;

		
	}

	public static Picture saveDefaultBookImage() {

		Picture picture = new Picture();
					
		picture.setLocation("/resources/images/book.jpg");
		picture.setDescription("books.jpg");
		
		return picture;

		
	}
}
