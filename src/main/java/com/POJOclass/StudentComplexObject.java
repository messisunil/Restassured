package com.POJOclass;

public class StudentComplexObject {
	
	String stdName , stdSection;
	int stdId;
	long[] mobileNo;
	
	public StudentComplexObject(String stdName, String stdSection , int stdId , long[] mobileNo)
	{
		this.stdName = stdName;
		this.stdSection = stdSection;
		this.stdId = stdId;
		this.mobileNo = mobileNo;
	}
	
	public StudentComplexObject() {}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdSection() {
		return stdSection;
	}

	public void setStdSection(String stdSection) {
		this.stdSection = stdSection;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public long[] getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long[] mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
