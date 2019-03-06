package org.lunwen.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.lunwen.com.UpLoadQuestion.UpLoadQuestionEnum;

public class TestCase {
	public static void main(String[] args){
		ChoiceQuestion cq = new ChoiceQuestion();
		cq.readForChiCangYuE();
		ChoiceQuestion.dataForUpLoadQuestionFromExcel.get(0);
		int sizeOfData = ChoiceQuestion.dataForUpLoadQuestionFromExcel.size();
		for(int j = 0; j < sizeOfData; j++){
			HashMap<UpLoadQuestionEnum, String> hashMap = ChoiceQuestion.dataForUpLoadQuestionFromExcel.get(j);
			Set<UpLoadQuestionEnum> keySet = hashMap.keySet();
			Iterator<UpLoadQuestionEnum> iterator = keySet.iterator();
			while(iterator.hasNext()){
				//从Excel中取出数据
				UpLoadQuestionEnum UpLoadQuestionEnum = iterator.next();
				String dataFromExcel = hashMap.get(UpLoadQuestionEnum);
				//若Excel中取出的数值为空,说明该项不存在或不需要比较
				if(dataFromExcel.equals("")||dataFromExcel==null){
					continue;
				}
				System.out.println(dataFromExcel);
			}
		}
	}
}
