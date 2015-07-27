package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.RouteStationsModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.RouteStationsTransformer;

/**
 * RouteStationsModelDAO - Data Access Model for route stations.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class RouteStationsModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_LIST_OF_STATIONS = "INSERT INTO route_stations (route_id, station_1,station_2, station_3, station_4, station_5, station_6, station_7, station_8, station_9, station_10) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_GET_ALL_STATION_LISTS = "SELECT * FROM route_stations";
	private static final String SQL_GET_STATION_LIST_BY_ROUTE_NUMBER = "SELECT * FROM route_stations WHERE route_id=?";

	public static void insert(RouteStationsModel routeStations) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_LIST_OF_STATIONS);
		pstmt.setInt(1, routeStations.getRouteId());

		routeStations.init();
		for (int i = 0; i < routeStations.getStations().size(); i++) {
			pstmt.setString(i + 2, routeStations.getStations().get(i));
		}

		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<RouteStationsModel> getAllStationLists() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<RouteStationsModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_ALL_STATION_LISTS);
			ResultSet rs = stmt.executeQuery();
			results = RouteStationsTransformer.fromRSToTableAllRouteStationLists(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static RouteStationsModel getStationListByRouteId(Integer routeId)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		RouteStationsModel result = null;

		PreparedStatement stmt = conn.prepareStatement(SQL_GET_STATION_LIST_BY_ROUTE_NUMBER);
		stmt.setInt(1, routeId);

		ResultSet rs = stmt.executeQuery();
		result = RouteStationsTransformer.fromRSToTableStationListByRouteId(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}
}
