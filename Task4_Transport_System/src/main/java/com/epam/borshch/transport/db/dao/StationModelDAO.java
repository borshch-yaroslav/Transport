package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.epam.borshch.transport.db.model.StationModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.service.StationModelService;
import com.epam.borshch.transport.db.transformer.StationTransformer;

/**
 * StationModelDAO - Data Access Model for stations.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class StationModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_STATION = "INSERT INTO station (station_name,latitude, longtitude, geographic_name) VALUES(?,?,?,?)";
	private static final String SQL_GET_STATIONS = "SELECT * FROM station";
	private static final String SQL_GET_STATION_BY_NAME = "SELECT * FROM station WHERE station_name=?";
	private static final String SQL_GET_STATION_NAME_BY_GEOGRAPHIC_NAME = "SELECT * FROM station WHERE geographic_name=?";
	private static final String SQL_MODIFY_NUMBER_OF_ROUTES = "UPDATE station SET number_of_routes=?+number_of_routes WHERE station_name=?";

	public static void insert(String stationName, Double latitude, Double longtitude, String geographicName)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_STATION);
		
		if(StationModelService.getStationBystationName(stationName).getName()!=null){
			if(StationModelService.getStationBystationName(stationName).getLatitude() != latitude && StationModelService.getStationBystationName(stationName).getLongtitude() != longtitude){
				stationName+=""+ new Random().nextInt(50);
			}
			else{
				return;
			}
		}
		
		pstmt.setString(1, stationName);
		pstmt.setDouble(2, latitude);
		pstmt.setDouble(3, longtitude);
		pstmt.setString(4, geographicName);
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyNumberOfRoutes(String whereValue, Integer newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_NUMBER_OF_ROUTES);
		pstmt.setInt(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<StationModel> getAllStations() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<StationModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_STATIONS);
			ResultSet rs = stmt.executeQuery();
			results = StationTransformer.fromRSToTableAllStations(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();

		return results;
	}

	public static StationModel getStationByStationName(String stationName) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		StationModel result = null;

		PreparedStatement stmt = conn.prepareStatement(SQL_GET_STATION_BY_NAME);
		stmt.setString(1, stationName);

		ResultSet rs = stmt.executeQuery();
		result = StationTransformer.fromRSToTableStationByName(rs);

		conn.close();
		// ConnectionManager.getInstance().close();

		return result;
	}

	public static String getStationNameByGeographicName(String geographicName)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		StationModel middleResult = null;

		PreparedStatement stmt = conn.prepareStatement(SQL_GET_STATION_NAME_BY_GEOGRAPHIC_NAME);
		stmt.setString(1, geographicName);

		ResultSet rs = stmt.executeQuery();
		middleResult = StationTransformer.fromRSToTableStationNameByGeographicName(rs);

		conn.close();
		// ConnectionManager.getInstance().close();

		return middleResult.getName();
	}
}
