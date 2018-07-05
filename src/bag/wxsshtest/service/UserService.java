package bag.wxsshtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.UserDao;
import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.entities.User;
import bag.wxsshtest.openid.OpenIdUtil;
@Component
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private ClassToJson classtojson;
	
	@Autowired
	private OpenIdUtil openIdUtil;
	String[] EXCLUDES = new String[]{""};
	
	public String saveOrUpdate(User user,Integer roll_id){
		
		String openid=openIdUtil.oauth2GetOpenid(user.getOpenid());
	//	System.out.println(openid);
			
		Activity activity=userDao.getActivityById(roll_id);
	//	String openid=user.getOpenid();

		User ac=userDao.getActivityByAvtivityAndopenid(activity, openid); //确保没有重复报名
		if(ac==null){
			String number=activity.getMinpeo();
			int joinnumber=activity.getJoinnumber();
			int num = (int) ((int)Integer.parseInt(number)*1.2);   //能容纳的最大人数

			if (joinnumber<num||num==-1)
			{
				user.setOpenid(openid);
				user.setActivity(activity);
				userDao.saveOrUpdate(user);
				return "10001";
			}else{
				return "10020";
			}
		}
		return "10010";

	}

	public String querybykey(String key){ //模糊查询
		System.out.println(key);
		if(key.length()==0){
			return "10002";
		}
		String list=userDao.getmessagebyprocess(key);
		return list;
	}

	public String deleteuser(String code,Integer activityid){ //用户取消报名
		String openid=openIdUtil.oauth2GetOpenid(code);
		Activity activity=new Activity();
		activity.setId(activityid);	
		int i=userDao.delete(openid, activity);
		if(i>0){
			System.out.println("取消报名成功");
			return "10001";
		}
		return "10002";
	}

	public String selectjoinactivity(String code) {
		String openid=openIdUtil.oauth2GetOpenid(code);
		List<User> users= userDao.getAlljoinActivity(openid);
		EXCLUDES = new String[]{"currentime","name","openid","phone"};
		String str=classtojson.tojson(users,EXCLUDES);
		System.out.println("users的json数组"+str);
		return str;
	}

	public String qiandao(String code,String miyao) {
		String openid=openIdUtil.oauth2GetOpenid(code);
		Activity activity= userDao.getactivitybymiyao(miyao);  //通过密钥获取活动信息
		int i=userDao.qiandao(openid, activity);   //通过活动信息更改用户签到状态
		if(i>0){
			return "10001";
		}else
			return "10002";
	}


}
