package com.recruit.impl;

public class RecruitDTO {
	private String recruitId; // 채용ID
	private String company; // 회사명
	private String field; // 채용분야
	private String people; // 채용인원
	private String salary; // 연봉
	private String deadline; // 기한
	
	public RecruitDTO() {
		super();
	}
	
	public RecruitDTO(String recruitId, String company, String field, String people, String salary, String deadline) {
		super();
		this.recruitId = recruitId;
		this.company = company;
		this.field = field;
		this.people = people;
		this.salary = salary;
		this.deadline = deadline;
	}
	
	public String getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

}
