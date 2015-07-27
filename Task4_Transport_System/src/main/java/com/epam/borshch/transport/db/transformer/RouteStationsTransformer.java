package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.RouteStationsModel;

/**
 * RouteStationsTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class RouteStationsTransformer {

	public static List<RouteStationsModel> fromRSToTableAllRouteStationLists(ResultSet rs) {
		List<RouteStationsModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new RouteStationsModel());
				results.get(i).setRouteId(rs.getInt("route_id"));
				results.get(i).addStation(rs.getString("station_1"));
				results.get(i).addStation(rs.getString("station_2"));
				results.get(i).addStation(rs.getString("station_3"));
				results.get(i).addStation(rs.getString("station_4"));
				results.get(i).addStation(rs.getString("station_5"));
				results.get(i).addStation(rs.getString("station_6"));
				results.get(i).addStation(rs.getString("station_7"));
				results.get(i).addStation(rs.getString("station_8"));
				results.get(i).addStation(rs.getString("station_9"));
				results.get(i).addStation(rs.getString("station_10"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static RouteStationsModel fromRSToTableStationListByRouteId(ResultSet rs) {
		RouteStationsModel result = new RouteStationsModel();
		try {
			while (rs.next()) {
				result.setRouteId(rs.getInt("route_id"));
				result.addStation(rs.getString("station_1"));
				result.addStation(rs.getString("station_2"));
				result.addStation(rs.getString("station_3"));
				result.addStation(rs.getString("station_4"));
				result.addStation(rs.getString("station_5"));
				result.addStation(rs.getString("station_6"));
				result.addStation(rs.getString("station_7"));
				result.addStation(rs.getString("station_8"));
				result.addStation(rs.getString("station_9"));
				result.addStation(rs.getString("station_10"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
