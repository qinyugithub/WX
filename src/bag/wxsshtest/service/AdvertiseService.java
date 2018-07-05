package bag.wxsshtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.AdvertiseDao;
import bag.wxsshtest.entities.Advertise;
@Component
public class AdvertiseService {
	@Autowired
	private AdvertiseDao advertiseDao;
	@Autowired
	private ClassToJson classtojson;
	String[] EXCLUDES = new String[]{""};
	public void saveOrUpdate(Advertise advertise){
		advertiseDao.saveOrUpdate(advertise);
	}
	/*
	public String changeadvertisefinish(Integer id){     //修改广告商活动的状态已完成
		Integer i=advertiseDao.changeadvertisestate("1", id);
		if(i>0){
			return "10001";
		}
		return "10002";
	}
	public String changeadvertisedelete(Integer id){  //修改广告商活动的状态已删除
		Integer i=advertiseDao.changeadvertisestate("-1", id);
		if(i>0){
			return "10001";
		}
		return "10002";
		
		
	}
	 */
	public String getAllAdvertiseByAdvertiseId(String xx,Integer id,String city){  //获取对象列表并转为json
		List<Advertise> advertises=new ArrayList<Advertise>();

		advertises=advertiseDao.getAdvertisesById(xx, id, city);
		//employees.clear();
		EXCLUDES = new String[]{"event_state","eventkey","username"};
		String str=classtojson.tojson(advertises,EXCLUDES);
		System.out.println("Advertisejson数组"+str);
		return str;
	}
}
