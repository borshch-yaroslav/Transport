package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.service.DriverModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

public class FireDriverCommand extends FrontCommand {

	/**
	 * FireDriverCommand - extends FrontCommand.
	 * 
	 * + removes driver from database.
	 *
	 * @author Slavko
	 *
	 */
	
	@Override
	public void process() throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("fireId"));

		DriverModelService.removeDriverById(id);
		request.setAttribute("message", "Success. Driver №" + id + " is fired.");

		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
