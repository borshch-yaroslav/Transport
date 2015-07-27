package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.DriverModel;

/**
 * DriverTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class DriverTransformer {

	public static List<DriverModel> fromRSToTableAllDrivers(ResultSet rs) {
		List<DriverModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new DriverModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setName(rs.getString("name"));
				results.get(i).setAge(rs.getInt("age"));
				results.get(i).setExperienceLevel(rs.getInt("experience_level"));
				results.get(i).setTelephoneNumber(rs.getString("telephone_number"));
				results.get(i).setTransportMastery(rs.getString("transport_mastery"));
				results.get(i).setTransportId(rs.getInt("transport_id"));
				results.get(i).setSalary(rs.getInt("salary"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static DriverModel fromRSToTableDriverById(ResultSet rs) {
		DriverModel result = new DriverModel();
		try {
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setAge(rs.getInt("age"));
				result.setExperienceLevel(rs.getInt("experience_level"));
				result.setTelephoneNumber(rs.getString("telephone_number"));
				result.setTransportMastery(rs.getString("transport_mastery"));
				result.setTransportId(rs.getInt("transport_id"));
				result.setSalary(rs.getInt("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static DriverModel fromRSToTableDriverByTransportId(ResultSet rs) {
		DriverModel result = new DriverModel();
		try {
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setAge(rs.getInt("age"));
				result.setExperienceLevel(rs.getInt("experience_level"));
				result.setTelephoneNumber(rs.getString("telephone_number"));
				result.setTransportMastery(rs.getString("transport_mastery"));
				result.setTransportId(rs.getInt("transport_id"));
				result.setSalary(rs.getInt("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
