package org.qi.com;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.bian.com.MethodList;

public class ReflectTest {
	public static void main(String[] args){
		// 访问成员变量的使用
		MethodList meth2 = new MethodList();
		Class<? extends MethodList> cll = meth2.getClass();
		try {
			Field fie = cll.getDeclaredField("name");
			fie.set(meth2, "小明");
			System.out.println(fie.get(meth2));
		} catch (Exception  e) {
			e.printStackTrace();
		}
		
		// 构造方法的使用
		MethodList meth1 = new MethodList();
		Class<? extends MethodList> cl = meth1.getClass();
		try {
			Constructor test = cl.getDeclaredConstructor(String.class);
			MethodList newT = (MethodList) test.newInstance("小红");
			System.out.println(newT.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		MethodList meth3 = new MethodList();
		Class<? extends MethodList> c = meth3.getClass();
		try {
			Constructor[] declaredConstructor = c.getDeclaredConstructors();
			for(int i = 0;i<declaredConstructor.length;i++){
				Constructor constructor = declaredConstructor[i];
				System.out.println(constructor.getName());
				Class[] paramter = constructor.getParameterTypes();
				for(int j = 0;j<paramter.length;j++){
					System.out.println(paramter[j]+"   "+i+"   "+j);
				}
				if(i==0){
					MethodList mmmmm = (MethodList) constructor.newInstance("小明","男",11);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
