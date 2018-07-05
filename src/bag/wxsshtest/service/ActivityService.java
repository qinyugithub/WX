package bag.wxsshtest.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bag.wxsshtest.classtojson.ClassToJson;
import bag.wxsshtest.dao.ActivityDao;
import bag.wxsshtest.entities.Activity;
import bag.wxsshtest.fileupload.GetCode;
@Component
public class ActivityService {
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ClassToJson classtojson;
	@Autowired
	private GetCode getCode;
	String[] EXCLUDES = new String[]{""};
	
	public void saveOrUpdate(Activity activity) throws IOException{   //������
		String minpeo=activity.getMinpeo();
		if(minpeo.equals("��Ҫ��")){
			activity.setMinpeo("-1");
		}else{
			String[] sourceStrArray = minpeo.split("��");		
			activity.setMinpeo(sourceStrArray[0]);
		}	
		String miyao=getCode.getrandom(10);     //������Կ
		activity.setCode(miyao);
		activityDao.saveOrUpdate(activity);
			
		getCode.makcode(miyao,activity.getId().toString());   //����Կ������ά�벢�����ļ���
		System.out.println("�ѷ������������ά��");
	
	}

	public String getAllActivitysByActivityId(String xx,Integer id,String city){
		List<Activity> activitys=new ArrayList<Activity>();	
		activitys=activityDao.getActivitysById(xx, id, city);
		EXCLUDES = new String[]{"code","city","pass","username","event_state"};
		String str=classtojson.tojson(activitys,EXCLUDES);
		System.out.println("json����"+str);
		return str;
	}

	public String savehotactivitys(int id1,int id2,int id3){
		List<Activity> activitys=activityDao.getHotActivitys(id1, id2, id3);
		String str=classtojson.tojson(activitys,EXCLUDES);
		String str2="{\"hotactivitys\":"+str+"}";

		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/articleandhotactivity/" + "hotactivitys.json");
		File file = new File(dir);  
		if(!file.exists()){  
			try {  
				file.createNewFile();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		try {  
		//	FileWriter fw = new FileWriter(file);  
			FileOutputStream writerStream = new FileOutputStream(dir);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8")); 
		//	BufferedWriter bw = new BufferedWriter(fw);  
			bw.write(str2);  
			bw.close();  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return dir;
	}

	public List<Activity> getAlltocheck(Integer pass){
		List<Activity> activitys = activityDao.getAlltocheck(pass);
		System.out.println(activitys);
		return activitys;
	}

	public String getfabuactivity(String username){  //��ȡĳ�û������Ĵ�
		List<Activity> activitys = activityDao.getfabuactivitybyusername(username);
		EXCLUDES = new String[]{"username","code","pass"};
		String str=classtojson.tojson(activitys,EXCLUDES);
		System.out.println("�� �� �����Ĵ�"+str);
		return str;
	}

	public String getActivitybyxy(double longitude,double latitude){  //��ȡһ����Χ�ڵ�json���Ϣ
		double[] d=activityDao.selectrangebyxy(longitude, latitude);
		List<Activity> activitys=activityDao.getActivitysbyxy(d);
		EXCLUDES = new String[]{"code","city","pass","username","event_state"};
		String str=classtojson.tojson(activitys,EXCLUDES);
		System.out.println("��������������"+str);
		return str;
	}

	public String changeactivityfinish(Integer id){  //�޸Ļ��״̬�����
		Integer i=activityDao.changeactivitystate(1, id);
		if(i>0){
			return "10001";
		}
		return "10002";
	}
	public String changeactivitydelete(Integer id){  //�޸Ļ��״̬��ɾ��
		Integer i=activityDao.changeactivitystate(-1, id);
		if(i>0){
			return "10001";
		}
		return "10002";
	}


	public void passActivity(Integer id) throws IOException{

		//String miyao=getCode.getrandom(10);     //������Կ
		//getCode.makcode(miyao,id.toString());   //����Կ������ά�벢�����ļ���
		//int i=activityDao.passactivity(miyao, id);  //���Ļ��Ϣ
		
		int i=activityDao.notpassactivity(1, id);
		System.out.println("�Ѹ��� "+i+" ������");
	}


	public void notpassActivity(Integer id){
		int i=activityDao.notpassactivity(-1, id);

		ServletContext servletContext = ServletActionContext.getServletContext();  //ɾ����ά��
		String dir = servletContext.getRealPath("/codes/" + id+".png");
		File file = new File(dir);
		if (file.exists()) {
			file.delete();
		}
		System.out.println("�Ѹ��� "+i+" ������");
	}

	public String getactivitybyusernameandid(String username,Integer id) throws IOException{

		Activity activity=activityDao.gatActivityByUsernameAndId(username, id);
		if(activity!=null){
			Date date1=activity.getTimeinputone(); //���ʼʱ��
			Date date2=new Date();  //��ǰʱ��
			Date date3=new Date(date1.getTime() - 2 * 60 * 60 * 1000);//���ʼǰ����Сʱ
			int i= date2.compareTo(date3);   
			if(i==1){
				return "https://www.qinyu123456.xyz//lindu//codes"+"//"+activity.getId()+".png";
			}else{
				return "10003";//��ǰ��Сʱ��ȡ��ά��
			}
		}
		return "10002";
	}








}
