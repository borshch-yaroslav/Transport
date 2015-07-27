package com.epam.borshch.transport.db.model;

public class TransportModel {

	Integer id;
	String type;
	Integer routeNumber;
	Integer capacity;
	Integer year;
	String model;
	Integer upkeep;
	Integer driverId;
	Integer value;

	public TransportModel(){}
	
	public TransportModel(String type, String capacity, String year, String model, String upkeep, String value){
		this.type=type;
		this.capacity = Integer.parseInt(capacity);
		this.year = Integer.parseInt(year);
		this.model=model;
		this.upkeep = Integer.parseInt(upkeep);		
		this.value = Integer.parseInt(value);		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(Integer routeNumber) {
		this.routeNumber = routeNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getUpkeep() {
		return upkeep;
	}

	public void setUpkeep(Integer upkeep) {
		this.upkeep = upkeep;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
