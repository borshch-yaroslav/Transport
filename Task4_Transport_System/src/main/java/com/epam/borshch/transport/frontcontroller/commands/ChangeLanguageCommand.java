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

public class ChangeLanguageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		
		if((request.getSession().getAttribute("locale")==null &&  request.getAttribute("locale")==null) || request.getSession().getAttribute("locale").equals("en")){
			request.getSession().setAttribute("locale", "ua");
			request.setAttribute("locale", "ua");
		}
		else{
			request.setAttribute("locale", "en");
			request.getSession().setAttribute("locale", "en");
		}
		
		if(request.getParameter("page") != null && request.getParameter("page").equals("main"))
		{
			if (request.getSession().getAttribute("role") == null)
				request.setAttribute("isRegistered", "false");
			else
				request.setAttribute("isRegistered", "true");
			forward("/pages/main_page/main_page.jsp");
		}
		else
			MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
