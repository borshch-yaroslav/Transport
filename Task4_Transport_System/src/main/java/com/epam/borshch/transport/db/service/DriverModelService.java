package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.DriverModelDAO;
import com.epam.borshch.transport.db.model.DriverModel;

/**
 * DriverModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class DriverModelService {

	public static List<DriverModel> getAllDrivers() {
		try {
			return DriverModelDAO.getAllDrivers();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int DriverModelService in getUsers()");
			return null;
		}
	}
	
	public static List<DriverModel> getAllDriversOfTransport(String transportType){
		
		try {
			return DriverModelDAO.getAllDriversOfTransport(transportType);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int DriverModelService in getUsers()");
			return null;
		}
	}
	
	public static List<DriverModel> getAllFreeDriversOfTransport(String transportType){
		
		try {
			return DriverModelDAO.getAllFreeDriversOfTransport(transportType);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int DriverModelService in getUsers()");
			return null;
		}
	}

	public static DriverModel getDriverById(Integer id){
		try {
			return DriverModelDAO.getDriverById(id);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Driver allredy exists (RegisterCommand)");
			return null;
		}
	}
	
	public static DriverModel getDriverByTransportId(Integer transportId){
		try {
			return DriverModelDAO.getDriverByTransportId(transportId);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Driver allredy exists (RegisterCommand)");
			return null;
		}
	}

	public static void insert(DriverModel driver){
		try {
			DriverModelDAO.insert(driver);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception int DriverModelService in insert.");
		}
	}
	
	public static void removeDriverById(Integer id){
		try {
			DriverModelDAO.removeDriverById(id);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int DriverModelService in remove.");
		}
	}
	
	public static void modifyTransportId(String whereValue, String newValue){
		try {
			DriverModelDAO.modifyTransportId(whereValue, newValue);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception int DriverModelService in modifyTransportId.");
		}
	}
}
