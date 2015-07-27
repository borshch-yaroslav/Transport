package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.FinanceOperationModelDAO;
import com.epam.borshch.transport.db.model.FinanceOperationModel;

/**
 * FinanceOperationModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class FinanceOperationModelService {

	public static List<FinanceOperationModel> getAllFinanceOperations() {
		try {
			return FinanceOperationModelDAO.getAllFinanceOperations();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int FinanceOperationModelService in getAllOperations()");
			return null;
		}
	}

	public static List<FinanceOperationModel> getFinanceOperationByDateInterval(String date1, String date2){
		try {
			return FinanceOperationModelDAO.getFinanceOperationByDateInterval(date1, date2);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception in getFinanceOperationByLogin in service");
			return null;
		}
	}

	public static void insert(String description, Integer financeChange, String date){
		try {
			FinanceOperationModelDAO.insert(description, financeChange, date);
		} catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception int FinanceOperationModelService in insert.");
		}
	}
}
