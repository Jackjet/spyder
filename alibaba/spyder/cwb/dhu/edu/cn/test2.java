package alibaba.spyder.cwb.dhu.edu.cn;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test2 {

	public test2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {  
//    		StringBuffer buffer = new StringBuffer();
    		
            String url = "https://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.9.dOQCzn&cat=50025135&brand=109718&q=%CC%AB%C6%BD%C4%F1&sort=s&style=g&from=sn_1_cat-qp&suggest=0_1&active=2#J_crumbs";  
            System.out.println("���ʵ�ַ:" + url); 
            get302(url);
           /* //����get����
            URL serverUrl = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();  
            conn.setRequestMethod("GET");  
            //��������false��������Զ�redirect���ض����ĵ�ַ  
            conn.setInstanceFollowRedirects(false);
            conn.addRequestProperty("Accept-Charset", "UTF-8;");  
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
            conn.addRequestProperty("Referer", "http://matols.com/");  
            conn.connect();  
            
            //�ж��Ƿ�����302�ض���
            if (conn.getResponseCode() == 302) { 
                //������ض��򣬱���302�ض����ַ���Լ�Cookies,Ȼ�����·�������(ģ������)
                String location = conn.getHeaderField("Location");  
                String cookies = conn.getHeaderField("Set-Cookie");  
                
	            serverUrl = new URL(location);  
	            conn = (HttpURLConnection) serverUrl.openConnection();  
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Cookie", cookies);
	            conn.addRequestProperty("Accept-Charset", "UTF-8;");  
	            conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
	            conn.addRequestProperty("Referer", "http://matols.com/");  
	            conn.connect();  
	            System.out.println("��ת��ַ:" + location); 
            }*/
            
            //�����ص�������ת�����ַ���  
           /* InputStream inputStream = conn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); 
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // �ͷ���Դ  
            inputStream.close();  
            inputStream = null;  
  
            System.out.println(buffer.toString());*/
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

	}
	
	public static String get302(String url){
		  //����get����
		try {  
		 URL serverUrl = new URL(url);  
         HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();  
         conn.setRequestMethod("GET");  
         //��������false��������Զ�redirect���ض����ĵ�ַ  
         conn.setInstanceFollowRedirects(false);
         conn.addRequestProperty("Accept-Charset", "UTF-8;");  
         conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
         conn.addRequestProperty("Referer", "http://matols.com/");  
         conn.connect();  
         
         //�ж��Ƿ�����302�ض���
         if (conn.getResponseCode() == 302) { 
             //������ض��򣬱���302�ض����ַ���Լ�Cookies,Ȼ�����·�������(ģ������)
             String location = conn.getHeaderField("Location");  
             String cookies = conn.getHeaderField("Set-Cookie");  
             
	            serverUrl = new URL(location);  
	            conn = (HttpURLConnection) serverUrl.openConnection();  
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Cookie", cookies);
	            conn.addRequestProperty("Accept-Charset", "UTF-8;");  
	            conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
	            conn.addRequestProperty("Referer", "http://matols.com/");  
	            conn.connect();  
	            System.out.println("��ת��ַ:" + location); 
        
	            get302(location); 
	            } else if (conn.getResponseCode() == 200) { 
	            	return conn.getHeaderField("Location"); 
	            }
	           
		 } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		return "";
	}

}
