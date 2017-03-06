package alibaba.spyder.cwb.dhu.edu.cn;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Utils {

	static  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	
	/**
	 * �����ҵ������Ϣ(���ü���)
	 * 
	 * @param info
	 *            ������Ϣ
	 */
	static void appandInfo(String info){
		 try {
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
           FileWriter writer = new FileWriter("./information.dat", true);
            writer.write(df.format(new Date())+ "	"+info +"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	static void appandLog(String log){
		 try {
             //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer = new FileWriter("./log.dat", true);
             writer.write(df.format(new Date())+ "	"+log +"\n");// new Date()Ϊ��ȡ��ǰϵͳʱ��
             writer.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
	}
	
	static void appandErrorLog(String log){
		 try {
          FileWriter writer = new FileWriter("./errorlog.dat", true);
          writer.write(Utils.df.format(new Date())+ "	"+log +"\n");// new Date()Ϊ��ȡ��ǰϵͳʱ��
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
	}
	
	/**
	 * ��ȡָ��HTML��ǩ��ָ�����Ե�ֵ
	 * 
	 * @param source
	 *            Ҫƥ���Դ�ı�
	 * @param element
	 *            ��ǩ����
	 * @param attr
	 *            ��ǩ����������
	 * @return ����ֵ�б�
	 */
	public static List<String> match(String source, String element, String attr) {
		List<String> result = new ArrayList<String>();
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?\\s.*?>";
		Matcher m = Pattern.compile(reg).matcher(source);
		while (m.find()) {
			String r = m.group(1);
			result.add(r);
		}
		return result;
	}
	
	 /**
	  * ������������ת��Ϊ���ڸ�ʽ���ַ���
	  * 
	  * @param time
	  * @param format
	  * @return
	  */
	 public static String convert2String(long time, String format) {
	  if (time > 0l) {
	   if (StringUtils.isBlank(format))
	    format = TIME_FORMAT;

	   SimpleDateFormat sf = new SimpleDateFormat(format);
	   Date date = new Date(time);

	   return sf.format(date);
	  }
	  return "";
	 }
	 
	 		// �����ڸ�ʽ
			 public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
		
		 /**
		  * �����ڸ�ʽ���ַ���ת��Ϊ������
		  * 
		  * @param date
		  * @param format
		  * @return
		  */
		 public static long convert2long(String date, String format) {
		  try {
		   if (StringUtils.isNotBlank(date)) {
		    if (StringUtils.isBlank(format))
		     format = TIME_FORMAT;

		    SimpleDateFormat sf = new SimpleDateFormat(format);
		    return sf.parse(date).getTime();
		   }
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }
		  return 0l;
		 }

		 public static void setCharacterType(URLConnection conn, String type){
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("Accept-Charset", type);
			conn.setRequestProperty("contentType", type);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset="+type);
			conn.setRequestProperty("Accept-Language", Locale.getDefault().toString());
		 }

}
