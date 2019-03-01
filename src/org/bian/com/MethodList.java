package org.bian.com;

public class MethodList {
	String name;
	String sex;
	int age;
	public MethodList(){
		
	}
	public MethodList(String name){
		this.name = name;
	}
	public MethodList(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String method1(){
		return "方法一";
	}
	public String method2(){
		return "方法二";
	}
	public String method3(){
		return "方法三";
	}
	public String method4(){
		return "方法四";
	}
	public String method5(){
		return "方法五";
	}
	public String method6(){
		return "方法六";
	}
}
