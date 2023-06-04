package com.pojoClassForDDT;

public class RMGYantraDDT {

	String createdBy, projectName, status ;int teamSize;
	
	public RMGYantraDDT(String createdBy, String projectName, String status , int teamSize) {
		this.createdBy = createdBy;this.projectName = projectName;this.status = status ; this.teamSize = teamSize;
	}
	
	public RMGYantraDDT() {}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
}
