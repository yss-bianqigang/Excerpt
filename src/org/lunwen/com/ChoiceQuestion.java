package org.lunwen.com;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.lunwen.com.UpLoadQuestion.UpLoadQuestionEnum;

import jxl.Sheet;
import jxl.Workbook;

public class ChoiceQuestion {

	public static List<HashMap<UpLoadQuestionEnum, String>> dataForUpLoadQuestionFromExcel = new ArrayList<HashMap<UpLoadQuestionEnum, String>>();
	
	
	public boolean readForChiCangYuE() {
		try {
			dataForUpLoadQuestionFromExcel.clear();
			String[] enumName = AllExaminationElementEnum.UpLoadQuestionElement.valueToString();
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
				for(int i = 0; i < enumName.length; i++ ){
					enumName[i] = sheet.getCell(i+1, r).getContents();
					linkedHashMap.put(UpLoadQuestionEnum.values()[i],enumName[i]);
				}
				dataForUpLoadQuestionFromExcel.add(linkedHashMap);
			}
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}
	
}
