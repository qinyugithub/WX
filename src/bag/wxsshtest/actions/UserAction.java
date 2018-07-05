package bag.wxsshtest.actions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bag.wxsshtest.entities.User;
import bag.wxsshtest.service.UserService;

@Component
@Scope("prototype")
public class UserAction extends ActionSupport implements ServletResponseAware,
ModelDriven<User>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private User user; 
	private Integer roll_id;//活动id
	private String openid;
	private String miyao;
	private String key;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMiyao() {
		return miyao;
	}
	public void setMiyao(String miyao) {
		this.miyao = miyao;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getRoll_id() {
		return roll_id;
	}
	public void setRoll_id(Integer roll_id) {
		this.roll_id = roll_id;
	}

	public String querybykey() throws IOException {   //模糊查询

		String message=userService.querybykey(key);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}
	
	public String save() throws IOException{
		user.setCurrentime(new Date());
		System.out.println(user);
		String message=userService.saveOrUpdate(user,roll_id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}
	public void prepareSave(){
		user = new User();
	}

/*	public String makecode() throws IOException{
		userService.makecode("秦宇", "标题");
		return null;
	}*/
	
	public String geractivitybyopenid() throws IOException {   //通过openid返回用户参与的活动
		String str=userService.selectjoinactivity(openid);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	
	public String deleteuser() throws IOException {   //用户取消报名
		String str=userService.deleteuser(openid, roll_id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	
	public String qiandao() throws IOException {   //用户签到
		String str=userService.qiandao(openid, miyao);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	

	@Override
	public User getModel() {
		return user;
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
