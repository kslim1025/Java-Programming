package com.parsing.json;

import org.json.JSONException;
import org.json.JSONObject;

public class StringToJson {
	
	public static void main(String argc[]) {
		String jsonString = "{name:choi, sex:'man', 'wang1':{'name':wang, 'sex':'girl'}} ";
		
		try {
			/*
			 * JSONObject jsonOb = new JSONObject(jsonString); 
			 * System.out.println(jsonOb);
			 * System.out.println(jsonOb.getJSONObject("wang1"));
			 */
			
			//put Method를 활용한 JsonObject 생성
			JSONObject jsonob = new JSONObject();
			jsonob.put("name", "choi");
			jsonob.put("age", "31");
			jsonob.put("sex", "man");
			
			System.out.println(jsonob);
			
			
			
		}catch(JSONException e){
			e.printStackTrace();
		}
		
	}

}
