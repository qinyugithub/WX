package bag.wxsshtest.actions;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.qcloudsms.httpclient.HTTPException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bag.wxsshtest.entities.Manager;
import bag.wxsshtest.service.CodesService;
import bag.wxsshtest.service.ManagerService;

@Component
@Scope("prototype")
public class ManagerAction extends ActionSupport implements ServletResponseAware,
ModelDriven<Manager>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private CodesService codeService;
	private Manager manager; 

	private String username;
	private String passwords;
	private String phone;
	private String code;
	private String denglutai;
	private String eventkey;
	private Integer id;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEventkey() {
		return eventkey;
	}
	public void setEventkey(String eventkey) {
		this.eventkey = eventkey;
	}
	public String getDenglutai() {
		return denglutai;
	}
	public void setDenglutai(String denglutai) {
		this.denglutai = denglutai;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	
	
	public String getdetilactivity() throws IOException{    //�������ϸ��Ϣ
		String message=managerService.getdetilactivity(id, eventkey);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}

	public String finishbarandadv() throws IOException{     //������ϻ��ĳһ�
		String message="10002";
		if(eventkey.equals("true")){
			message=managerService.finishadvandbar("bar", id);
		}
		else if(eventkey.equals("false")){
			message=managerService.finishadvandbar("adv", id);
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}
	public String deletebarandadv() throws IOException{     //ɾ�����ϻ��ĳһ�
		String message="10002";
		if(eventkey.equals("true")){
			message=managerService.deleteadvandbar("bar", id);
		}
		else if(eventkey.equals("false")){
			message=managerService.deleteadvandbar("adv", id);
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}



	public String save() throws IOException{     //�������Ա��Ϣ
		System.out.println(manager);
		String message=managerService.saveOrUpdate(manager);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}
	public void prepareSave(){
		manager = new Manager();
	}

	public String returnadvandbarbyusername() throws IOException{    //��ȡ����Ա�����Ĺ���̺;ưɻ
		String message=managerService.returnadvandbar(username);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}

	public String checknameandpassword() throws IOException{    //��֤��¼�˺�����
		String message=managerService.checkManagerByNameAndPasswords(username, passwords);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}

	public String getManagerByUsername() throws IOException{    //ͨ��username��ȡע������Ϣ
		String message=managerService.getManagerByUsername(username);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message); 
		return null;
	}

	public String getcode() throws JSONException, HTTPException, IOException {     //�õ���֤��
		codeService.getcodes(phone);
		return null;
	}

	public String checkdenglutai() throws IOException  {     //����¼̬
		String message=managerService.checkdenglutai(username, denglutai);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(message);
		return null;
	}

	public String checkcode() throws ParseException, IOException{     //��֤����֤��
		String str=codeService.checkcodes(phone, code);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}

	@Override
	public Manager getModel() {
		return manager;
	}

	@Override
	public void prepare() throws Exception {} //�÷�����ִ��

	//�õ�response
	private  HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}



}
