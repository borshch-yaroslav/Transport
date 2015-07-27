package com.epam.borshch.transport.frontcontroller.commands.route;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.model.RouteStationsModel;
import com.epam.borshch.transport.db.service.RouteModelService;
import com.epam.borshch.transport.db.service.RouteStationsModelService;
import com.epam.borshch.transport.db.service.StationModelService;
import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

public class ConfirmRouteCreateCommand extends FrontCommand {

	/**
	 * ConfirmRouteCreateCommand - extends FrontCommand.
	 * 
	 * + final step, when processing request for create new route.
	 *
	 * @author Slavko
	 *
	 */

	@Override
	public void process() throws ServletException, IOException {

		RouteModel route = new RouteModel();
		route.setRouteNumber(Integer.parseInt(request.getParameter("routeNumber")));
		route.setTransportType(request.getParameter("transportType"));
		route.setNumberOfCars(0);
		route.setIntervalTime(request.getParameter("interval"));
		route.setStartTime(request.getParameter("startTime"));
		route.setEndTime(request.getParameter("endTime"));
		route.setProfitability(0);

		if (!request.getParameter("geographic_name" + 1).equals(""))
			route.setTerminalStation1(request.getParameter("station" + 1));

		int numberOfLast = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.println(request.getParameter("geographic_name" + i));
			if (request.getParameter("geographic_name" + i).equals("")) {
				numberOfLast = i - 1;
				break;
			}

			route.addStation(request.getParameter("station" + i));
			StationModelService.insert(request.getParameter("station" + i),
					Double.parseDouble(request.getParameter("latitude" + i)),
					Double.parseDouble(request.getParameter("longtitude" + i)),
					request.getParameter("geographic_name" + i));
		}

		route.setTerminalStation1(request.getParameter("station" + 1));
		route.setTerminalStation2(request.getParameter("station" + numberOfLast));
		

		RouteModelService.insert(route);

		// ---Create model and store route way in database
		List<RouteModel> allRoutes = RouteModelService.getAllRoutes();
		RouteModel routeForId = allRoutes.get(allRoutes.size() - 1);

		RouteStationsModel routing = new RouteStationsModel();
		routing.setRouteId(routeForId.getId());
		routing.setStations(route.getStations());

		RouteStationsModelService.insert(routing);
		// -------------------

		// --------Increment number of routes by all the stations------
		for (String stationName : route.getStations()) {
			if (!StationModelService.getStationBystationName(stationName).equals(""))
				StationModelService.modifyNumberOfRoutes(stationName, 1);
		}

		request.setAttribute("message",
				"Success. New " + route.getTransportType() + " route № " + route.getRouteNumber() + " is created.");

		MainDispatchCommand.dispatchForServlets(context, request, response);
	}
}
