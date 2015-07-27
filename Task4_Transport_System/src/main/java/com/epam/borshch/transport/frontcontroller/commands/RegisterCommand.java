package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.epam.borshch.transport.db.service.UserModelService;

/**
 * RegisterCommand - instance of FrontCommand.
 * 
 * Handles logic of users registration procedure.
 * 
 * + Processes retrieved users login, password, name and email.
 * + If user doedn't exist - insert new record into database,
 * + starts ServletSession for current user.
 * + and sets important in future Session Attributes:
 * 		- login;
 * 		- name;
 *		- role (access level);
 *+ delegates program to MainDispatcherCommand.
 *
 *+ if there is existed user with such parameters - sends back, with proper warning on main page. 
 *
 * @author Slavko
 *
 */

public class RegisterCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		String login = request.getParameter("txtLoginR");
		String password = request.getParameter("regPassword");
		String name = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");	
		String locale = request.getParameter("txtLocale");	
		
		if(locale == null)
			locale="ua";
		
		if (UserModelService.getUserByLogin(login).getLogin() == null) {
			UserModelService.insert(login, password, name, email, "user", locale);

			HttpSession session = request.getSession(true);
			session.setAttribute("login", login);
			session.setAttribute("name", name);
			session.setAttribute("role", "user");
			session.setAttribute("locale", locale);
			
			request.setAttribute("message", "Thanks for registration:)");
			request.setAttribute("isRegistered", "true");
			
			MainDispatchCommand.dispatchForServlets(context, request, response);
		}
		else {
			request.setAttribute("warning_reg", "Login is not availablee.");
			request.setAttribute("isRegistered", "false");
			request.setAttribute("txtLogin", login);
			request.setAttribute("txtName", name);
			request.setAttribute("txtEmail", email);
			request.setAttribute("txtLocale", locale);
			
			request.setAttribute("locale", request.getParameter("locale"));
			forward("/pages/main_page/main_page.jsp");

		}
	}
}
