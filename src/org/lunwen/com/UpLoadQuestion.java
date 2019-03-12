package org.lunwen.com;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class UpLoadQuestion {

	public static List<HashMap<UpLoadQuestionEnum, String>> dataForUpLoadQuestionFromExcel = new ArrayList<HashMap<UpLoadQuestionEnum, String>>();
	SingleChoice sce = new SingleChoice();
	
	public boolean readForChiCangYuE() {
		try {
			dataForUpLoadQuestionFromExcel.clear();
//			String[] enumName = AllExaminationElementEnum.UpLoadQuestionElement.valueToString();
			Class sceClass = SingleChoice.class;
			Field[] fields = sceClass.getDeclaredFields();
			String[] sssss = new String[fields.length];
			int dddd = "private java.lang.String org.lunwen.com.SingleChoice.".length();
			for(int i = 0;i<fields.length;i++){
				sssss[i]=fields[i].toString().substring(dddd);
			}
			Workbook book = Workbook.getWorkbook(new File("./testcase/choicequestion.xls"));
			// ���ִ��Ȩ�����ù��������
			Sheet[] sheets = book.getSheets();
			Sheet sheet = null;
			for (Sheet s : sheets) {
				if ("xuanzeti".equals(s.getName())) {
					sheet = s;
				}
			}
			if (sheet == null) {
				return false;
			}
			// ��ȡsheet����������
			int rows = sheet.getRows();
			
			for (int r = 2; r < rows; r++) {
				LinkedHashMap<UpLoadQuestionEnum, String> linkedHashMap = new LinkedHashMap<UpLoadQuestionEnum, String>();
				//��ȡExcel�е����
	             String order = sheet.getCell(0, r).getContents();
	             //��ֹ����д��ڿո��±���
	             if (order==null||order.equals("")) {
	            	 break;
	             }
				// ȡ����һ�����ݵ���������
				for(int i = 0; i < sssss.length; i++ ){
					System.out.println(sssss[i]);
					sssss[i] = sheet.getCell(i+1, r).getContents();
					System.out.println(sssss[i]);
					linkedHashMap.put(UpLoadQuestionEnum.values()[i],sssss[i]);
				}
				dataForUpLoadQuestionFromExcel.add(linkedHashMap);
			}
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}
	
	
	
	
	public enum UpLoadQuestionEnum implements ElementEnum{
		/**	
		 * ������	
		 */
		QUESTIONID,
		/**	
		 * ����	
		 */
		QUESTION,
		/**	
		 * ѡ��A	
		 */
		OPTIONA,
		/**	
		 * ѡ��B	
		 */
		OPTIONB,
		/**	
		 * ѡ��C
		 */
		OPTIONC,
		/**	
		 * ѡ��D		
		 */
		OPTIOND,
		/**	
		 * ѡ��E	
		 */
		OPTIONE,
		/**	
		 * ѡ��F
		 */
		OPTIONF,
		/**	
		 * ��
		 */
		ANSWER,
		/**	
		 * ��ע
		 */
		REMARK
	}
}
