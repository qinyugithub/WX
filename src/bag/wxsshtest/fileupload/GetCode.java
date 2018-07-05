package bag.wxsshtest.fileupload;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.swetake.util.Qrcode;
@Component
public class GetCode {

	public void makcode(String text,String head) throws IOException{
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/codes/" + head+".png");
		System.out.println("路径 "+dir);

		Qrcode x=new Qrcode();
		x.setQrcodeErrorCorrect('M');//纠错等级
		x.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z,B代表其他字符
		x.setQrcodeVersion(7);
		String qrData=text;
		int width=67+12*(7-1);
		int height=67+12*(7-1);

		BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D gs=bufferedImage.createGraphics();

		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		int pixoff=2;//偏移量

		byte[] d=qrData.getBytes("UTF-8");
		if(d.length>0 && d.length<120){
			boolean[][] s=x.calQrcode(d);

			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
					}
				}
			}
		}
		gs.dispose();
		bufferedImage.flush();
		ImageIO.write(bufferedImage, "png", new File(dir));		
	}


	public String getrandom(int length){
		String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<length; ++i){
			int number=(int)(Math.random()*62);	
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
