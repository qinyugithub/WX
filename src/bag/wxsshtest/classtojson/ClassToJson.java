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
		
		//(防止自包含）转换的对象包含自身对象，或者对象A下面挂了对象B，对象B下面又挂了对象A，如果不设置取消环形结构，则那么会抛异常
		JsonConfig cfg = new JsonConfig();
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		cfg.setExcludes(excludes);  
		
		//类型转换
		cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		 JSONArray ja = JSONArray.fromObject(obj,cfg);
		
		 //除去不用的字段
		//String[] EXCLUDES = new String[]{"A","B","C"};
		//cfg.setExcludes(EXCLUDES);  
		return ja.toString();
	}
}
