package org.lunwen.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.lunwen.com.UpLoadQuestion.UpLoadQuestionEnum;

public class TestCase {
	public static void main(String[] args){
		UpLoadQuestion cq = new UpLoadQuestion();
		cq.readForChiCangYuE();
//		ChoiceQuestion.dataForUpLoadQuestionFromExcel.get(0);
		int sizeOfData = UpLoadQuestion.dataForUpLoadQuestionFromExcel.size();
		for(int j = 0; j < sizeOfData; j++){
			HashMap<UpLoadQuestionEnum, String> hashMap = UpLoadQuestion.dataForUpLoadQuestionFromExcel.get(j);
			Set<UpLoadQuestionEnum> keySet = hashMap.keySet();
			Iterator<UpLoadQuestionEnum> iterator = keySet.iterator();
			while(iterator.hasNext()){
				//��Excel��ȡ������
				UpLoadQuestionEnum UpLoadQuestionEnum = iterator.next();
				String dataFromExcel = hashMap.get(UpLoadQuestionEnum);
				//��Excel��ȡ������ֵΪ��,˵��������ڻ���Ҫ�Ƚ�
				if(dataFromExcel.equals("")||dataFromExcel==null){
					continue;
				}
				System.out.println(dataFromExcel);
			}
		}
	}
}
