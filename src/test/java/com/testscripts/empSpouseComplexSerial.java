package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.EmpWithSpouseObject;
import com.POJOclass.SpouseObject;

public class empSpouseComplexSerial {

	@Test
	public void data() {
		long empph[] = {1234567890l , 2345678901l};
		long spsph[] = {3456789011l , 3322112335l};
		
		SpouseObject spsobj = new SpouseObject("nikki",spsph);
		EmpWithSpouseObject empobj = new EmpWithSpouseObject("moon",empph,spsobj);
		
		ObjectMapper obj= new ObjectMapper();
		try {
			obj.writeValue(new File(".\\json\\empcomplex.json"), empobj);
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
