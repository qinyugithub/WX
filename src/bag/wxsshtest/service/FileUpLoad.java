package bag.wxsshtest.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.fileupload.PictureUpload;

@Component
public class FileUpLoad {
	@Autowired
	private PictureUpload pictureUpload;
	
	public String savePicture(File file,String fileName) throws ServletException, IOException{
		String filename=pictureUpload.savePictupebyfilesource(file, fileName);
		return filename;
	}
	
	public String saveArticel(File file,String fileName) throws ServletException, IOException{
		String filename=pictureUpload.saveArticle(file, fileName);
		return filename;
	}
}
