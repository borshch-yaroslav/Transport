package com.epam.borshch.transport.frontcontroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.borshch.transport.frontcontroller.commands.FrontCommand;
import com.epam.borshch.transport.frontcontroller.commands.MainDispatchCommand;

/**
 * FrontServlet - single servlet in program. Basement of "Front Controller" Design Pattern
 * implementation.
 * 
 * Gets specific FrontCommand class name, composed from projected package structure
 * of Project and Parameter "command", gathered from request.
 * 
 * If command is undefined - calls MainDispatchCommand, to identify further behavior.
 * 
 * Then calls process() method of chosen FrontCommand
 * 
 * @author Slavko
 *
 */

public class FrontServlet extends HttpServlet {
	
	private static final Logger LOG = Logger.getLogger(FrontServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FrontCommand command = null;
		command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private FrontCommand getCommand(HttpServletRequest request) {
		try {
			return (FrontCommand) getCommandClass(request).newInstance();
		} catch (Exception e) {
			LOG.warn("Front Servlet's getCommand(HttpServletRequest request) ExceptioN!" );
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	private Class getCommandClass(HttpServletRequest request) {
		Class result;

		final String commandClassName = "com.epam.borshch.transport" + ".frontcontroller.commands."
				+ (String) request.getParameter("command") + "Command";

		try {
			result = Class.forName(commandClassName);
		} catch (ClassNotFoundException e) {
			result = MainDispatchCommand.class;
		}
		return result;
	}
	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("Log4JInitServlet is initializing log4j");
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File isExistsFile = new File(log4jProp);
			if (isExistsFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}
}
