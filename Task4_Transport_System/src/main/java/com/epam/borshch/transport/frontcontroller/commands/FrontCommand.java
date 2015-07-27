package com.epam.borshch.transport.frontcontroller.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**FrontCommand - abstract class for extending and implementation of handlers of the requests
 * from FrontServlet according to "Front Controller" Design Pattern.
 * 
 * Aim: implementation of logic, due to current task, and then forwarding control to
 * .jsp program or to another Command.
 * 
 * Gets three attributes, important for handling servlet tasks:
 * + ServletContext, HttpServletRequest, HttpServletResponse.
 * 
 * Methods: + init() - prepare task for work;
 * 			+ process() - realization of concrete logic;
 * 			& forward() - delegation of program flow downstream.
 *
 * @author Slavko
 * 
 */

abstract public class FrontCommand{

	protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
 
    public void init(ServletContext context,
                     HttpServletRequest request,
                     HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
 
    abstract public void process() throws ServletException, IOException;
 
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}