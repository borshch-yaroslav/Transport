package com.epam.borshch.transport.frontcontroller.commands.transport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.epam.borshch.transport.additional.TransportToBuyListGenerator;
import com.epam.borshch.transport.db.model.TransportModel;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;

public class BuyTransportCommand extends FrontCommand {

	/**
	 * BuyTransportCommand - extends FrontCommand.
	 * 
	 * + open list of transport available for purchase.
	 *
	 * @author Slavko
	 *
	 */
	
	@Override
	public void process() throws ServletException, IOException {

		List<TransportModel> transportSet = TransportToBuyListGenerator.generate();
		request.setAttribute("transports", transportSet);
		
		forward("/pages/market_pages/transport_to_buy.jsp");
	}
}
