package bag.wxsshtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.ActivityDao;
import bag.wxsshtest.dao.AdvertiseDao;
import bag.wxsshtest.dao.BarDao;
import bag.wxsshtest.dao.ManagerDao;
import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.entities.Advertise;
import bag.wxsshtest.entities.Bar;
import bag.wxsshtest.entities.Manager;
@Component
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private BarDao barDao;
	@Autowired
	private AdvertiseDao advertiseDao;
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ClassToJson classtojson;

	String[] EXCLUDES = new String[]{""};

	public String getdetilactivity(Integer id,String event_key){  //检索详细信息
		String str=null;
		String str2=null;
		if(event_key.equals("1")){
			Bar bar=barDao.get(id);
			str=classtojson.tojson(bar,EXCLUDES);
			str2="{\"activity\":"+str+"}";
		}else if(event_key.equals("0")){
			Advertise advertise=advertiseDao.get(id);
			str=classtojson.tojson(advertise,EXCLUDES);
			str2="{\"activity\":"+str+"}";
		}else if(event_key.equals("-1")){
			Activity activity=activityDao.get(id);
			str=classtojson.tojson(activity,EXCLUDES);
			str2="{\"activity\":"+str+"}";
		}
		return str2;

	}



	public String saveOrUpdate(Manager manager){
		String name=manager.getRoll_username();
		String phone=manager.getPhone_numb();
		Manager m=managerDao.selectManagerByNameandPhone(name, phone);
		if(m==null){
			managerDao.saveOrUpdate(manager);
			return "10001";
		}else{
			return "10010";
		}
	}

	public String checkdenglutai(String username,String denglutai){
		Manager manager=managerDao.checkpersonbydenglutaiandusername(username, denglutai);
		if(manager==null){
			return "10010";
		}			
		return "10001";
	}

	public String returnadvandbar(String userid){
		List<Bar> bars=new ArrayList<Bar>();
		List<Advertise> advertises=new ArrayList<Advertise>();
		bars=barDao.getbarsbyusername(userid);
		advertises=advertiseDao.getadvertisesbyusername(userid);

		JSONObject returns = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for (Bar ba : bars)
		{
			JSONObject ad = new JSONObject();
			ad.put("img",ba.getPic() );
			ad.put("city",ba.getCity());
			ad.put("eventstate",ba.getEvent_state());
			ad.put("eventkey",ba.isEventkey());
			ad.put("canvas_id", ba.getId());
			ad.put("detil",ba.getIntroduce() );
			ad.put("phone",ba.getContact());
			ad.put("title",ba.getTitle());
			ad.put("timestart",ba.getBartime().toString().substring(0, 13));
			ad.put("time2",ba.getBartime2().toString().substring(0, 13));
			ad.put("type",ba.getEventype());
			ad.put("undertaker",ba.getUndertaker());
			ad.put("userid",ba.getUsername());
			jsonArray.put(ad);
		}
		for (Advertise adv : advertises)
		{
			JSONObject ad = new JSONObject();
			ad.put("img",adv.getPic() );
			ad.put("city",adv.getCity());
			ad.put("eventstate",adv.getEvent_state());
			ad.put("eventkey",adv.isEventkey());
			ad.put("canvas_id",adv.getId() );
			ad.put("detil",adv.getIntroduce() );
			ad.put("phone",adv.getContact());
			ad.put("title",adv.getEvenitem());
			ad.put("timestart",adv.getBartime().toString().substring(0, 13));
			ad.put("time2",adv.getBartime2().toString().substring(0, 13));
			ad.put("type",adv.getEtype());
			ad.put("undertaker",adv.getSponsor());
			ad.put("userid", adv.getUsername());
			jsonArray.put(ad);
		}

		returns.put("barandadv", jsonArray);
		String str = returns.toString();
		System.out.println("barandadv" + str);
		return str;

	}
	public String deleteadvandbar(String table,Integer id){ //删除联合查询的某一活动
		if(table.equals("adv")){
			Integer i=advertiseDao.changeadvertisestate("-1", id);
			if(i>0){
				return "10001";
			}
			return "10002";

		}else if(table.equals("bar")){
			Integer i=barDao.changebarstate("-1", id);
			if(i>0){
				return "10001";
			}
			return "10002";
		}
		return "10002";
	}
	public String finishadvandbar(String table,Integer id){ //完成联合查询的某一活动
		if(table.equals("adv")){
			Integer i=advertiseDao.changeadvertisestate("1", id);
			if(i>0){
				return "10001";
			}
			return "10002";

		}else if(table.equals("bar")){
			Integer i=barDao.changebarstate("1", id);
			if(i>0){
				return "10001";
			}
			return "10002";	
		}
		return "10002";
	}

	public String getManagerByUsername(String username){  //根据username获取注册者信息
		Manager manager= managerDao.selectManagerByUsername(username);
		if(manager==null){
			return "10001-1";
		}else{
			EXCLUDES = new String[]{"code","codecreatetime","denglutai","email","passwords","r_type","type_address","type_major"};
			String str=classtojson.tojson(manager,EXCLUDES);
			String str2="{\"manager\":"+str+"}";
			System.out.println("Manager为"+str2);
			return str2;
		}
	}

	public String checkManagerByNameAndPasswords(String Managername,String password){ //登录验证
		Manager manager=managerDao.selectManagerByNameAndPasswords(Managername, password);
		if(manager!=null){
			String username=manager.getRoll_username();
			String denglutai = String.valueOf((new Random().nextInt(899999) + 100000));
			managerDao.changedenglutai(username, denglutai);
			return 	"{\"username\": \""+username+"\",\"denglutai\": \""+denglutai+"\",\"message\": \"10001\"}";	
		}
		return "10002";
	}

}
