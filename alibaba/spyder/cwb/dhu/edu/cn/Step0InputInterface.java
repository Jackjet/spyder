package alibaba.spyder.cwb.dhu.edu.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ���ı�
 * @version V1.0
 * @Date 2016��10��
 * 
 */
public class Step0InputInterface {
	
	/**
	 * ֵ������ϸ�µĵط��� GetItemDetails�л�ø������Ʒ��Ϣ
	 * 				GetRateList	       �л�ø����������Ϣ
	 * 				Json��ȡ�������       ��ȡ������������
	 * */
		/**
		 *  "UTF-8";
		 * */
		static String charsetType="GBK";//��èƽ̨���ı��뷽ʽ��GBK
	
		static Map<String, String> fileURLMap = new HashMap<String, String>();
		static {// TODO http:::
			fileURLMap.put("HSTYLS_Ʒ��Ůװ_����ȹ2.xlsx",
					"https://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.18.SgK37v&cat=50025145&brand=8598007&s=http:::&q=%BA%AB%B6%BC%D2%C2%C9%E1&sort=s&style=g&from=sn_1_cat-qp&industryCatId=50025135#J_crumbs");
			fileURLMap.put("HSTYLS_Ʒ��Ůװ_ë��.xlsx",
					"https://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.9.jaZjSC&cat=50025784&brand=8598007&s=http:::&q=%BA%AB%B6%BC%D2%C2%C9%E1&sort=s&style=g&from=sn_1_cat-qp&industryCatId=50025135#J_crumbs");
			fileURLMap.put("HSTYLS_HSTYLS_Ʒ��Ůװ_��֯��.xlsx",
					"https://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.5.bI2tIL&cat=50025783&brand=8598007&s=http:::&q=%BA%AB%B6%BC%D2%C2%C9%E1&sort=s&style=g&from=sn_1_cat-qp&industryCatId=50025135#J_crumbs");
			fileURLMap.put("HSTYLS_Ʒ��Ůװ_��������.xlsx",
					"https://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.1.iSzfhl&cat=50025788&brand=8598007&s=http:::&q=%BA%AB%B6%BC%D2%C2%C9%E1&sort=s&style=g&from=sn_1_cat-qp&industryCatId=50025135#J_crumbs");
		}
		
		static String urlSourceFilePath = "./data\\HSTYLS_source.xlsx";
		static String OutputFilePathTRUE = "./data\\HSTYLSTest\\"; 
		
		static Boolean afterSearchGetUrls = false; // ͨ������������URL���Ƿ��һ��������ۡ���Step1-Step2
		static Boolean afterStep2 = false; // ͨ������������URL���Ƿ��һ��������ۡ���Step2-Step3
		static Boolean afterStep3 = true; // ͨ������������URL���Ƿ��һ��������ۡ���Step2-Step4
		
}

