package bag.wxsshtest.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.qcloudsms.httpclient.HTTPException;

import bag.wxsshtest.codes.GetCodes;
import bag.wxsshtest.dao.ManagerDao;
import bag.wxsshtest.entities.Manager;
@Component
public class CodesService {
	@Autowired
	private GetCodes getCode;
	@Autowired
	private ManagerDao managerDao;


	public void getcodes(String phone) throws JSONException, HTTPException, IOException{
		String code=getCode.getcodesbyphone(phone);
		Integer i=managerDao.changecode(code, phone);
		System.out.println("已更新"+i+"条数据");
	}

	public String checkcodes(String phone,String code) throws ParseException {
		Manager manager=managerDao.selectManagerByPhone(phone);
		if(manager !=null){
			Date date1=new Date();
			Date date2=manager.getCodecreatetime();
			Date date3=new Date(date1.getTime() - 5 * 60 * 1000);
			int i= date2.compareTo(date3);
		//	String denglutai=manager.getCode();
			if(i==1){				
				if(manager.getCode().equals(code)){
					String denglutai = String.valueOf((new Random().nextInt(899999) + 100000));
					managerDao.changedenglutaibyphone(phone, denglutai);
					String username=manager.getRoll_username();
					return "{\"username\": \""+username+"\",\"denglutai\": \""+denglutai+"\",\"message\": \"10001\"}";	//验证通过
				}else{
					return "{\"message\": \"10010\"}"; //验证码错误
				}
			}else{
				return "{\"message\": \"10011\"}";  //验证码超时
			}
		}
		return "{\"message\": \"10012\"}";  //无该手机号码
	}

}
