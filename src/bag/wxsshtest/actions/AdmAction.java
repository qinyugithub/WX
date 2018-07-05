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

import bag.wxsshtest.entities.Adm;
import bag.wxsshtest.service.AdmService;
@Component
@Scope("prototype")
public class AdmAction extends ActionSupport implements ServletResponseAware,
ModelDriven<Adm>, Preparable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdmService admService;
	
	private Adm adm; 
	

	public String check() throws IOException{
		System.out.println(adm);
		String str=admService.checkadm(adm.getName(), adm.getPassword());
		return str;
	}
	public void prepareCheck(){
		adm = new Adm();
	}
	

	@Override
	public Adm getModel() {
		return adm;
	}

	@Override
	public void prepare() throws Exception {} //该方法不执行
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

