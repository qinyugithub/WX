package bag.wxsshtest.entities;

import java.util.Date;

public class Bar {

	private Integer id;

	private String pic;
	private String eventype;
	private String address;
	private String cnumber;
	private Date bartime;
	private Date bartime2;
	private String contact;
	private String introduce;
	private String title;
	private String username;
	private String city;
	private String undertaker;
	private String longitude;//¾­¶È
	private String latitude;//Î³¶È

	private String event_state;
	private boolean eventkey;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getEventype() {
		return eventype;
	}
	public void setEventype(String eventype) {
		this.eventype = eventype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public Date getBartime() {
		return bartime;
	}
	public void setBartime(Date bartime) {
		this.bartime = bartime;
	}
	public Date getBartime2() {
		return bartime2;
	}
	public void setBartime2(Date bartime2) {
		this.bartime2 = bartime2;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getUndertaker() {
		return undertaker;
	}
	public void setUndertaker(String undertaker) {
		this.undertaker = undertaker;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getEvent_state() {
		return event_state;
	}
	public void setEvent_state(String event_state) {
		this.event_state = event_state;
	}
	public boolean isEventkey() {
		return eventkey;
	}
	public void setEventkey(boolean eventkey) {
		this.eventkey = eventkey;
	}
	
	@Override
	public String toString() {
		return "Bar [id=" + id + ", pic=" + pic + ", eventype=" + eventype + ", address=" + address + ", cnumber="
				+ cnumber + ", bartime=" + bartime + ", bartime2=" + bartime2 + ", contact=" + contact + ", introduce="
				+ introduce + ", title=" + title + ", username=" + username + ", city=" + city + ", undertaker="
				+ undertaker + ", longitude=" + longitude + ", latitude=" + latitude + ", event_state=" + event_state
				+ ", eventkey=" + eventkey + "]";
	}


}
