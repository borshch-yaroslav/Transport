package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.model.UserModel;
import com.epam.borshch.transport.db.service.DriverModelService;
import com.epam.borshch.transport.db.service.FinanceOperationModelService;
import com.epam.borshch.transport.db.service.MessageModelService;
import com.epam.borshch.transport.db.service.RouteModelService;
import com.epam.borshch.transport.db.service.RouteStationsModelService;
import com.epam.borshch.transport.db.service.StationModelService;
import com.epam.borshch.transport.db.service.TransportModelService;
import com.epam.borshch.transport.db.service.UserModelService;

/**
 * MainDispatchCommand - extends FrontCommand.
 * 
 * Handles logic of dispatching for further processing, according to access level of visitor
 * of the site.
 * 
 * Methods:
 * + process() - standard inherited method.
 * + static dispatchForServlets() - equivalent method for accessing Dispatcher from Commands.
 * 
 * + if user is registered - forwards on individual page.
 * + else - forwards on main page.
 *
 * @author Slavko
 *
 */

public class MainDispatchCommand extends FrontCommand {

	private static final Logger LOG = Logger.getLogger(MainDispatchCommand.class);
	
	@Override
	public void process() throws ServletException, IOException {

		request.setAttribute("locale", request.getAttribute("locale"));
		
		if (request.getSession() == null || request.getSession().getAttribute("login") == null) {
			request.setAttribute("isRegistered", "false");
			request.setAttribute("locale", "en");
			forward("/pages/main_page/main_page.jsp");
		} else if (request.getSession().getAttribute("role").equals("admin")){
			request.setAttribute("messages", MessageModelService.getMessageByReceiverLogin((String) request.getSession().getAttribute("login")));
			request.setAttribute("drivers", DriverModelService.getAllDrivers());
			request.setAttribute("transports", TransportModelService.getAllTransport());
			request.setAttribute("users", UserModelService.getAllUsers());
					
			request.setAttribute("financeOperations", FinanceOperationModelService.getAllFinanceOperations());
			request.setAttribute("freeBusDriver", DriverModelService.getAllFreeDriversOfTransport("bus"));
			request.setAttribute("freeTramDriver", DriverModelService.getAllFreeDriversOfTransport("tram"));
			request.setAttribute("freeTrolleyDriver", DriverModelService.getAllFreeDriversOfTransport("trolley"));
			
			forward("/pages/user_pages/admin_page.jsp");
		}
		else if (request.getSession().getAttribute("role").equals("user")){
			request.setAttribute("user",UserModelService.getUserByLogin((String)request.getSession().getAttribute("login")));
			request.setAttribute("messages", MessageModelService.getMessageByReceiverLogin((String) request.getSession().getAttribute("login")));
			request.setAttribute("routes", RouteModelService.getAllRoutes());
			request.setAttribute("routeStationLists", RouteStationsModelService.getAllStationLists());
			forward("/pages/user_pages/user_page.jsp");
		}
		else if (request.getSession().getAttribute("role").equals("commander")){
			request.setAttribute("financeOperations", FinanceOperationModelService.getAllFinanceOperations());
			request.setAttribute("messages", MessageModelService.getMessageByReceiverLogin((String) request.getSession().getAttribute("login")));
			request.setAttribute("routes", RouteModelService.getAllRoutes());
			request.setAttribute("routeStationLists", RouteStationsModelService.getAllStationLists());
			request.setAttribute("stations", StationModelService.getAllStations());
			request.setAttribute("users", UserModelService.getUsersByRole("admin"));
			forward("/pages/user_pages/commander_page.jsp");
		}
	}

	public static void dispatchForServlets(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher dispatcher = null;

		if (request.getSession() == null || request.getSession().getAttribute("login") == null) {
			request.setAttribute("isRegistered", "false");
			dispatcher = context.getRequestDispatcher("/pages/main_page/main_page.jsp");
		} else if (request.getSession().getAttribute("role").equals("admin")) {
			request.setAttribute("freeBusDrivers", DriverModelService.getAllFreeDriversOfTransport("bus"));
			request.setAttribute("freeTramDrivers", DriverModelService.getAllFreeDriversOfTransport("tram"));
			request.setAttribute("freeTrolleyDrivers", DriverModelService.getAllFreeDriversOfTransport("trolley"));
			
			request.setAttribute("busRoutes", RouteModelService.getRoutesByTransportType("bus"));
			request.setAttribute("tramRoutes", RouteModelService.getRoutesByTransportType("tram"));
			request.setAttribute("trolleyRoutes", RouteModelService.getRoutesByTransportType("trolley"));
			
			request.setAttribute("financeOperations", FinanceOperationModelService.getAllFinanceOperations());
			request.setAttribute("drivers", DriverModelService.getAllDrivers());
			request.setAttribute("transports", TransportModelService.getAllTransport());
			request.setAttribute("users", UserModelService.getAllUsers());
			dispatcher = context.getRequestDispatcher("/pages/user_pages/admin_page.jsp");
		} else if (request.getSession().getAttribute("role").equals("user")) {
			
			List<RouteModel> routes = RouteModelService.getAllRoutes();
			for(RouteModel route : routes)
				route.setStations(RouteStationsModelService.getStationListByRouteId(route.getId()).getStations());	
			
			UserModel u = UserModelService.getUserByLogin((String)request.getSession().getAttribute("login"));		
			request.setAttribute("user",u);
			request.setAttribute("routes", routes);
			request.setAttribute("routeStationLists", RouteStationsModelService.getAllStationLists());
			dispatcher = context.getRequestDispatcher("/pages/user_pages/user_page.jsp");
		} else if (request.getSession().getAttribute("role").equals("commander")) {
			
			List<RouteModel> routes = RouteModelService.getAllRoutes();
			for(RouteModel route : routes)
				route.setStations(RouteStationsModelService.getStationListByRouteId(route.getId()).getStations());	
				
			request.setAttribute("financeOperations", FinanceOperationModelService.getAllFinanceOperations());
			request.setAttribute("routes", routes);
			request.setAttribute("stations", StationModelService.getAllStations());
			request.setAttribute("users", UserModelService.getUsersByRole("admin"));
			dispatcher = context.getRequestDispatcher("/pages/user_pages/commander_page.jsp");
		}
		try {
			request.setAttribute("messages", MessageModelService.getMessageByReceiverLogin((String) request.getSession().getAttribute("login")));
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOG.warn("Dispatcher exception" );
		}
	}
}
