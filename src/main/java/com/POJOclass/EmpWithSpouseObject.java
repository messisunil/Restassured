package com.POJOclass;

public class EmpWithSpouseObject {

	String empName ; 
	long empphoneNo[];
	SpouseObject spouseobj;
	
	public EmpWithSpouseObject(String empName, long[] empphoneNo ,SpouseObject spouseobj )
	{
		this.empName = empName;
		this.empphoneNo = empphoneNo;
		this.spouseobj = spouseobj;
	}
	
	public EmpWithSpouseObject() {
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long[] getEmpphoneNo() {
		return empphoneNo;
	}

	public void setEmpphoneNo(long[] empphoneNo) {
		this.empphoneNo = empphoneNo;
	}

	public SpouseObject getSpouseobj() {
		return spouseobj;
	}

	public void setSpouseobj(SpouseObject spouseobj) {
		this.spouseobj = spouseobj;
	}
	
	
}
