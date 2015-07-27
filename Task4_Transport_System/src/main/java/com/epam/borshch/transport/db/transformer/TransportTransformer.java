package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.TransportModel;

/**
 * TransportTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class TransportTransformer {

	public static List<TransportModel> fromRSToTableAllTransport(ResultSet rs) {
		List<TransportModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new TransportModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setType(rs.getString("type"));
				results.get(i).setRouteNumber(rs.getInt("route_number"));
				results.get(i).setCapacity(rs.getInt("capacity"));
				results.get(i).setModel(rs.getString("model"));
				results.get(i).setYear(rs.getInt("year"));
				results.get(i).setUpkeep(rs.getInt("upkeep"));
				results.get(i).setDriverId(rs.getInt("driver_id"));
				results.get(i).setValue(rs.getInt("value"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static TransportModel fromRSToTableTransportById(ResultSet rs) {
		TransportModel result = new TransportModel();
		try {
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setType(rs.getString("type"));
				result.setRouteNumber(rs.getInt("route_number"));
				result.setCapacity(rs.getInt("capacity"));
				result.setModel(rs.getString("model"));
				result.setYear(rs.getInt("year"));
				result.setUpkeep(rs.getInt("upkeep"));
				result.setValue(rs.getInt("value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
