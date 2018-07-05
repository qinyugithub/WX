package bag.wxsshtest.actions;


import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bag.wxsshtest.entities.Forum;
import bag.wxsshtest.service.ForumService;
@Component
@Scope("prototype")
public class ForumAction extends ActionSupport implements ServletResponseAware,
ModelDriven<Forum>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ForumService forumService;

	private Forum forum; 
	private String XX;
	private Integer id;
	
	public String getXX() {
		return XX;
	}
	public void setXX(String xX) {
		XX = xX;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String select() throws IOException{
		System.out.println("XX:"+XX+"id:"+id);
		String str=forumService.getAllForumsById(XX, id);
		String str2="{\"forum\":"+str+"}";
		System.out.println(str2);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}
	
	
	
	public String save() throws IOException{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		String datetime = tempDate.format(new java.util.Date());  
		forum.setDate(datetime);
		System.out.println(datetime);
		System.out.println("改正后"+forum);
		forumService.saveForum(forum);
		response.getWriter().write("10001"); 
		return null;
	}
	public void prepareSave(){
		forum = new Forum();
	}

	@Override
	public Forum getModel() {
		return forum;
	}

	@Override
	public void prepare() throws Exception {} //该方法不执行

	//得到response
	private  HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;

	}

}

