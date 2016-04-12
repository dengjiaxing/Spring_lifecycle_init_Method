package com.djx.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleBean {
	private static final String DEFAULT_NAME = "mark";
	private static final int DEFAULT_AGE = 20;
	private int age=0;
	private String name;
	public SimpleBean() {
		System.out.println("---------------\n"+"Spring 实例化bean...");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("Spring执行依赖关系注入...");
		this.age = age;
		System.out.println("age="+this.age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Spring执行依赖关系注入...");
		this.name = name;
		System.out.println("name="+this.name);
	}
	public void init(){
		System.out.println("初始化bean完成，调用init()...");
		this.name=DEFAULT_NAME;
		this.age=DEFAULT_AGE;
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "name:"+name+"\n"+"age:"+age+"\n"+"----------------"+"\n";
	}
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		for (int i = 1; i <=3; i++) {
			ctx.getBean("simpleBean"+i);
		}
	}
}
