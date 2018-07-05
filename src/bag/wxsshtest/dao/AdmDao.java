package bag.wxsshtest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Adm;
@Component
public class AdmDao extends BaseDao{
	
	public Adm checkAdm(String name,String password){
		String hql = "FROM Adm e WHERE e.name = ? and e.password=?";
		Query query = getSession().createQuery(hql).setString(0, name).setString(1, password).setCacheable(true);
		Adm adm = (Adm) query.uniqueResult();
		return adm;
	}

}
