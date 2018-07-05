package bag.wxsshtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.BarDao;
import bag.wxsshtest.entities.Bar;
@Component
public class BarService {
	@Autowired
	private BarDao barDao;
	@Autowired
	private ClassToJson classtojson;
	String[] EXCLUDES = new String[]{""};
	public String saveOrUpdate(Bar bar){
		String str=barDao.saveOrUpdate(bar);
		return str;
	}
	/*
	public String changebarfinish(Integer id){     //�޸ľưɻ��״̬�����
		Integer i=barDao.changebarstate("1", id);
		if(i>0){
			return "10001";
		}
		return "10002";
	}
	public String changebardelete(Integer id){  //�޸ľưɻ��״̬��ɾ��
		Integer i=barDao.changebarstate("-1", id);
		if(i>0){
			return "10001";
		}
		return "10002";
	}
	*/
	public String getAllBarsByBarId(String xx,Integer id,String city){  //��ȡ�����б�תΪjson
		List<Bar> bars=new ArrayList<Bar>();
		
		bars=barDao.getBarsById(xx, id, city);
//		employees.clear();
		EXCLUDES = new String[]{"event_state","eventkey","username"};
		String str=classtojson.tojson(bars,EXCLUDES);
		System.out.println("Advertisejson����"+str);
		return str;
	}
}
