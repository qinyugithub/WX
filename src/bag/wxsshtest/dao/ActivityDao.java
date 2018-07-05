package bag.wxsshtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Activity;
@Component
public class ActivityDao extends BaseDao {

	public void saveOrUpdate(Activity activity){
		getSession().saveOrUpdate(activity);
	}
	/*
	public List<Activity> getactivitybyiteminput(String iteminput){  //模糊查询大活动
		String hql = "FROM Activity e WHERE e.iteminput like '%"+iteminput+"%' and e.pass =1 and e.event_state=0";
		return getSession().createQuery(hql).setCacheable(true).list();
	}
*/
	public double[] selectrangebyxy(double longitude,double latitude){   //通过经纬度确定范围
		//先计算查询点的经纬度范围  
		double r = 6371;//地球半径千米  
	//	double dis = 1.5;//0.5千米距离  
		double dis = 100;//0.5千米距离  
		double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));  
		dlng = dlng*180/Math.PI;//角度转为弧度  
		double dlat = dis/r;  
		dlat = dlat*180/Math.PI;          
		double minlat =latitude-dlat;  
		double maxlat = latitude+dlat;  
		double minlng = longitude -dlng;  
		double maxlng = longitude + dlng;  
		double[] values = {minlng,maxlng,minlat,maxlat}; 
		return values;
	}
	
	public List<Activity> getActivitysbyxy(double[] d){  //通过经纬度范围查找活动
	 String hql = "from Activity a where a.longitude>=? and a.longitude <=? and a.latitude >=? and a.latitude<=? and a.pass=1 and a.event_state=0";  
	 return getSession().createQuery(hql).setDouble(0,d[0]).setDouble(1,d[1]).setDouble(2,d[2]).setDouble(3,d[3]).setCacheable(true).list();
	//	String hql = "FROM Activity e WHERE e.pass =1";
	//	return getSession().createQuery(hql).setCacheable(true).list();
	}

	public List<Activity> getHotActivitys(Integer id1,Integer id2,Integer id3){  //查询热门活动
		String hql = "FROM Activity e WHERE (e.id = ? OR e.id=? OR e.id=?) and e.pass =1 and e.event_state=0";
		return getSession().createQuery(hql).setInteger(0,id1).setInteger(1,id2).setInteger(2,id3).setCacheable(true).list();
	}

	public List<Activity> getAlltocheck(Integer pass){  //待审核活动
		String hql = "FROM Activity e WHERE e.pass =? and e.event_state=0";
		return getSession().createQuery(hql).setInteger(0,pass).setCacheable(true).list();
	}
	
	public List<Activity> getfabuactivitybyusername(String username){  //获取某用户发布的大活动
		String hql = "FROM Activity e WHERE e.username =? and e.pass=1 order by e.id desc";
		return getSession().createQuery(hql).setString(0,username).setCacheable(true).list();
	}

	public List<Activity> getActivitysById(String xx,Integer id,String city){
		System.out.println("Activity    XX:"+xx+"id:"+id+"city:"+city);
		Query query;
		String hql = "FROM Activity e WHERE  e.city =? and e.pass =? and e.event_state=0 order by e.id desc";
		String hql2 = "FROM Activity e WHERE e.id < ? and e.city =? and e.pass =? and e.event_state=0 order by e.id desc";
		if(xx.equals("jiazai")){
		//	System.out.println("jiazai");
			query = getSession().createQuery(hql).setString(0, city).setInteger(1, 1).setMaxResults(4).setCacheable(true);
		}
		else if(xx.equals("shuaxin")){
		//	System.out.println("shuaxin");
			query = getSession().createQuery(hql2).setInteger(0, id).setString(1, city).setInteger(2, 1).setMaxResults(3).setCacheable(true);
		}
		else{
		//	System.out.println("else");
			return null;
		}
		return query.list();
		//return getSession().createQuery(hql).list();
	}

	public Activity get(Integer id){
		String hql = "from Activity a  where a.id=?";
		Query query= getSession().createQuery(hql).setInteger(0,id).setCacheable(true);
		Activity activity = (Activity) query.uniqueResult();
		return activity;
	}

	public int notpassactivity(Integer pass,Integer id){  //更改审核情况
		String hql = "update Activity a set a.pass=? where a.id=?";
		int i=getSession().createQuery(hql).setInteger(0, pass).setInteger(1, id).executeUpdate();
		return i;
	}
	
	public int changeactivitystate(Integer state,Integer id){  //修改活动状态（已完成，已删除）
		String hql = "update Activity a set a.event_state=? where a.id=?";
		int i=getSession().createQuery(hql).setInteger(0, state).setInteger(1, id).executeUpdate();
		return i;
	}
	
/*	public int passactivity(String miyao,Integer id){  //更改审核情况
		String hql = "update Activity a set a.pass=1 where a.id=?";
		int i=getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		return i;
	}*/

	public Activity gatActivityByUsernameAndId(String username,Integer id)  {    //通过活动id和发布人姓名获取活动
		 String hql = "from Activity a where a.username=? and a.id= ? and a.pass=1 and a.event_state=0";  
		Query query= getSession().createQuery(hql).setString(0,username).setInteger(1,id).setCacheable(true);
		Activity activity = (Activity) query.uniqueResult();
		return activity;
	}

}
