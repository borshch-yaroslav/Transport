package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.UserModelDAO;
import com.epam.borshch.transport.db.model.UserModel;

/**
 * UserModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class UserModelService {

	public static List<UserModel> getAllUsers() {
		try {
			return UserModelDAO.getAllUsers();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int UserModelService in getUsers()");
			return null;
		}
	}

	public static List<UserModel> getUsersByRole(String role) {
		try {
			return UserModelDAO.getUsersByRole(role);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int UserModelService in getUsersByRole()");
			return null;
		}
	}

	public static UserModel getUserByLogin(String login) {
		try {
			return UserModelDAO.getUserByLogin(login);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception in getUserByLogin in service");
			return null;
		}
	}

	public static void insert(String login, String password, String name, String email, String role, String locale) {
		try {
			UserModelDAO.insert(login, password, name, email, role, locale);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int UserModelService in insert.");
			e.printStackTrace();
		}
	}

	public static void modifyRole(String whereValue, String newValue) {
		try {
			UserModelDAO.modifyRole(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int UserModelService in modifyRole.");
		}
	}

	public static void modifyNumberOfTickets(String whereValue, Integer busTicketsModifier, Integer tramTicketsModifier,
			Integer trolleyTicketsModifier) {
		try {
			UserModelDAO.modifyNumberOfTickets(whereValue, busTicketsModifier, tramTicketsModifier,
					trolleyTicketsModifier);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int UserModelService in modifyRole.");
		}
	}

	public static void modifyLocale(String whereValue, String newValue) {
		try {
			UserModelDAO.modifyRole(whereValue, newValue);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception int UserModelService in modifyLocale.");
		}
	}
}
