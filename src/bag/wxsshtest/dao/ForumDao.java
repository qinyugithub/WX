package bag.wxsshtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.entities.Forum;
@Component
public class ForumDao extends BaseDao{
	
	public void saveOrUpdate(Forum forum){
		getSession().saveOrUpdate(forum);
	}
	
	public List<Forum> getForumsById(String xx,Integer id){
		System.out.println("Forum    XX:"+xx+"id:"+id);
		Query query;
		String hql = "FROM Forum f order by f.id desc";
		String hql2 = "FROM Forum f WHERE f.id < ? order by f.id desc";
		if(xx.equals("jiazai")){
			//System.out.println("jiazai");
			query = getSession().createQuery(hql).setMaxResults(4).setCacheable(true);
		}
		else if(xx.equals("shuaxin")){
			//System.out.println("shuaxin");
			query = getSession().createQuery(hql2).setInteger(0, id).setMaxResults(3).setCacheable(true);
		}
		else{
			//System.out.println("else");
			return null;
		}
		return query.list();
		//return getSession().createQuery(hql).list();
	}

}
