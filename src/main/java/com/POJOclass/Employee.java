package com.POJOclass;

public class Employee {
	//declare global variables
	String empName;
	int empId, empSalary;
	long mobileNo;
	
	//initialize value to global variables
	public Employee(String empName,int empId,int empSalary , long mobileNo ) {
		this.empName = empName;
		this.empId = empId;
		this.empSalary = empSalary;
		this.mobileNo = mobileNo;
	}
	
	//create default constructor for serialization and deserialization
	public Employee() {
		
	}
	
	
	//create setters and getters for global variables
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	
	

}
