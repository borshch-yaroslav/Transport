package com.epam.borshch.transport.frontcontroller.commands.transport;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.TransportModel;
import com.epam.borshch.transport.db.service.FinanceOperationModelService;
import com.epam.borshch.transport.db.service.TransportModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * SellTransportCommand - extends FrontCommand.
 * 
 * + removes transport from database.
 *
 * @author Slavko
 *
 */

public class SellTransportCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("sellId"));

		TransportModel transport = TransportModelService.getTransportById(id);

		TransportModelService.removeTransportById(id);
		request.setAttribute("message", "Success. " + transport.getType() + " with id №" + id + " is sold.");

		FinanceOperationModelService.insert("sold transport", -transport.getValue(), (new Date()).toString());
		
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
