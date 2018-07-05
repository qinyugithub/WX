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

import bag.wxsshtest.entities.Advertise;
import bag.wxsshtest.service.AdvertiseService;

@Component
@Scope("prototype")
public class AdvertiseAction extends ActionSupport implements ServletResponseAware,
ModelDriven<Advertise>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdvertiseService advertiseServise;
	private Advertise adveritse; 
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
	public String save() throws IOException{
		System.out.println(adveritse);
		advertiseServise.saveOrUpdate(adveritse);
		response.getWriter().write("10001"); 
		return null;
	}
	public void prepareSave(){
		adveritse = new Advertise();
	}
	
	public String select() throws IOException{  //���ع���̻��Ϣ
		System.out.println("XX:"+XX+"id:"+id+"city:"+city);
		String str=advertiseServise.getAllAdvertiseByAdvertiseId(XX, id, city);
		String str2="{\"advinfo\":"+str+"}";
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str2); 
		return null;
	}
	/*
	public String advertisestatefinish() throws IOException {  //�޸Ļ״̬�����
		String str=advertiseServise.changeadvertisefinish(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	public String advertisestatedelete() throws IOException {  //�޸Ļ״̬��ɾ��
		String str=advertiseServise.changeadvertisedelete(id);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(str); 
		return null;
	}
	*/

	@Override
	public Advertise getModel() {
		return adveritse;
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

