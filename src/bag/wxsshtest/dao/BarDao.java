package bag.wxsshtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.entities.Bar;
@Component
public class BarDao extends BaseDao {

	public String saveOrUpdate(Bar bar)
	{
		getSession().saveOrUpdate(bar);
		return "10001";
	}
	
	public Bar get(Integer id){
		String hql = "from Bar a  where a.id=?";
		Query query= getSession().createQuery(hql).setInteger(0,id).setCacheable(true);
		Bar bar = (Bar) query.uniqueResult();
		return bar;
	}
	
	public List<Bar> getbarsbyusername(String username){  //获取某用户发布的广告商活动
		String hql = "FROM Bar e WHERE e.username=?";
		return getSession().createQuery(hql).setString(0,username).setCacheable(true).list();
	}
	
	public int changebarstate(String state,Integer id){  //修改广告商活动状态（已完成，已删除）
		String hql = "update Bar a set a.event_state=? where a.id=?";
		int i=getSession().createQuery(hql).setString(0, state).setInteger(1, id).executeUpdate();
		return i;
	}

	public List<Bar> getBarsById(String xx,Integer id,String city){  //根据活动id返回对象链表
		System.out.println("Bar    XX:"+xx+"id:"+id+"city:"+city);
		Query query;
		String hql = "FROM Bar e WHERE  e.city =? and e.event_state=0 order by e.id desc";
		String hql2 = "FROM Bar e WHERE e.id < ? and e.city =? and e.event_state=0 order by e.id desc";
		if(xx.equals("jiazai")){
			//System.out.println("jiazai");
			query = getSession().createQuery(hql).setString(0, city).setMaxResults(4).setCacheable(true);
		}
		else if(xx.equals("shuaxin")){
			//System.out.println("shuaxin");
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
