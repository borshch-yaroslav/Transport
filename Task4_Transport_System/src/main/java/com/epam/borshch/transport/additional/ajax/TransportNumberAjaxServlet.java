package com.epam.borshch.transport.additional.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.borshch.transport.db.model.RouteModel;
import com.epam.borshch.transport.db.service.RouteModelService;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/TransportNumberAjaxServlet" })
public class TransportNumberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportNumberAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		List<RouteModel> routes = RouteModelService.getRoutesByTransportType(request.getParameter("type"));  
		for(RouteModel route : routes){
			if(route.getRouteNumber().toString().equals(request.getParameter("number"))){
				out.print(request.getParameter("type") + " with this number already exists.");
				break;
			}
			else out.print("");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
