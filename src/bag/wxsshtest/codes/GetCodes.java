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
		

			int appid=1400071138;    //��Ѷ��ƽ̨�϶���ģ�����Լ���Ӧ��
			String appkey ="be748990361958d657dc39737be1a611";  //��Ѷ��ƽ̨�϶���ģ�����Լ���Ӧ��appsecret
			String activetime ="5";//�Լ����ö��ŵ���Ч��
			SmsSingleSender singleSender = new SmsSingleSender(appid,appkey);
			SmsSingleSenderResult singleSenderResult;
			String non_str = String.valueOf((new Random().nextInt(899999) + 100000));
			singleSenderResult = singleSender.send(0, "86", phone, non_str+"Ϊ�����֤�룬����"+activetime+"��������д����Ǳ��˲���������Ա����š�","", "");
			System.out.println(singleSenderResult);  //������Ϣ���
		return non_str;
		
	}
}
