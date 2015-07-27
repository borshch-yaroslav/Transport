package com.epam.borshch.transport.db.model;

public class DriverModel {

	private Integer id;
	private String name;
	private Integer age;
	private Integer experienceLevel;
	private String telephoneNumber;
	private String transportMastery;
	private Integer transportId;
	private Integer salary;

	public DriverModel(){}
	
	public DriverModel(String name, String age, String experienceLevel, String telephoneNumber, String transportMastery, String salary){
		this.name=name;
		this.age = Integer.parseInt(age);
		this.experienceLevel = Integer.parseInt(experienceLevel);
		this.telephoneNumber=telephoneNumber;
		this.transportMastery=transportMastery;
		this.salary = Integer.parseInt(salary);		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(Integer experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getTransportMastery() {
		return transportMastery;
	}

	public void setTransportMastery(String transportMastery) {
		this.transportMastery = transportMastery;
	}

	public Integer getTransportId() {
		return transportId;
	}

	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
