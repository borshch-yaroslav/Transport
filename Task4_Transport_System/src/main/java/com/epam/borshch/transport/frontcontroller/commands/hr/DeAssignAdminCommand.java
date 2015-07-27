package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.UserModel;
import com.epam.borshch.transport.db.service.UserModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * DeAssignAdminCommand - extends FrontCommand.
 * 
 * + changes users role from "admin" to "user".
 *
 * @author Slavko
 *
 */

public class DeAssignAdminCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		String login = request.getParameter("loginToDelete");

		UserModel user = UserModelService.getUserByLogin(login);

		if (user.getLogin() != null) {
			if (UserModelService.getUserByLogin(login).getRole().equals("user"))
				request.setAttribute("message", login + " isn't admin.");
			else {
				UserModelService.modifyRole(user.getLogin(), "user");
				request.setAttribute("message", "Success " + login + " is not admin now.");
			}
		} else
			request.setAttribute("message", "Admin " + login + " doesn't exist.");

		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
