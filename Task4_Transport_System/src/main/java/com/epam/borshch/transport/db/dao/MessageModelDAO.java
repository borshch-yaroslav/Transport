package com.epam.borshch.transport.db.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.model.MessageModel;
import com.epam.borshch.transport.db.persistant.DataSource;
import com.epam.borshch.transport.db.transformer.MessageTransformer;

/**
 * MessageModelDAO - Data Access Model for messages.
 * 
 * + bridge between database and program. Handles SQL prepared statements.
 * 
 * @author Slavko
 *
 */

public class MessageModelDAO {

	private static Connection conn;

	private static final String SQL_ADD_MESSAGE = "INSERT INTO message (sender_login,receiver_login,type,message) VALUES(?,?,?,?)";
	private static final String SQL_GET_MESSAGES = "SELECT * FROM message";
	private static final String SQL_GET_MESSAGE_BY_ID = "SELECT * FROM message WHERE id=?";
	private static final String SQL_GET_MESSAGES_BY_RECEIVER_LOGIN = "SELECT * FROM message WHERE receiver_login=?";
	private static final String SQL_MODIFY_RECEIVER_LOGIN = "UPDATE message SET receiver_login=? WHERE id=?";
	private static final String SQL_REMOVE_MESSAGE_BY_ID = "DELETE FROM message WHERE id=?";

	public static void insert(String sender_login, String receiver_login, String type, String message)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_ADD_MESSAGE);
		pstmt.setString(1, sender_login);
		pstmt.setString(2, receiver_login);
		pstmt.setString(3, type);
		pstmt.setString(4, message);
		pstmt.executeUpdate();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void removeMessageById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_REMOVE_MESSAGE_BY_ID);
		pstmt.setInt(1, id);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static void modifyReceiverLogin(String whereValue, String newValue)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFY_RECEIVER_LOGIN);
		pstmt.setString(1, newValue);
		pstmt.setString(2, whereValue);
		pstmt.execute();

		conn.close();
		// ConnectionManager.getInstance().close();
	}

	public static List<MessageModel> getAllMessages() throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<MessageModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_MESSAGES);
			ResultSet rs = stmt.executeQuery();
			results = MessageTransformer.fromRSToTableAllMessages(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static List<MessageModel> getMessagesByReceiverLogin(String receiverLogin)
			throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		List<MessageModel> results = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQL_GET_MESSAGES_BY_RECEIVER_LOGIN);
			stmt.setString(1, receiverLogin);

			ResultSet rs = stmt.executeQuery();
			results = MessageTransformer.fromRSToTableMessagesByReceiverLogin(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		// ConnectionManager.getInstance().close();
		return results;
	}

	public static MessageModel getMessageById(Integer id) throws ClassNotFoundException, SQLException {

		try {
			conn = DataSource.getInstance().getConnection();
		} catch (IOException | PropertyVetoException e) {
			e.printStackTrace();
		}

		// conn = ConnectionManager.getInstance().getConnection();

		MessageModel result = null;
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(SQL_GET_MESSAGE_BY_ID);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		result = MessageTransformer.fromRSToTableMessageById(rs);

		conn.close();
		// ConnectionManager.getInstance().close();
		return result;
	}
}
