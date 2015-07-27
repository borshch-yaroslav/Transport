package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.TransportModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.TransportTransformer;

/**
 * TransportModelDAO - Data Access Model for transport.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class TransportModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_TRANSPORT = "INSERT INTO transport (type,route_number,capacity,model, year, upkeep, driver_id, value) VALUES(?,?,?,?,?,?,?,?)";
	private static final String SQL_GET_ALL_TRANSPORT = "SELECT * FROM transport";
	private static final String SQL_GET_TRANSPORT_BY_ID = "SELECT * FROM transport WHERE id=?";
	private static final String SQL_MODIFY_ROUTE_NUMBER = "UPDATE transport SET route_number=? WHERE id=?";
	private static final String SQL_MODIFY_DRIVER_ID = "UPDATE transport SET driver_id=? WHERE id=?";
	private static final String SQL_REMOVE_TRANSPORT_BY_ID = "DELETE FROM transport WHERE id=?";

	public static void insert(TransportModel transport) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_TRANSPORT);
		pstmt.setString(1, transport.getType());
		pstmt.setInt(2, transport.getRouteNumber());
		pstmt.setInt(3, transport.getCapacity());
		pstmt.setString(4, transport.getModel());
		pstmt.setInt(5, transport.getYear());
		pstmt.setInt(6, transport.getUpkeep());
		pstmt.setInt(7, transport.getDriverId());
		pstmt.setInt(8, transport.getValue());
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void removeTransportById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_REMOVE_TRANSPORT_BY_ID);
		pstmt.setInt(1, id);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyRouteNumber(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_ROUTE_NUMBER);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();

		// ConnectionManager.getInstance().close();
	}

	public static void modifyDriverId(String whereValue, String newValue) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_DRIVER_ID);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<TransportModel> getAllTransport() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<TransportModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_ALL_TRANSPORT);
			ResultSet rs = stmt.executeQuery();
			results = TransportTransformer.fromRSToTableAllTransport(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();

		return results;
	}

	public static TransportModel getTransportById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		TransportModel result = null;

		PreparedStatement stmt = conn.prepareStatement(SQL_GET_TRANSPORT_BY_ID);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		result = TransportTransformer.fromRSToTableTransportById(rs);

		conn.close();
		// ` ConnectionManager.getInstance().close();

		return result;
	}
}
