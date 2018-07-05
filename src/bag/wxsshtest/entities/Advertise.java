package bag.wxsshtest.entities;

import java.util.Date;

public class Advertise {
	private Integer id;
	private String pic;
	private String evenitem;
	private String sponsor;
	private String etype;
	private String cost;
	private Date bartime;
	private Date bartime2;
	private String contact;
	private String introduce;
	private String username;
	private String city;
	
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
	public String getEvenitem() {
		return evenitem;
	}
	public void setEvenitem(String evenitem) {
		this.evenitem = evenitem;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
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
		return "Advertise [id=" + id + ", pic=" + pic + ", evenitem=" + evenitem + ", sponsor=" + sponsor + ", etype="
				+ etype + ", cost=" + cost + ", bartime=" + bartime + ", bartime2=" + bartime2 + ", contact=" + contact
				+ ", introduce=" + introduce + ", username=" + username + ", city=" + city + ", event_state="
				+ event_state + ", eventkey=" + eventkey + "]";
	}




}
