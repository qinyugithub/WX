package bag.wxsshtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Advertise;
import bag.wxsshtest.entities.Bar;
@Component
public class AdvertiseDao  extends BaseDao {

	public void saveOrUpdate(Advertise advertise){
		getSession().saveOrUpdate(advertise);
	}
	
	public Advertise get(Integer id){
		String hql = "from Advertise a  where a.id=?";
		Query query= getSession().createQuery(hql).setInteger(0,id).setCacheable(true);
		Advertise advertise = (Advertise) query.uniqueResult();
		return advertise;
	}
	
	public List<Advertise> getadvertisesbyusername(String username){  //获取某用户发布的广告商活动
		String hql = "FROM Advertise e WHERE e.username=?";
		return getSession().createQuery(hql).setString(0,username).setCacheable(true).list();
	}
	
	public int changeadvertisestate(String state,Integer id){  //修改广告商活动状态（已完成，已删除）
		String hql = "update Advertise a set a.event_state=? where a.id=?";
		int i=getSession().createQuery(hql).setString(0, state).setInteger(1, id).executeUpdate();
		return i;
	}
	
	public List<Advertise> getAdvertisesById(String xx,Integer id,String city){
		 System.out.println("Advertise    XX:"+xx+"id:"+id+"city:"+city);
		Query query;
		String hql = "FROM Advertise e WHERE e.city =? and e.event_state=0 order by e.id desc";
		String hql2 = "FROM Advertise e WHERE e.id < ? and e.city =? and e.event_state=0 order by e.id desc";
		if(xx.equals("jiazai")){
			// System.out.println("jiazai");
			query = getSession().createQuery(hql).setString(0, city).setMaxResults(4).setCacheable(true);
		}
		else if(xx.equals("shuaxin")){
			// System.out.println("shuaxin");
			query = getSession().createQuery(hql2).setInteger(0, id).setString(1, city).setMaxResults(3).setCacheable(true);
		}
		else{
			//System.out.println("else");
			return null;
		}

		return query.list();
		//return getSession().createQuery(hql).list();
	}
}
