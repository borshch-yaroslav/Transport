package com.epam.borshch.transport.db.model;

public class StationModel {

	private String name;
	private Integer numberOfRoutes;
	private Double latitude;
	private Double longtitude;
	private String geographicName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public void setNumberOfRoutes(Integer numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public String getGeographicName() {
		return geographicName;
	}

	public void setGeographicName(String geographicName) {
		this.geographicName = geographicName;
	}
}
