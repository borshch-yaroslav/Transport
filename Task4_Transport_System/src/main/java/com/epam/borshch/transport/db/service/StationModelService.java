package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.StationModelDAO;
import com.epam.borshch.transport.db.model.StationModel;

/**
 * StationModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class StationModelService {

	public static List<StationModel> getAllStations() {
		try {
			return StationModelDAO.getAllStations();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int StationModelService in getStations()");
			return null;
		}
	}

	public static StationModel getStationBystationName(String name) {
		try {
			return StationModelDAO.getStationByStationName(name);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception in getStationByStationName in service");
			return null;
		}
	}
	
	public static String getStationNameByGeographicName(String geographicName){
		try {
			return StationModelDAO.getStationNameByGeographicName(geographicName);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception in getStationByStationName in service");
			return null;
		}
	}

	public static void insert(String stationName, Double latitude, Double longtitude, String geographicName) {
		try {
			StationModelDAO.insert(stationName, latitude, longtitude, geographicName);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int StationModelService in insert.");
		}
	}

	public static void modifyNumberOfRoutes(String whereValue, Integer newValue) {
		try {
			StationModelDAO.modifyNumberOfRoutes(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int UserModelService in insert.");
		}
	}
}
