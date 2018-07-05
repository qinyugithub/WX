package bag.wxsshtest.entities;

import java.util.Date;

public class Manager {
	private Integer id;
	
	private String roll_username;//用户名
	private String phone_numb;
	private String email;
	private String r_type;//注册类型
	
	private String type_name;//类型名称
	private String type_address;//类型地址
	private String passwords;
	private String code;//验证码
	private Date codecreatetime;//验证码创建时间
	private String denglutai;
	private String type_major;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoll_username() {
		return roll_username;
	}
	public void setRoll_username(String roll_username) {
		this.roll_username = roll_username;
	}
	public String getPhone_numb() {
		return phone_numb;
	}
	public void setPhone_numb(String phone_numb) {
		this.phone_numb = phone_numb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_address() {
		return type_address;
	}
	public void setType_address(String type_address) {
		this.type_address = type_address;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCodecreatetime() {
		return codecreatetime;
	}
	public void setCodecreatetime(Date codecreatetime) {
		this.codecreatetime = codecreatetime;
	}
	
	public String getDenglutai() {
		return denglutai;
	}
	public void setDenglutai(String denglutai) {
		this.denglutai = denglutai;
	}
	
	public String getType_major() {
		return type_major;
	}
	public void setType_major(String type_major) {
		this.type_major = type_major;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", roll_username=" + roll_username + ", phone_numb=" + phone_numb + ", email="
				+ email + ", r_type=" + r_type + ", type_name=" + type_name + ", type_address=" + type_address
				+ ", passwords=" + passwords + ", code=" + code + ", codecreatetime=" + codecreatetime + ", denglutai="
				+ denglutai + ", type_major=" + type_major + "]";
	}

}
