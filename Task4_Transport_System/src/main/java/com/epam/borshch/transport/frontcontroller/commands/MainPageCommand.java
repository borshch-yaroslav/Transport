package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * MainPageCommand - extends FrontCommand.
 * 
 * + forwards on main page.
 *
 * @author Slavko
 *
 */

public class MainPageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		if (request.getSession().getAttribute("role") == null)
			request.setAttribute("isRegistered", "false");
		else
			request.setAttribute("isRegistered", "true");
		forward("/pages/main_page/main_page.jsp");
	}
}
