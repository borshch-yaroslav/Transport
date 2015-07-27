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
 * ConfirmBuyTransportCommand - extends FrontCommand.
 * 
 * + final step, when processing request for purchase new transport.
 *
 * @author Slavko
 *
 */

public class ConfirmBuyTransportCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		TransportModel transport = new TransportModel(request.getParameter("type"), request.getParameter("capacity"),
				request.getParameter("year"), request.getParameter("model"), request.getParameter("upkeep"),
				request.getParameter("value"));
		transport.setRouteNumber(0);
		transport.setDriverId(0);

		TransportModelService.insert(transport);

		request.setAttribute("message", "Success. Transport " + transport.getType() + " is bought.");

		FinanceOperationModelService.insert("bought transport", transport.getValue(), (new Date()).toString());
		
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
