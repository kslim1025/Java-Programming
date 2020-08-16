package com.parsing.jsontojavaob;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	public static void main(String argc[]) {
		String jsonString = "{'age':31, 'name':'choi'}";
		
		Gson gson = new GsonBuilder().create();
		JsonToJavaObject student = gson.fromJson(jsonString, JsonToJavaObject.class);
		
		student.getInfo();
		
	}
}
