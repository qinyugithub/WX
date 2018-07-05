package bag.wxsshtest.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.service.ActivityService;
import bag.wxsshtest.service.AdmService;

@Component
@Scope("prototype")
public class ActivityAction extends ActionSupport implements ServletResponseAware,RequestAware,
ModelDriven<Activity>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private AdmService admServer;

	private Activity activity; 

	private String XX;
	private Integer id;
	private String city;
	private Integer pass;
	private String username;
	private double longitude;
	private double latitude;

	private Integer id1;
	private Integer id2;
	private Integer id3;



	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	public Integer getId3() {
		return id3;
	}

	public void setId3(Integer id3) {
		this.id3 = id3;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Integer getPass() {
		return pass;
	}
	public void setPass(Integer pass) {
		this.pass = pass;
	}
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

	public String selectactivitybyxy() throws IOException{  //通过经纬度返回一定范围内的活动
		String str=activityService.getActivitybyxy(longitude, latitude);
		String str2="{\"mapinfo\":"+str+"}";
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}

	public String getactivitybyusername() throws IOException {  //获取某用户发布的大活动
		String str=activityService.getfabuactivity(username);
		String str2="{\"actinfo\":"+str+"}";
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}

	public String savehotactivitys() throws IOException{  //将热门活动写入json文件
		if(admServer.runtocheckadm()==0){return null;}
		
		String url=activityService.savehotactivitys(id1, id2, id3);
		request.put("url",url);
		return "writeok";
	}

	public String listactivity() {  //查询所有活动并列出
		if(admServer.runtocheckadm()==0){return null;}
		
		List<Activity> activitys=activityService.getAlltocheck(1);
		request.put("activitys",activitys);
		return "activitys";
	}


	public String activitystatefinish() throws IOException {  //修改活动状态已完成
		String str=activityService.changeactivityfinish(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	public String activitystatedelete() throws IOException {  //修改活动状态已删除
		String str=activityService.changeactivitydelete(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}


	public String save() throws IOException{
		System.out.println(activity);
		activityService.saveOrUpdate(activity);
		response.getWriter().write("10001"); 
		return null;
	}
	public void prepareSave(){
		activity = new Activity();
	}

	public String select() throws IOException
	{
		System.out.println("XX:"+XX+"id:"+id+"city:"+city);
		String str=activityService.getAllActivitysByActivityId(XX, id, city);
		String str2="{\"actinfo\":"+str+"}";
		System.out.println(str2);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}


	public String checkactivity() throws IOException {    //转到相应的页面
		if(admServer.runtocheckadm()==0){return null;}

		request.put("activitys", activityService.getAlltocheck(pass));
		if(pass==1){
			return "listpass";
			//	return null;
		}else if(pass==0){
			return "list";
			//	return null;
		}
		return "listnotpass";
		//return null;
	}

	public String pass() throws IOException {      //通过审核
		if(admServer.runtocheckadm()==0){return null;}
		
		activityService.passActivity(id);
		return "finish";
	}
	public String notpass() {    //未通过审核
		if(admServer.runtocheckadm()==0){return null;}
		
		activityService.notpassActivity(id);
		return "finish";
	}
	public String passnotpass() {      //将通过审核的活动下架
		if(admServer.runtocheckadm()==0){return null;}
		
		activityService.notpassActivity(id);
		return "passnotpass";
	}
	public String notpasspass() throws IOException {    //将未通过审核的活动通过
		if(admServer.runtocheckadm()==0){return null;}
		
		activityService.passActivity(id);
		return "notpasspass";
	}

	public String getactivitycodebyidandusername() throws IOException {    //发布者获取活动二维码
		String str=activityService.getactivitybyusernameandid(username, id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}


	@Override
	public Activity getModel() {
		return activity;
	}

	@Override
	public void prepare() throws Exception {} //该方法不执行

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

