package bag.wxsshtest.classtojson;

import java.util.Date;

import org.springframework.stereotype.Component;

import bag.wxsshtest.converters.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
@Component
public class ClassToJson {

	public String tojson(Object obj,String[] excludes){
		
		//(��ֹ�԰�����ת���Ķ������������󣬻��߶���A������˶���B������B�����ֹ��˶���A�����������ȡ�����νṹ������ô�����쳣
		JsonConfig cfg = new JsonConfig();
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		cfg.setExcludes(excludes);  
		
		//����ת��
		cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		 JSONArray ja = JSONArray.fromObject(obj,cfg);
		
		 //��ȥ���õ��ֶ�
		//String[] EXCLUDES = new String[]{"A","B","C"};
		//cfg.setExcludes(EXCLUDES);  
		return ja.toString();
	}
}
