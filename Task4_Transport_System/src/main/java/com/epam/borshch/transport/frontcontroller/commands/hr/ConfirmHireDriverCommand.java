package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.DriverModel;
import com.epam.borshch.transport.db.service.DriverModelService;
import com.epam.borshch.transport.db.service.FinanceOperationModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * ConfirmHireDriverCommand - extends FrontCommand.
 * 
 * + final step, when processing request for hire new driver.
 *
 * @author Slavko
 *
 */

public class ConfirmHireDriverCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {

		DriverModel driver = new DriverModel(request.getParameter("name"), request.getParameter("age"), request.getParameter("exp"), request.getParameter("telNum"), request.getParameter("tranMast"), request.getParameter("salary"));
		driver.setTransportId(0);
		
		DriverModelService.insert(driver);
		
		request.setAttribute("message", "Success. Driver " + driver.getName() + " is hired.");
		
		FinanceOperationModelService.insert("hired driver", driver.getSalary(), (new Date()).toString());
		
		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
