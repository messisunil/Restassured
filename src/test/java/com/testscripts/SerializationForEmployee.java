package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJOclass.Employee;

public class SerializationForEmployee {

	 @Test
	 public void employee() {
		 Employee emp = new Employee("sunil",1001,40000,7795319679l);
		 ObjectMapper objm = new ObjectMapper();
		 try {
			objm.writeValue(new File (".\\json\\emp.json"), emp);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
 
}
