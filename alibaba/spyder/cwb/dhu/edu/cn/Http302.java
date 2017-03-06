package alibaba.spyder.cwb.dhu.edu.cn;


import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ���ͨ��HttpURLConnection�õ�http 302����ת��ַ
 * 
 * @author javaniu
 * 
 */
public class Http302 {

	public static void main(String[] args) {
		try {
			String url = "http://www.javaniu.com/302.htm";
			System.out.println("���ʵ�ַ:" + url);
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl
					.openConnection();
			conn.setRequestMethod("GET");
			// ��������false��������Զ�redirect��Location�ĵ�ַ
			conn.setInstanceFollowRedirects(false);

			conn.addRequestProperty("Accept-Charset", "UTF-8;");
			conn.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
			conn.addRequestProperty("Referer", "http://javaniu.com/");
			conn.connect();
			String location = conn.getHeaderField("Location");

			serverUrl = new URL(location);
			conn = (HttpURLConnection) serverUrl.openConnection();
			conn.setRequestMethod("GET");

			conn.addRequestProperty("Accept-Charset", "UTF-8;");
			conn.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
			conn.addRequestProperty("Referer", "http://javaniu.com/");
			conn.connect();
			System.out.println("��ת��ַ:" + location);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

