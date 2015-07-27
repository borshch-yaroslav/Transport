package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.RouteTransformer;

/**
 * RouteModelDAO - Data Access Model for routes.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class RouteModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_ROUTE = "INSERT INTO route (route_number,transport_type, number_of_cars, interval_time, start_time, end_time, terminal_station_1, terminal_station_2, profitability) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String SQL_GET_ALL_ROUTES = "SELECT * FROM route";
	private static final String SQL_GET_ROUTE_BY_ID = "SELECT * FROM route WHERE id=?";
	private static final String SQL_GET_ROUTE_BY_TRANSPORT = "SELECT * FROM route WHERE transport_type=?";
	private static final String SQL_MODIFY_NUMBER_OF_CARS = "UPDATE route SET number_of_cars=? WHERE id=?";
	private static final String SQL_MODIFY_TERMINAL_STATION1 = "UPDATE route SET start_station=? WHERE id=?";
	private static final String SQL_MODIFY_TERMINAL_STATION2 = "UPDATE route SET end_station=? WHERE id=?";
	private static final String SQL_REMOVE_ROUTE_BY_ID = "DELETE FROM route WHERE id=?";

	public static void insert(RouteModel route) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_ROUTE);
		pstmt.setInt(1, route.getRouteNumber());
		pstmt.setString(2, route.getTransportType());
		pstmt.setInt(3, route.getNumberOfCars());
		pstmt.setString(4, route.getIntervalTime());
		pstmt.setString(5, route.getStartTime());
		pstmt.setString(6, route.getEndTime());
		pstmt.setString(7, route.getTerminalStation1());
		pstmt.setString(8, route.getTerminalStation2());
		pstmt.setInt(9, route.getProfitability());
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void removeRouteById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_REMOVE_ROUTE_BY_ID);
		pstmt.setInt(1, id);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyNumberOfCars(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_NUMBER_OF_CARS);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyTerminalStation1(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_TERMINAL_STATION1);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyTerminalStation2(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_TERMINAL_STATION2);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<RouteModel> getAllRoutes() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<RouteModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_ALL_ROUTES);
			ResultSet rs = stmt.executeQuery();
			results = RouteTransformer.fromRSToTableAllRoutes(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static RouteModel getRouteById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		RouteModel result = null;
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(SQL_GET_ROUTE_BY_ID);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		result = RouteTransformer.fromRSToTableRouteById(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}

	public static List<RouteModel> getRouteByTransportType(String type) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<RouteModel> result = null;

		PreparedStatement stmt = conn.prepareStatement(SQL_GET_ROUTE_BY_TRANSPORT);
		stmt.setString(1, type);

		ResultSet rs = stmt.executeQuery();
		result = RouteTransformer.fromRSToTableAllRoutes(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}
}
