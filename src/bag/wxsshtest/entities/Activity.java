package bag.wxsshtest.entities;

import java.util.Date;

public class Activity {
	private Integer id;
	
	private String img;
	private String iteminput;//活动主题
	private String maininput;//主办方
	private String chenginput;//承办方
	private String etype;
	private String address;
	private Date timeinputone;
	private Date timeinputtwo;
	private String lphone;
	private String eventwords; //宣传语
	private String eventdetail;//详情
	private String eventwards;//奖励
	private String minpeo;
	private String money;
	private String costre;//规则
	private String username;
	private String city;
	private double longitude;//经度
	private double latitude;//纬度

	private String code;//二维码密钥
	private Integer pass;
	private Integer joinnumber;
	private Integer event_state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIteminput() {
		return iteminput;
	}
	public void setIteminput(String iteminput) {
		this.iteminput = iteminput;
	}
	public String getMaininput() {
		return maininput;
	}
	public void setMaininput(String maininput) {
		this.maininput = maininput;
	}
	public String getChenginput() {
		return chenginput;
	}
	public void setChenginput(String chenginput) {
		this.chenginput = chenginput;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getTimeinputone() {
		return timeinputone;
	}
	public void setTimeinputone(Date timeinputone) {
		this.timeinputone = timeinputone;
	}
	public Date getTimeinputtwo() {
		return timeinputtwo;
	}
	public void setTimeinputtwo(Date timeinputtwo) {
		this.timeinputtwo = timeinputtwo;
	}
	public String getLphone() {
		return lphone;
	}
	public void setLphone(String lphone) {
		this.lphone = lphone;
	}
	public String getEventwords() {
		return eventwords;
	}
	public void setEventwords(String eventwords) {
		this.eventwords = eventwords;
	}
	public String getEventdetail() {
		return eventdetail;
	}
	public void setEventdetail(String eventdetail) {
		this.eventdetail = eventdetail;
	}
	public String getEventwards() {
		return eventwards;
	}
	public void setEventwards(String eventwards) {
		this.eventwards = eventwards;
	}
	public String getMinpeo() {
		return minpeo;
	}
	public void setMinpeo(String minpeo) {
		this.minpeo=minpeo;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCostre() {
		return costre;
	}
	public void setCostre(String costre) {
		this.costre = costre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getPass() {
		return pass;
	}
	public void setPass(Integer pass) {
		this.pass = pass;
	}
	public Integer getJoinnumber() {
		return joinnumber;
	}
	public void setJoinnumber(Integer joinnumber) {
		this.joinnumber = joinnumber;
	}
	public Integer getEvent_state() {
		return event_state;
	}
	public void setEvent_state(Integer event_state) {
		this.event_state = event_state;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", img=" + img + ", iteminput=" + iteminput + ", maininput=" + maininput
				+ ", chenginput=" + chenginput + ", etype=" + etype + ", address=" + address + ", timeinputone="
				+ timeinputone + ", timeinputtwo=" + timeinputtwo + ", lphone=" + lphone + ", eventwords=" + eventwords
				+ ", eventdetail=" + eventdetail + ", eventwards=" + eventwards + ", minpeo=" + minpeo + ", money="
				+ money + ", costre=" + costre + ", username=" + username + ", city=" + city + ", longitude="
				+ longitude + ", latitude=" + latitude + ", code=" + code + ", pass=" + pass + ", joinnumber="
				+ joinnumber + ", event_state=" + event_state + "]";
	}
	



}
