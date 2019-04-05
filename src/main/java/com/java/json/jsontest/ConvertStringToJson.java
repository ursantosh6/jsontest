package com.java.json.jsontest;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertStringToJson {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		boolean sizeChanged = false;

		ArrayList<Long> fareIds = new ArrayList<Long>();
	
        fareIds.add(1L);
		try {
			JSONObject json = (JSONObject) parser.parse("{\"countryCode\":\"\",\"priceBy\":\"\",\"currencyCode\":\"\",\"fares\":[{\"fareId\":1,\"totalPrice\":{\"amount\":0},\"totalTaxAndFees\":{\"amount\":0},\"basePrice\":{\"amount\":0}},{\"fareId\":2,\"totalPrice\":{\"amount\":0},\"totalTaxAndFees\":{\"amount\":0},\"basePrice\":{\"amount\":0}},{\"fareId\":3,\"totalPrice\":{\"amount\":0},\"totalTaxAndFees\":{\"amount\":0},\"basePrice\":{\"amount\":0}}]}");
			
			System.out.println(json);
			
			System.out.println(json.containsKey("fares"));
			
			List<Integer> idsToBeRemoved = new ArrayList<Integer>();
			
			if(json.containsKey("fares")) {
				
				JSONArray fareArray = (JSONArray) json.get("fares");
				for(Object o : fareArray) {
					boolean contains = false;
					JSONObject temp = (JSONObject) parser.parse(o.toString());
					if(temp.containsKey("fareId")) {
						System.out.println(temp.get("fareId").getClass());
						if(!fareIds.contains(temp.get("fareId"))) {
							idsToBeRemoved.add(fareArray.indexOf(temp));
							
						}
						System.out.println(contains);
					}
				}
				System.out.println(idsToBeRemoved);
				int count = 1;
				for(int ids : idsToBeRemoved) {
					 if(sizeChanged) {
						 ids=ids-count;
						 count++;
					 }
					fareArray.remove(ids);
					sizeChanged = true;
					
				}
				System.out.println(json.toJSONString());
			}
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
