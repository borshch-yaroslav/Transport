package com.epam.borshch.transport.frontcontroller.commands.route;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.service.RouteModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;

public class DeleteRouteCommand extends FrontCommand {

	/**
	 * DeleteRouteCommand - extends FrontCommand.
	 * 
	 * + removes route from database.
	 *
	 * @author Slavko
	 *
	 */
	
	@Override
	public void process() throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("deleteId"));

		RouteModel route = RouteModelService.getRouteById(id);

		RouteModelService.removeRouteById(id);
		request.setAttribute("message", "Success. " + route.getTransportType() + " route №" + route.getRouteNumber()
				+ " with ID " + id + " is deleted.");

		List<RouteModel> routeSet = RouteModelService.getAllRoutes();
		request.setAttribute("routes", routeSet);

		forward("/pages/table_pages/table_of_routes.jsp");
	}
}
