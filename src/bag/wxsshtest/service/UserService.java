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

		User ac=userDao.getActivityByAvtivityAndopenid(activity, openid); //ȷ��û���ظ�����
		if(ac==null){
			String number=activity.getMinpeo();
			int joinnumber=activity.getJoinnumber();
			int num = (int) ((int)Integer.parseInt(number)*1.2);   //�����ɵ��������

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

	public String querybykey(String key){ //ģ����ѯ
		System.out.println(key);
		if(key.length()==0){
			return "10002";
		}
		String list=userDao.getmessagebyprocess(key);
		return list;
	}

	public String deleteuser(String code,Integer activityid){ //�û�ȡ������
		String openid=openIdUtil.oauth2GetOpenid(code);
		Activity activity=new Activity();
		activity.setId(activityid);	
		int i=userDao.delete(openid, activity);
		if(i>0){
			System.out.println("ȡ�������ɹ�");
			return "10001";
		}
		return "10002";
	}

	public String selectjoinactivity(String code) {
		String openid=openIdUtil.oauth2GetOpenid(code);
		List<User> users= userDao.getAlljoinActivity(openid);
		EXCLUDES = new String[]{"currentime","name","openid","phone"};
		String str=classtojson.tojson(users,EXCLUDES);
		System.out.println("users��json����"+str);
		return str;
	}

	public String qiandao(String code,String miyao) {
		String openid=openIdUtil.oauth2GetOpenid(code);
		Activity activity= userDao.getactivitybymiyao(miyao);  //ͨ����Կ��ȡ���Ϣ
		int i=userDao.qiandao(openid, activity);   //ͨ�����Ϣ�����û�ǩ��״̬
		if(i>0){
			return "10001";
		}else
			return "10002";
	}


}
