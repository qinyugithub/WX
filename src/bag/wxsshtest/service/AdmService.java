package bag.wxsshtest.service;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.dao.AdmDao;
import bag.wxsshtest.entities.Adm;
@Component
public class AdmService {
	@Autowired
	private AdmDao admDao;
	
	public String checkadm(String name,String password){     //系统管理员验证
		Adm adm=admDao.checkAdm(name, password);
		if(adm==null){
			return "no";
		}
		ServletActionContext.getRequest().getSession().setAttribute("adm", adm);
		return "yes";
	}

	public int  runtocheckadm(){     //验证系统管理员是否登录
	Adm adm=(Adm) ServletActionContext.getRequest().getSession().getAttribute("adm");
		if(adm==null){
			return 0;
		}
		return 1;
	}


}
