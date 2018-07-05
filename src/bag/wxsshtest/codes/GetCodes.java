package bag.wxsshtest.codes;

import java.io.IOException;
import java.util.Random;

import org.json.JSONException;
import org.springframework.stereotype.Component;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
@Component
public class GetCodes {

	public String getcodesbyphone(String phone) throws JSONException, HTTPException, IOException{
		

			int appid=1400071138;    //腾讯云平台上短信模块上自己的应用
			String appkey ="be748990361958d657dc39737be1a611";  //腾讯云平台上短信模块上自己的应用appsecret
			String activetime ="5";//自己设置短信的有效期
			SmsSingleSender singleSender = new SmsSingleSender(appid,appkey);
			SmsSingleSenderResult singleSenderResult;
			String non_str = String.valueOf((new Random().nextInt(899999) + 100000));
			singleSenderResult = singleSender.send(0, "86", phone, non_str+"为你的验证码，请在"+activetime+"分钟内填写。如非本人操作，请忽略本短信。","", "");
			System.out.println(singleSenderResult);  //返回消息结果
		return non_str;
		
	}
}
