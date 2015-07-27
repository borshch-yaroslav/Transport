package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.RouteModel;

/**
 * RouteTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class RouteTransformer {

	public static List<RouteModel> fromRSToTableAllRoutes(ResultSet rs) {
		List<RouteModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new RouteModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setRouteNumber(rs.getInt("route_number"));
				results.get(i).setTransportType(rs.getString("transport_type"));
				results.get(i).setNumberOfCars(rs.getInt("number_of_cars"));
				results.get(i).setIntervalTime(rs.getString("interval_time"));
				results.get(i).setStartTime((String)rs.getString("start_time"));
				results.get(i).setEndTime((String)rs.getString("end_time"));
				results.get(i).setTerminalStation1(rs.getString("terminal_station_1"));
				results.get(i).setTerminalStation2(rs.getString("terminal_station_2"));
				results.get(i).setProfitability(rs.getInt("profitability"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static RouteModel fromRSToTableRouteById(ResultSet rs) {
		RouteModel result = new RouteModel();
		try {
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setRouteNumber(rs.getInt("route_number"));
				result.setTransportType(rs.getString("transport_type"));
				result.setNumberOfCars(rs.getInt("number_of_cars"));
				result.setIntervalTime(rs.getString("interval_time"));
				result.setStartTime(rs.getString("start_time"));
				result.setEndTime(rs.getString("end_time"));
				result.setTerminalStation1(rs.getString("terminal_station_1"));
				result.setTerminalStation2(rs.getString("terminal_station_2"));
				result.setProfitability(rs.getInt("profitability"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
