package com.epam.borshch.transport.db.model;

import java.util.ArrayList;
import java.util.List;

public class RouteStationsModel {

	Integer PERMISSIBLE_SIZE_OF_ARRAY = 10;
	Integer routeId;
	List<String> stations;

	public RouteStationsModel() {
		stations = new ArrayList<String>();
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}
	
	public void addStation(String station) {
		this.stations.add(station);
	}

	public void init() {
		
		int size = PERMISSIBLE_SIZE_OF_ARRAY - stations.size();
		for (int i = 0; i < size; i++)
			stations.add(" ");
	}
}
