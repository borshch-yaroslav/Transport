package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.FinanceOperationModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.FinanceOperationTransformer;

/**
 * FinanceOperationModelDAO - Data Access Model for finance operations.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class FinanceOperationModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_FINANCE_OPERATION = "INSERT INTO finance_operation (description, finance_change, date) VALUES(?,?,?)";
	private static final String SQL_GET_FINANCE_OPERATIONS = "SELECT * FROM finance_operation";
	private static final String SQL_GET_FINANCE_OPERATIONS_BY_DATE_INTERVAL = "SELECT * FROM finance_operation WHERE date BETWEEN ? AND ?";

	public static void insert(String description, Integer financeChange, String date)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_FINANCE_OPERATION);
		pstmt.setString(1, description);
		pstmt.setInt(2, financeChange);
		pstmt.setString(3, date);
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<FinanceOperationModel> getAllFinanceOperations() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<FinanceOperationModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_FINANCE_OPERATIONS);
			ResultSet rs = stmt.executeQuery();
			results = FinanceOperationTransformer.fromRSToTableAllFinanceOperations(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static List<FinanceOperationModel> getFinanceOperationByDateInterval(String date1, String date2)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<FinanceOperationModel> result = null;
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(SQL_GET_FINANCE_OPERATIONS_BY_DATE_INTERVAL);
		stmt.setString(1, date1);
		stmt.setString(1, date2);

		ResultSet rs = stmt.executeQuery();
		result = FinanceOperationTransformer.fromRSToTableFinanceOperationsByDateInterval(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}
}
