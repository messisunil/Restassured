package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.EmpWithSpouseObject;

public class empSpouseComplexDeserial {

	@Test
	public void data() {
		ObjectMapper obj = new ObjectMapper();
		EmpWithSpouseObject empobj = null;
		try {
			empobj = obj.readValue(new File(".\\json\\empcomplex.json"), EmpWithSpouseObject.class);
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
		
		System.out.println(empobj.getEmpName());
		System.out.println(empobj.getEmpphoneNo()[1]);
		System.out.println(empobj.getSpouseobj().getSpouseName());
		System.out.println(empobj.getSpouseobj().getPhoneNo()[0]);
	}
}
