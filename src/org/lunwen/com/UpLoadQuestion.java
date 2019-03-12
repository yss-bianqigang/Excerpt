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
		 * 试题编号	
		 */
		QUESTIONID,
		/**	
		 * 试题	
		 */
		QUESTION,
		/**	
		 * 选项A	
		 */
		OPTIONA,
		/**	
		 * 选项B	
		 */
		OPTIONB,
		/**	
		 * 选项C
		 */
		OPTIONC,
		/**	
		 * 选项D		
		 */
		OPTIOND,
		/**	
		 * 选项E	
		 */
		OPTIONE,
		/**	
		 * 选项F
		 */
		OPTIONF,
		/**	
		 * 答案
		 */
		ANSWER,
		/**	
		 * 备注
		 */
		REMARK
	}
}
