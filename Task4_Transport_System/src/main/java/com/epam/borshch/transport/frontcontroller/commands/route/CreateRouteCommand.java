package com.epam.borshch.transport.frontcontroller.commands.route;

import java.io.IOException;

import javax.servlet.ServletException;

import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;

public class CreateRouteCommand extends FrontCommand {

	/**
	 * CreateRouteCommand - extends FrontCommand.
	 * 
	 * + opens window, where creation of new route takes place.
	 *
	 * @author Slavko
	 *
	 */
	
	@Override
	public void process() throws ServletException, IOException {
        
		forward("/pages/market_pages/route_create.jsp");
	}
}
