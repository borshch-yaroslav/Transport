package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.dao.UserModelDAO;
import com.epam.borshch.transport.db.service.MessageModelService;
import com.epam.borshch.transport.db.service.UserModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * SendMessageCommand - extends FrontCommand.
 * 
 * + insert message into database.
 *
 * @author Slavko
 *
 */

public class SendMessageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		try {

			String senderLogin = (String) request.getSession().getAttribute("role");
			String receiverLogin = request.getParameter("receiverLogin");
			String messageType = request.getParameter("subject");

			if (UserModelDAO.getUserByLogin(receiverLogin).getLogin() != null) {
				if (senderLogin.equals("admin") || senderLogin.equals("commander")) {
					MessageModelService.insert(senderLogin, receiverLogin, messageType,
							request.getParameter("messageText"));
				} else {
					if (UserModelService.getUserByLogin(receiverLogin).getRole()
							.equals("commander")) {
						MessageModelService.insert(senderLogin,
								UserModelService.getUsersByRole("admin").get(0).getLogin(), "message for Commander", request.getParameter("messageText"));
					} else {
						MessageModelService.insert((String) request.getSession().getAttribute("login"),
								request.getParameter("receiverLogin"), "message", request.getParameter("messageText"));
					}
				}
				request.setAttribute("message", "Message is sent successfuly");
			} else
				request.setAttribute("message", "Fail. Receiver doesn't exist...");
			MainDispatchCommand.dispatchForServlets(context, request, response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception while send message");
		}
	}
}
