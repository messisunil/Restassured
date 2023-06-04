package com.POJOclass;

public class SpouseObject {

	String spouseName;
	long[] phoneNo;
	
	public SpouseObject(String spouseName ,long[] phoneNo)
	{
		this.spouseName = spouseName;
		this.phoneNo = phoneNo;
	}
	
	public SpouseObject() {
		
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public long[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long[] phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
