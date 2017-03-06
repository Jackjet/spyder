package alibaba.spyder.cwb.dhu.edu.cn;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class BatchExecute {

	final static int machineNum = 100; //ͬʱִ������������������
	final static int taskNum = 1;	   //����ÿ̨��������������
	public static void main(String[] args) {
		try{
			Workbook workbook = UtilsExcel.getWeebWork(Step0InputInterface.urlSourceFilePath);
//				System.out.println("�ܱ�ҳ��Ϊ��" + workbook.getNumberOfSheets());// ��ȡ��ҳ��
			Sheet sheet = workbook.getSheetAt(0);// Sheet sheet = workbook.getSheetAt(1);
			int rownum = sheet.getLastRowNum();// ��ȡ������
//			for(int round=1; round<=((rownum/(machineNum*taskNum))+1);round++){
//				
//			}
			
			//Method 1
//			for(int k=0;k<machineNum;k++){
//				Machine machine = new Machine(k*taskNum,(k+1)*taskNum,sheet);
//				machine.start();  
//			}
			
			//Method 2
			/**
			 * �����ǰ��Ҫִ�е����񳬹��ش�С����ô����������ڵȴ�״̬��ֱ���п����������߳�ִ�����������ǰ��Ҫִ�е�����С�ڳش�С�����е��߳�Ҳ����ȥ���١�
			 * */
			ExecutorService executorService2 = Executors.newFixedThreadPool(machineNum);  
			for(int t=0;t<rownum;t++){
				Machine machine = new Machine(t*taskNum,(t+1)*taskNum,sheet);
				executorService2.execute(machine);
			}
			
		}catch(IOException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally{
			System.out.println("over");
		}
	}
}
