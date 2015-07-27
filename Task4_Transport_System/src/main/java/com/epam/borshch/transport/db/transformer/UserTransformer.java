package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.UserModel;

/**
 * UserTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class UserTransformer {

	public static List<UserModel> fromRSToTableAllUsers(ResultSet rs) {
		List<UserModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new UserModel());
				results.get(i).setLogin(rs.getString("login"));
				results.get(i).setPassword(rs.getString("password"));
				results.get(i).setName(rs.getString("name"));
				results.get(i).setEmail(rs.getString("email"));
				results.get(i).setRole(rs.getString("role"));
				results.get(i).setLocale(rs.getString("locale"));
				results.get(i).setBusTickets(rs.getInt("bus_tickets"));
				results.get(i).setTramTickets(rs.getInt("tram_tickets"));
				results.get(i).setTrolleyTickets(rs.getInt("trolley_tickets"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static List<UserModel> fromRSToTableUsersByRole(ResultSet rs) {
		List<UserModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new UserModel());
				results.get(i).setLogin(rs.getString("login"));
				results.get(i).setPassword(rs.getString("password"));
				results.get(i).setName(rs.getString("name"));
				results.get(i).setEmail(rs.getString("email"));
				results.get(i).setRole(rs.getString("role"));
				results.get(i).setLocale(rs.getString("locale"));
				results.get(i).setBusTickets(rs.getInt("bus_tickets"));
				results.get(i).setTramTickets(rs.getInt("tram_tickets"));
				results.get(i).setTrolleyTickets(rs.getInt("trolley_tickets"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public static UserModel fromRSToTableUserByLogin(ResultSet rs) {
		UserModel result = new UserModel();
		try {
			while (rs.next()) {
				result.setLogin(rs.getString("login"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setRole(rs.getString("role"));
				result.setLocale(rs.getString("locale"));
				result.setBusTickets(rs.getInt("bus_tickets"));
				result.setTramTickets(rs.getInt("tram_tickets"));
				result.setTrolleyTickets(rs.getInt("trolley_tickets"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
