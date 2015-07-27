package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * LogoutCommand - extends FrontCommand.
 * 
 * Handles logic of users logout procedure.
 * 
 * + Invalidates current session and sends program on main page, with "not registered" state.
 * 
 *+ delegates program to MainPage.
 *
 *
 * @author Slavko
 *
 */

public class LogoutCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		
		request.setAttribute("locale", request.getSession().getAttribute("locale"));
		
		request.getSession().invalidate();
		request.setAttribute("isRegistered", "false");
		forward("/pages/main_page/main_page.jsp");
	}
}
