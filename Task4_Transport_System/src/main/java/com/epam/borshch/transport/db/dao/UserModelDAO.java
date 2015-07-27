package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.UserModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.UserTransformer;

/**
 * UserModelDAO - Data Access Model for users of site.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class UserModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_USER = "INSERT INTO user (login,password,name,email, role, locale) VALUES(?,?,?,?,?,?)";
	private static final String SQL_GET_USERS = "SELECT * FROM user";
	private static final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
	private static final String SQL_GET_USERS_BY_ROLE = "SELECT * FROM user WHERE role=?";
	private static final String SQL_MODIFY_ROLE = "UPDATE user SET role=? WHERE login=?";
	private static final String SQL_MODIFY_LOCALE = "UPDATE user SET locale=? WHERE login=?";
	private static final String SQL_MODIFY_TICKETS_NUMBER = "UPDATE user SET bus_tickets=?+bus_tickets, tram_tickets=?+tram_tickets, trolley_tickets=?+trolley_tickets WHERE login=?";
	
	
	
	public static void insert(String login, String password, String name, String email, String role, String locale)
			throws ClassNotFoundException, SQLException {

		
		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		//conn = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_USER);
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		pstmt.setString(5, role);
		pstmt.setString(6, locale);
		pstmt.executeUpdate();
		
		conn.close();
	//	ConnectionManager.getInstance().close();
	}

	public static void modifyRole(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		
		//conn = ConnectionManager.getInstance().getConnection();
	
		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_ROLE);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();
		
		conn.close();
	//	ConnectionManager.getInstance().close();
	}
	
	public static void modifyLocale(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		
		//conn = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_LOCALE);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();
		
		conn.close();
	//	ConnectionManager.getInstance().close();
	}
	
	public static void modifyNumberOfTickets(String whereValue, Integer busTicketsModifier, Integer tramTicketsModifier,Integer trolleyTicketsModifier)
			throws ClassNotFoundException, SQLException {

		
		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		//conn = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_TICKETS_NUMBER);
		pstmt.setInt(1, busTicketsModifier);
		pstmt.setInt(2, tramTicketsModifier);
		pstmt.setInt(3, trolleyTicketsModifier);
		pstmt.setString(4, whereValue);
		pstmt.execute();
		
		conn.close();
	//	ConnectionManager.getInstance().close();
	}
	
	public static List<UserModel> getAllUsers() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		
		//conn = ConnectionManager.getInstance().getConnection();

		List<UserModel> results = null;
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(SQL_GET_USERS);
			ResultSet rs = stmt.executeQuery();
			results = UserTransformer.fromRSToTableAllUsers(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		//ConnectionManager.getInstance().close();
		return results;
	}

	
	public static List<UserModel> getUsersByRole(String role) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		
		//conn = ConnectionManager.getInstance().getConnection();

		List<UserModel> results = null;
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(SQL_GET_USERS_BY_ROLE);
			stmt.setString(1, role);
			
			ResultSet rs = stmt.executeQuery();
			results = UserTransformer.fromRSToTableUsersByRole(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
	//	ConnectionManager.getInstance().close();
		return results;
	}
	
	public static UserModel getUserByLogin(String login) throws ClassNotFoundException, SQLException {
		
		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		
		//conn = ConnectionManager.getInstance().getConnection();

		UserModel result = null;
		PreparedStatement stmt;

		stmt = conn.prepareStatement(SQL_GET_USER_BY_LOGIN);
		stmt.setString(1, login);

		ResultSet rs = stmt.executeQuery();
		result = UserTransformer.fromRSToTableUserByLogin(rs);

		conn.close();
//		ConnectionManager.getInstance().close();
		return result;
	}
}
