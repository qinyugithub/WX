package bag.wxsshtest.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class OpenIdUtil {
	@Autowired
	private HttpUtil httpUtil;
	
    public String oauth2GetOpenid(String code) {
        String appid="wx3dd530275b6aa850";
        String appsecret="972fa777d2cc78cc73b63638f70da5ba";
    
        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = httpUtil.get(requestUrl, params);
        //解析相应内容（转换成json对象）
        JSONObject  json = JSONObject.fromObject(data);
        //用户的唯一标识（openid）
        String Openid =String.valueOf(json.get("openid"));
        System.out.println("***********"+Openid);
        return Openid;
    }
}