package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.borshch.transport.db.model.UserModel;
import com.epam.borshch.transport.db.service.UserModelService;

/**
 * LoginCommand - extends FrontCommand.
 * 
 * Handles logic of users login procedure.
 * 
 * + Processes retrieved users login and password,
 * + if user exists - extract model from database,
 * + starts ServletSession for current user
 * + and sets important in future Session Attributes:
 * 		- login;
 * 		- name;
 *		- role (access level);
 *+ delegates program to MainDispatcherCommand.
 *
 *+ if there is no user with such parameters - sends back, with proper warning on main page. 
 *
 * @author Slavko
 *
 */

public class LoginCommand extends FrontCommand {
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public void process() throws ServletException, IOException {


		LOG.warn( "Someone tried to login..." );
		
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");

		UserModel user = UserModelService.getUserByLogin(login);

		if (user.getLogin() != null && user.getPassword().equals(password)) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("login", login);
			session.setAttribute("name", user.getName());
			session.setAttribute("role", user.getRole());
			session.setAttribute("locale", user.getLocale());
			
			request.setAttribute("isRegistered", "true");
			
			LOG.warn( user.getRole()+" "+ login+"'s: login accepted.");
			MainDispatchCommand.dispatchForServlets(context, request, response);
			
		} else {
			request.setAttribute("isRegistered", "false");
			request.setAttribute("warning_login", "Incorrect login or/and password input.");
			request.setAttribute("txtLogin", login);
			
			request.setAttribute("locale", request.getParameter("locale"));
			
			LOG.warn("User entered incorrect login or password.");
			
			forward("/pages/main_page/main_page.jsp");
		}
	}
}
