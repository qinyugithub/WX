package bag.wxsshtest.actions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import bag.wxsshtest.service.AdmService;
import bag.wxsshtest.service.FileUpLoad;
@Component
@Scope("prototype")
public class FileUpload extends ActionSupport implements ServletResponseAware,RequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private FileUpLoad er;
	@Autowired
	private AdmService admServer;

	private File file;
	private String fileContentType;
	private String fileFileName;

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	//文件上传
	public String fileupload() throws ServletException, IOException {   //活动图片上传
		System.out.println(file);
		System.out.println(fileContentType);
		System.out.println(fileFileName);
		String str=null;
		if(fileFileName.length()>14){
			int beginIndex = fileFileName.length()-14;
			int endIndex = fileFileName.length();
			str = "wx"+fileFileName.substring(beginIndex, endIndex);
		}else{
			str="wx"+fileFileName;
		}
		String fileName=er.savePicture(file, str);

		 String picturePath="https://www.qinyu123456.xyz//lindu//files"+"//"+fileName;
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(picturePath); 
		return null;
	}
	
	
	
	public String savearticle() throws ServletException, IOException {   //文章上传
		if(admServer.runtocheckadm()==0){return null;}
		
		
		System.out.println(file);
		System.out.println(fileContentType);
		System.out.println(fileFileName);
		String fileName=er.saveArticel(file, fileFileName);

		 String url="https://www.qinyu123456.xyz//lindu//articleandhotactivity"+"//"+fileName;
		 request.put("url", url);
		return "success";
	}
	
	
	
	

	//得到response
	private  HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}
	
	
	//得到request
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
