package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.service.RouteModelService;
import com.epam.borshch.transport.db.service.RouteStationsModelService;
import com.epam.borshch.transport.db.service.StationModelService;

/**
 * MainPageCommand - extends FrontCommand.
 * 
 * + forwards on main page.
 *
 * @author Slavko
 *
 */

public class MapWithAllRoutesCommand extends FrontCommand {


	@Override
	public void process() throws ServletException, IOException {
		
		List<RouteModel> routes = RouteModelService.getAllRoutes();
		
		for(int i =0; i<routes.size(); i++){
			routes.get(i).setStations(RouteStationsModelService.getStationListByRouteId(routes.get(i).getId()).getStations());
			routes.get(i).setNum(i);
			for(String str : routes.get(i).getStations()){
				if(str.equals(" "))
					break;
				double x = StationModelService.getStationBystationName(str).getLatitude();
				double y = StationModelService.getStationBystationName(str).getLongtitude();
				routes.get(i).addCoordinate(new double[]{x,y});
			}
		}
		
		request.setAttribute("routes", routes);
		forward("/pages/market_pages/ready_routes.jsp");
	}
}
