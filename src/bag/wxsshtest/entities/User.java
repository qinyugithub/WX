package bag.wxsshtest.entities;

import java.util.Date;

public class User {

	private Integer id;
	private String openid;
	private String name;
	private String phone;
	private Activity activity; //�û������
	private Date currentime; //����ʱ��
	private boolean activestate; //�û��״̬��δ������0���������ɨ�������״̬���1
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
