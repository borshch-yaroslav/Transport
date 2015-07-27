package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.service.MessageModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * DeleteMessageCommand - extends FrontCommand.
 * 
 * + removes message from database.
 *
 * @author Slavko
 *
 */

public class DeleteMessageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("txtId"));
		MessageModelService.removeMessageById(id);
		
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
