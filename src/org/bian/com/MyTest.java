package org.bian.com;

public class MyTest {
	public static int avg(int num1,int num2) throws MyException{
		if(num1>1||num2>1){
			throw new MyException ("num 大于1");
		}
		if(num1<100||num2<100){
			throw new MyException("num 小于100");
		}
		return (num1+num2)/2;
	}
	public static void main(String[] args){
		try {
			int result = avg(5,3);
		} catch (MyException e) {
//			System.out.println(e);
//			System.out.println("----------------");
//			e.printStackTrace();
//			System.out.println("=========");
//			e.getMessage();
//			System.out.println("+++++++++++++");
//			e.toString();
		}
	}
}
