package com.epam.borshch.transport.frontcontroller.commands.hr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.epam.borshch.transport.additional.DriversForHireListGenerator;
import com.epam.borshch.transport.db.model.DriverModel;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;

public class HireDriverCommand extends FrontCommand {

	/**
	 * HireDriverCommand - extends FrontCommand.
	 * 
	 * + opens list of drivers available for hire.
	 *
	 * @author Slavko
	 *
	 */
	
	@Override
	public void process() throws ServletException, IOException {

		List<DriverModel> driverSet = DriversForHireListGenerator.generate();
		request.setAttribute("drivers", driverSet);
		forward("/pages/market_pages/drivers_for_hire.jsp");
	}
}
