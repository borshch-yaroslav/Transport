package com.epam.borshch.transport.db.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Slavko
 *
 */
public class RouteModel {

	Integer id;
	Integer routeNumber;
	String transportType;
	Integer numberOfCars;
	String intervalTime;
	String startTime;
	String endTime;
	String terminalStation1;
	String terminalStation2;
	Integer profitability;
	
	List<String> stations;
	List<double[]> coordinates;
	int lngth;
	int num;

	public RouteModel(){
		stations = new ArrayList<String>();
		coordinates = new ArrayList<double[]>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(Integer routeNumber) {
		this.routeNumber = routeNumber;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Integer getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(Integer numberOfCars) {
		this.numberOfCars = numberOfCars;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTerminalStation1() {
		return terminalStation1;
	}

	public void setTerminalStation1(String terminalStation1) {
		this.terminalStation1 = terminalStation1;
	}

	public String getTerminalStation2() {
		return terminalStation2;
	}

	public void setTerminalStation2(String terminalStation2) {
		this.terminalStation2 = terminalStation2;
	}

	public Integer getProfitability() {
		return profitability;
	}

	public void setProfitability(Integer profitability) {
		this.profitability = profitability;
	}

	public List<String> getStations() {
		return stations;
	}

	public void addStation(String station) {
		this.stations.add(station);
	}
	
	public void setStations(List<String> stations) {
		this.stations = stations;
	}

	public List<double[]> getCoordinates() {
		return coordinates;
	}

	public void addCoordinate(double[] coordinate) {
		this.coordinates.add(coordinate);
		lngth++;
	}

	public int getLngth() {
		return lngth;
	}

	public void setLngth(int lngth) {
		this.lngth = lngth;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
