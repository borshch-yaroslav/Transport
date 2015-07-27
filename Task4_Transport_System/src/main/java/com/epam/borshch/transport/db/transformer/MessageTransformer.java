package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.MessageModel;

/**
 * MessageTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class MessageTransformer {

	public static List<MessageModel> fromRSToTableMessagesByReceiverLogin(ResultSet rs) {
		List<MessageModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new MessageModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setSenderLogin(rs.getString("sender_login"));
				results.get(i).setReceiverLogin(rs.getString("receiver_login"));
				results.get(i).setType(rs.getString("type"));
				results.get(i).setMessage(rs.getString("message"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static List<MessageModel> fromRSToTableAllMessages(ResultSet rs) {
		List<MessageModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new MessageModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setSenderLogin(rs.getString("sender_login"));
				results.get(i).setReceiverLogin(rs.getString("receiver_login"));
				results.get(i).setType(rs.getString("type"));
				results.get(i).setMessage(rs.getString("message"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	public static MessageModel fromRSToTableMessageById(ResultSet rs) {
		MessageModel result = new MessageModel();
		try {
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setSenderLogin(rs.getString("sender_login"));
				result.setReceiverLogin(rs.getString("receiver_login"));
				result.setType(rs.getString("typr"));
				result.setMessage(rs.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
