package bag.wxsshtest.entities;

import java.util.Date;

public class User {

	private Integer id;
	private String openid;
	private String name;
	private String phone;
	private Activity activity; //用户报名活动
	private Date currentime; //报名时间
	private boolean activestate; //用户活动状态，未参与是0，活动过程中扫码请求后状态变成1
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Date getCurrentime() {
		return currentime;
	}
	public void setCurrentime(Date currentime) {
		this.currentime = currentime;
	}
	public boolean isActivestate() {
		return activestate;
	}
	public void setActivestate(boolean activestate) {
		this.activestate = activestate;
	}
	
	

}
