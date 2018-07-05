package bag.wxsshtest.dao;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bag.wxsshtest.entities.Manager;
@Component
@Scope("prototype")
public class ManagerDao extends BaseDao{

	public void saveOrUpdate(Manager manager){
		getSession().saveOrUpdate(manager);
	}

	public Manager selectManagerByNameAndPasswords(String Managername,String password){ //ͨ���˺�������֤��¼
		String hql = "FROM Manager e WHERE (e.email = ? OR e.phone_numb=? OR e.roll_username=?) and e.passwords=?";
		Query query = getSession().createQuery(hql).setString(0, Managername).setString(1, Managername).setString(2, Managername).setString(3, password);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}

	public Manager selectManagerByNameandPhone(String ManagerName,String phone){   //ͨ�������͵绰�������
		String hql = "FROM Manager e WHERE e.roll_username=? or e.phone_numb=?";
		Query query = getSession().createQuery(hql).setString(0, ManagerName).setString(1, phone).setCacheable(true);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}
	
	public Manager checkpersonbydenglutaiandusername(String username,String degnlutai){   //ͨ���û����͵�¼̬��֤�û�
		String hql = "FROM Manager m WHERE m.roll_username=? and m.denglutai=?";
		Query query = getSession().createQuery(hql).setString(0, username).setString(1, degnlutai).setCacheable(true);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}
	

	public void changedenglutai(String username,String denglutai){     //ͨ���û������ĵ�¼̬
		String hql = "update Manager m set m.denglutai=? where m.roll_username=?";
		int i=getSession().createQuery(hql).setString(0, denglutai).setString(1, username).executeUpdate();
		System.out.println("��¼̬�޸ĳɹ� "+i);
	}
	
	public void changedenglutaibyphone(String phone,String denglutai){     //ͨ���ֻ������޸ĵ�¼̬
		String hql = "update Manager m set m.denglutai=? where m.phone_numb=?";
		int i=getSession().createQuery(hql).setString(0, denglutai).setString(1, phone).executeUpdate();
		System.out.println("��¼̬�޸ĳɹ� "+i);
	}

	public int changecode(String code,String phone){  //������֤��	
		String hql = "update Manager m set m.code=?,m.codecreatetime=? where m.phone_numb=?";
		int i=getSession().createQuery(hql).setString(0, code).setTimestamp(1, new Date()).setString(2, phone).executeUpdate();
		System.out.println("shijian"+ new Date());
		return i;
	}

	public Manager selectManagerByPhone(String phone){   //ͨ���绰����
		String hql = "FROM Manager e WHERE e.phone_numb=?";
		Query query = getSession().createQuery(hql).setString(0, phone).setCacheable(true);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}
	
	public Manager selectManagerByUsername(String username){   //ͨ��username����
		String hql = "FROM Manager e WHERE e.roll_username=?";
		Query query = getSession().createQuery(hql).setString(0, username).setCacheable(true);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}
}
