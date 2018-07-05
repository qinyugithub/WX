package bag.wxsshtest.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bag.wxsshtest.entities.Bar;
import bag.wxsshtest.service.BarService;

@Component
@Scope("prototype")
public class BarAction extends ActionSupport implements ServletResponseAware,
ModelDriven<Bar>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private BarService barService;
	private Bar bar; 
	private String XX;
	private Integer id;
	private String city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String save() throws IOException{  //保存酒吧活动信息
		bar.setEventkey(true);
		String str=barService.saveOrUpdate(bar);
		response.getWriter().write(str); 
		return null;
	}
	public void prepareSave(){
		bar = new Bar();
	}
	
	public String select() throws IOException{  //返回酒吧活动信息
		System.out.println("XX:"+XX+"id:"+id+"city:"+city);
		String str=barService.getAllBarsByBarId(XX, id, city);
		String str2="{\"barinfo\":"+str+"}";
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}
	/*
	public String barstatefinish() throws IOException {  //修改活动状态已完成
		String str=barService.changebarfinish(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	public String barstatedelete() throws IOException {  //修改活动状态已删除
		String str=barService.changebardelete(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	*/
	
	
	
	
	
	
	
	

	@Override
	public Bar getModel() {
		return bar;
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
