package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.UserModel;
import com.epam.borshch.transport.db.service.UserModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * AssignAdminCommand - extends FrontCommand.
 * 
 * + handles request for assigning user  as admin.
 *
 * @author Slavko
 *
 */

public class AssignAdminCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		String login = request.getParameter("txtLogin");

		UserModel user = UserModelService.getUserByLogin(login);

		if (user.getLogin() != null) {
			if (UserModelService.getUserByLogin(login).getRole().equals("admin"))
				request.setAttribute("message", login + " is already admin.");
			else {
				UserModelService.modifyRole(user.getLogin(), "admin");
				request.setAttribute("message", "Admin " + login + " assigned successfuly.");
			}
		} else
			request.setAttribute("message", "User " + login + " doesn't exist.");
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
