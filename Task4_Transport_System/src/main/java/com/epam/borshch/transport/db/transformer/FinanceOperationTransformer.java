package com.epam.borshch.transport.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.borshch.transport.db.model.FinanceOperationModel;

/**
 * FinanceOperationTransformer.
 * 
 * + handles requests from analogical DAO.
 * + generates result java-models from prepared statements.
 * 
 * @author Slavko
 *
 */

public class FinanceOperationTransformer {

	public static List<FinanceOperationModel> fromRSToTableAllFinanceOperations(ResultSet rs) {
		List<FinanceOperationModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new FinanceOperationModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setDescription(rs.getString("description"));
				results.get(i).setFinanceChange(rs.getInt("finance_change"));
				results.get(i).setDate(rs.getString("date"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static List<FinanceOperationModel> fromRSToTableFinanceOperationsByDateInterval(ResultSet rs) {
		List<FinanceOperationModel> results = new ArrayList<>();
		int i = 0;
		try {
			while (rs.next()) {
				results.add(new FinanceOperationModel());
				results.get(i).setId(rs.getInt("id"));
				results.get(i).setDescription(rs.getString("description"));
				results.get(i).setFinanceChange(rs.getInt("finance_change"));
				results.get(i).setFinanceChange(rs.getInt("date"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
