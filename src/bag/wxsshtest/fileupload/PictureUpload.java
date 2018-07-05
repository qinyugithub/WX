package bag.wxsshtest.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
@Component
public class PictureUpload {

	public String savePictupebyfilesource(File file,String fileName) throws ServletException, IOException  { 

		 
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/files/" + fileName);
		System.out.println("Â·¾¶ "+dir);
		
		FileOutputStream out = new FileOutputStream(dir);
		FileInputStream in = new FileInputStream(file);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		out.close();
	    in.close();

		return fileName;
	}
	
	public String saveArticle(File file,String fileName) throws ServletException, IOException  { 

		 
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/articleandhotactivity/" + fileName);
		System.out.println("Â·¾¶ "+dir);
		FileOutputStream out = new FileOutputStream(dir);
		FileInputStream in = new FileInputStream(file);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		out.close();
	    in.close();
		return fileName;
	}
	
	
	
	
}
