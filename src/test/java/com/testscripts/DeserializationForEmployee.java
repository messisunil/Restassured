package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.Employee;

public class DeserializationForEmployee {

	@Test
	public void employee() {
		ObjectMapper objm = new ObjectMapper();
		Employee emp = null;
		try {
			emp = objm.readValue(new File(".\\json\\emp.json"), Employee.class);
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
		
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpId());
		System.out.println(emp.getEmpSalary());
		System.out.println(emp.getMobileNo());
	}
}
