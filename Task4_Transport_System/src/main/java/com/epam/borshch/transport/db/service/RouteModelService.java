package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.RouteModelDAO;
import com.epam.borshch.transport.db.model.RouteModel;

/**
 * RouteModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class RouteModelService {

	public static List<RouteModel> getAllRoutes() {
		try {
			return RouteModelDAO.getAllRoutes();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int RouteModelService in getAllRoutes()");
			return null;
		}
	}

	public static RouteModel getRouteById(Integer id) {
		try {
			return RouteModelDAO.getRouteById(id);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Route allredy exists (RegisterCommand)");
			return null;
		}
	}
	
	public static List<RouteModel> getRoutesByTransportType(String type){
		
		try {
			return RouteModelDAO.getRouteByTransportType(type);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Route allredy exists (RegisterCommand)");
			return null;
		}
	}

	public static void insert(RouteModel route) {
		try {
			RouteModelDAO.insert(route);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int RouteModelService in insert.");
		}
	}

	public static void removeRouteById(Integer id) {
		try {
			RouteModelDAO.removeRouteById(id);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int RouteModelService in remove.");
		}
	}

	public static void modifyNumberOfCars(String whereValue, String newValue) {
		try {
			RouteModelDAO.modifyNumberOfCars(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int RouteModelService in ModifyNumberOfCars.");
		}
	}
	
	public static void modifyTerminalStation1(String whereValue, String newValue) {
		try {
			RouteModelDAO.modifyTerminalStation1(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int RouteModelService in ModifyStation1.");
		}
	}
	
	public static void modifyTerminalStation2(String whereValue, String newValue) {
		try {
			RouteModelDAO.modifyTerminalStation2(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int RouteModelService in ModifyStation2.");
		}
	}
}
