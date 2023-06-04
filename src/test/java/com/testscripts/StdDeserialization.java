package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.StudentComplexObject;

public class StdDeserialization {

	@Test
	public void stdDetails() {
		ObjectMapper obj = new ObjectMapper();
		StudentComplexObject std =null;
		try {
			std =obj.readValue(new File(".\\json\\std.json"), StudentComplexObject.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("STD NAME : "+std.getStdName()+"\nSTD ID : "+std.getStdId()+"\nSTD CLASS : "+std.getStdSection()+"\nMOBILENO : "+std.getMobileNo()[0]);
	}
	
}

