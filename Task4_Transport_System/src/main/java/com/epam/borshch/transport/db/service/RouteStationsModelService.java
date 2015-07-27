package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.RouteStationsModelDAO;
import com.epam.borshch.transport.db.model.RouteStationsModel;

/**
 * RouteStationsModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class RouteStationsModelService {

	public static List<RouteStationsModel> getAllStationLists() {
		try {
			return RouteStationsModelDAO.getAllStationLists();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int RouteStationsModelService in getAllStationLists()");
			return null;
		}
	}

	public static RouteStationsModel getStationListByRouteId(Integer routeId){
		try {
			return RouteStationsModelDAO.getStationListByRouteId(routeId);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception in getRouteStationListByRouteId in service");
			return null;
		}
	}

	public static void insert(RouteStationsModel routeStations) {
		try {
			RouteStationsModelDAO.insert(routeStations);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception int StationModelService in insert.");
		}
	}

}
