package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.StudentComplexObject;

public class StdSerialization {

	@Test
	public void stdDetails() {
		
		long mobileNo[] = {1234567890l,2345678901l};
		StudentComplexObject stdobj = new StudentComplexObject("sun","BE",1001,mobileNo);
		
		ObjectMapper obj = new ObjectMapper();
		try {
			obj.writeValue(new File(".\\json\\std.json"), stdobj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
