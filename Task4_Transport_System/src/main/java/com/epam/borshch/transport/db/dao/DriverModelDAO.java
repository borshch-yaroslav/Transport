package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.DriverModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.DriverTransformer;

/**
 * DriverModelDAO - Data Access Model for drivers.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class DriverModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_DRIVER = "INSERT INTO driver (name,age,experience_level,telephone_number, transport_mastery, transport_id, salary) VALUES(?,?,?,?,?,?,?)";
	private static final String SQL_GET_DRIVERS = "SELECT * FROM driver";
	private static final String SQL_GET_DRIVER_BY_ID = "SELECT * FROM driver WHERE id=?";
	private static final String SQL_GET_DRIVER_BY_TRANSPORT_ID = "SELECT * FROM driver WHERE transport_id=?";
	private static final String SQL_GET_ALL_DRIVERS_OF_TRANSPORT = "SELECT * FROM driver WHERE transport_type=?";
	private static final String SQL_GET_ALL_FREE_DRIVERS_OF_TRANSPORT = "SELECT * FROM driver WHERE transport_mastery=? AND transport_id=0";
	private static final String SQL_MODIFY_TRANSPORT_ID = "UPDATE driver SET transport_id=? WHERE id=?";
	private static final String SQL_REMOVE_DRIVER_BY_ID = "DELETE FROM driver WHERE id=?";

	public static void insert(DriverModel driver) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_DRIVER);
		pstmt.setString(1, driver.getName());
		pstmt.setInt(2, driver.getAge());
		pstmt.setInt(3, driver.getExperienceLevel());
		pstmt.setString(4, driver.getTelephoneNumber());
		pstmt.setString(5, driver.getTransportMastery());
		pstmt.setInt(6, driver.getTransportId());
		pstmt.setInt(7, driver.getSalary());
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void removeDriverById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_REMOVE_DRIVER_BY_ID);
		pstmt.setInt(1, id);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyTransportId(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_TRANSPORT_ID);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<DriverModel> getAllDrivers() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<DriverModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_DRIVERS);
			ResultSet rs = stmt.executeQuery();
			results = DriverTransformer.fromRSToTableAllDrivers(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static List<DriverModel> getAllDriversOfTransport(String transportType)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();
		List<DriverModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_ALL_DRIVERS_OF_TRANSPORT);
			stmt.setString(1, transportType);

			ResultSet rs = stmt.executeQuery();
			results = DriverTransformer.fromRSToTableAllDrivers(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static List<DriverModel> getAllFreeDriversOfTransport(String transportType)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<DriverModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_ALL_FREE_DRIVERS_OF_TRANSPORT);
			stmt.setString(1, transportType);

			ResultSet rs = stmt.executeQuery();
			results = DriverTransformer.fromRSToTableAllDrivers(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static DriverModel getDriverById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		DriverModel result = null;
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(SQL_GET_DRIVER_BY_ID);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		result = DriverTransformer.fromRSToTableDriverById(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}

	public static DriverModel getDriverByTransportId(Integer transportId) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		DriverModel result = null;
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(SQL_GET_DRIVER_BY_TRANSPORT_ID);
		stmt.setInt(1, transportId);

		ResultSet rs = stmt.executeQuery();
		result = DriverTransformer.fromRSToTableDriverByTransportId(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}
}
