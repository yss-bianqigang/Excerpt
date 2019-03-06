package org.bian.com;

public class MethodList {
	public String name;
	public String sex;
	public int age;
	public MethodList(){
		
	}
	public MethodList(String name){
		this.name = name;
	}
	public MethodList(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		System.out.println(name + sex + age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public String method6(RandomTest re){
		
		return "方法六";
	}
}
