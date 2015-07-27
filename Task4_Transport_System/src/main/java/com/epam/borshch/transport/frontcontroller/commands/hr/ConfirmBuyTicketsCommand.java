package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.service.FinanceOperationModelService;
import com.epam.borshch.transport.db.service.UserModelService;
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

public class ConfirmBuyTicketsCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		UserModelService.modifyNumberOfTickets((String)request.getSession().getAttribute("login"), Integer.parseInt(request.getParameter("numberBus")), Integer.parseInt(request.getParameter("numberTram")), Integer.parseInt(request.getParameter("numberTrolley")));
		
		Integer sum = (Integer.parseInt(request.getParameter("numberBus"))+ Integer.parseInt(request.getParameter("numberTram"))+ Integer.parseInt(request.getParameter("numberTrolley"))) * 5;
		FinanceOperationModelService.insert("sold tickets", sum, (new Date()).toString());
		
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
