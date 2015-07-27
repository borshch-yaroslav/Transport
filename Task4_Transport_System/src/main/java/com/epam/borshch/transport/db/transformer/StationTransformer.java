package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.StationModel;

/**
 * StationTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class StationTransformer {

	public static List<StationModel> fromRSToTableAllStations(ResultSet rs) {
		List<StationModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new StationModel());
				results.get(i).setName(rs.getString("station_name"));
				results.get(i).setNumberOfRoutes(rs.getInt("number_of_routes"));
				results.get(i).setLatitude(rs.getDouble("latitude"));
				results.get(i).setLongtitude(rs.getDouble("longtitude"));
				results.get(i).setGeographicName(rs.getString("geographic_name"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static StationModel fromRSToTableStationByName(ResultSet rs) {
		StationModel result = new StationModel();
		try {
			while (rs.next()) {
				result.setName(rs.getString("station_name"));
				result.setNumberOfRoutes(rs.getInt("number_of_routes"));
				result.setLatitude(rs.getDouble("latitude"));
				result.setLongtitude(rs.getDouble("longtitude"));
				result.setGeographicName(rs.getString("geographic_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static StationModel fromRSToTableStationNameByGeographicName(ResultSet rs){
		
		StationModel result = new StationModel();
		try {
			 if(rs.next()){
				result.setName(rs.getString("station_name"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
