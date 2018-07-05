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

	public String getmessagebyprocess(String key){    //ͨ���洢���̷�����Ϣ

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

	public User getActivityByAvtivityAndopenid(Activity activity,String openid){ //��ѯ�Ƿ�����ͬ�
		String hql = "FROM User u WHERE u.openid = ? and u.activity = ?";
		Query query = getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).setCacheable(true);
		User ac = (User) query.uniqueResult();
		return ac;
	}

/*	public List<Activity> getAlljoinActivity(String openid){    //��ȡ�û���������л
		String hql = "select activity FROM User u WHERE u.openid =? order by u.id desc";
		return getSession().createQuery(hql).setString(0,openid).setCacheable(true).list();
	}*/
	public List<User> getAlljoinActivity(String openid){    //��ȡ�û���������л
		String hql = "FROM User u WHERE u.openid =? order by u.id desc";
		return getSession().createQuery(hql).setString(0,openid).setCacheable(true).list();
	}

	public int delete(String openid,Activity activity){  //�û�ȡ������
		String hql = "DELETE FROM User u WHERE u.openid = ? and u.activity = ?";
		int i=getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).executeUpdate();
		System.out.println("�ѳɹ�ɾ��"+i+"���û���Ϣ");
		return i;
	}

	public int qiandao(String openid,Activity activity){  //�û�ǩ��
		String hql = "update User u set u.activestate=1 where u.openid=? and u.activity= ?";
		int i=getSession().createQuery(hql).setString(0, openid).setEntity(1, activity).executeUpdate();
		System.out.println("��ǩ��"+i+"λ�û�");
		return i;
	}


	public Activity getactivitybymiyao(String miyao){  //ͨ����Կ��ȡ���Ϣ
		String hql = "FROM Activity a WHERE a.code=?";
		Query query = getSession().createQuery(hql).setString(0, miyao).setCacheable(true);
		Activity activity = (Activity) query.uniqueResult();
		return activity;
	}

}
