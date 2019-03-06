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
			// 获得执行权限设置工作表对象
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
			// 获取sheet的所有行数
			int rows = sheet.getRows();
			
			for (int r = 2; r < rows; r++) {
				LinkedHashMap<UpLoadQuestionEnum, String> linkedHashMap = new LinkedHashMap<UpLoadQuestionEnum, String>();
				//获取Excel中的序号
	             String order = sheet.getCell(0, r).getContents();
	             //防止表格中存在空格导致报错
	             if (order==null||order.equals("")) {
	            	 break;
	             }
				// 取出第一行数据的所有数据
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
