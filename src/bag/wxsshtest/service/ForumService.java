package bag.wxsshtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.ForumDao;
import bag.wxsshtest.entities.Forum;
@Component
public class ForumService {
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private ClassToJson classtojson;
	String[] EXCLUDES = new String[]{""};
	public void saveForum(Forum forum){   //发布论坛
		forumDao.saveOrUpdate(forum);
	}

	public String getAllForumsById(String xx,Integer id){
		List<Forum> forums=new ArrayList<Forum>();	
		forums=forumDao.getForumsById(xx, id);
		String str=classtojson.tojson(forums,EXCLUDES);
		System.out.println("json数组"+str);
		return str;
	}

}
