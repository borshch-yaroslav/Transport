package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.TransportModelDAO;
import com.epam.borshch.transport.db.model.TransportModel;

/**
 * TransportModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class TransportModelService {

	public static List<TransportModel> getAllTransport() {
		try {
			return TransportModelDAO.getAllTransport();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int TransportModelService in getUsers()");
			return null;
		}
	}

	public static TransportModel getTransportById(Integer id) {
		try {
			return TransportModelDAO.getTransportById(id);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Transport allredy exists (RegisterCommand)");
			return null;
		}
	}

	public static void insert(TransportModel transport) {
		try {
			TransportModelDAO.insert(transport);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int TransportModelService in insert.");
		}
	}

	public static void removeTransportById(Integer id) {
		try {
			TransportModelDAO.removeTransportById(id);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int TransportModelService in remove.");
		}
	}

	public static void modifyRouteNumber(String whereValue, String newValue) {
		try {
			TransportModelDAO.modifyRouteNumber(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int TransportModelService in ModifyRouteNumber.");
		}
	}
	
	public static void modifyDriverId(String whereValue, String newValue) {
		try {
			TransportModelDAO.modifyDriverId(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int TransportModelService in DriverId.");
		}
	}
}
