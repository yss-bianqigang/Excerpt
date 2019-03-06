package org.lunwen.com;

import org.lunwen.com.UpLoadQuestion.UpLoadQuestionEnum;

/**
 * 所有与试题有关的字段名
 *
 */
public enum AllExaminationElementEnum {
	
	UpLoadQuestionElement(UpLoadQuestionEnum.class);
	
	private ElementEnum[] elementEnums;
	private AllExaminationElementEnum( Class<? extends ElementEnum> e){
		elementEnums=e.getEnumConstants();
	}
	public String[] valueToString(){
		
		String[] str = new String[elementEnums.length];
		
		for(int i = 0;i < str.length; i++){
			str[i] = elementEnums[i].toString();
		}
		return str;
	}
}
