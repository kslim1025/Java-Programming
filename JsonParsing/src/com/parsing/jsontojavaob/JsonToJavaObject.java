package com.parsing.jsontojavaob;

public class JsonToJavaObject {
	private int age;
	private String name;
	
	public void Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	public void getInfo() {
		System.out.println("이름 :" + this.name + "나이: " + this.age +"입니다");
		
	}

}
