package bag.wxsshtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.entities.User;
@Component
public class UserDao extends BaseDao{

	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);
	}

	public String getmessagebyprocess(String key){    //通过存储过程返回信息

		SQLQuery query = getSession().createSQLQuery("{Call QueryByKey(?)}");   
		query.setString(0, key);   
		List<Object[]> list =query.list(); 
		JSONObject returns = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Object[] obj : list) {
			JSONObject ad = new JSONObject();
			ad.put("id", obj[0].toString());
			ad.put("like", obj[1].toString());
			ad.put("event_key", obj[2].toString());
			jsonArray.put(ad);
		}
		 returns.put("query", jsonArray);
		 String str = returns.toString();
		return str;
	}

	public Activity getActivityById(Integer id){
		String hql = "FROM Activity e WHERE e.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id).setCacheable(true);
		Activity activity = (Activity) query.uniqueResult();
		//	System.out.println(activity.getDepartment().getClass().getName());
		return activity;
	}

	public User getActivityByAvtivityAndopenid(Activity activity,String openid){ //查询是否报名相同活动
		String hql = "FROM User u WHERE u.openid = ? and u.activity = ?";
		Query query = getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).setCacheable(true);
		User ac = (User) query.uniqueResult();
		return ac;
	}

/*	public List<Activity> getAlljoinActivity(String openid){    //获取用户参与的所有活动
		String hql = "select activity FROM User u WHERE u.openid =? order by u.id desc";
		return getSession().createQuery(hql).setString(0,openid).setCacheable(true).list();
	}*/
	public List<User> getAlljoinActivity(String openid){    //获取用户参与的所有活动
		String hql = "FROM User u WHERE u.openid =? order by u.id desc";
		return getSession().createQuery(hql).setString(0,openid).setCacheable(true).list();
	}

	public int delete(String openid,Activity activity){  //用户取消报名
		String hql = "DELETE FROM User u WHERE u.openid = ? and u.activity = ?";
		int i=getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).executeUpdate();
		System.out.println("已成功删除"+i+"条用户信息");
		return i;
	}

	public int qiandao(String openid,Activity activity){  //用户签到
		String hql = "update User u set u.activestate=1 where u.openid=? and u.activity= ?";
		int i=getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).executeUpdate();
		System.out.println("已签到"+i+"位用户");
		return i;
	}


	public Activity getactivitybymiyao(String miyao){  //通过密钥获取活动信息
		String hql = "FROM Activity a WHERE a.code=?";
		Query query = getSession().createQuery(hql).setString(0, miyao).setCacheable(true);
		Activity activity = (Activity) query.uniqueResult();
		return activity;
	}

}
