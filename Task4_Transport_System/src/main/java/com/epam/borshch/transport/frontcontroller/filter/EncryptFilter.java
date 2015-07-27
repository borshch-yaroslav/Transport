package com.epam.borshch.transport.frontcontroller.filter;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * EncryptFilter.
 * 
 * + Encode requests to UTF-8;
 * 
 * + When password handler is in action - encode input password string with md5.
 *
 * @author Slavko
 *
 */


/**
 * Servlet Filter implementation class EncryptFilter
 */
public class EncryptFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public EncryptFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// ----------Validate UTF-8----------
		httpRequest.setCharacterEncoding("UTF-8");
				
		// ----------Encrypt Password---------
		if (request.getParameter("command") != null && request.getParameter("txtPassword") != null && request.getParameter("txtLogin") != null && (request.getParameter("command").equals("Register") || request.getParameter("command").equals("Login"))) {

			String inputPassword = request.getParameter("txtPassword");
			String login = request.getParameter("txtLogin");
			String encryptedPassword = encryptPassword(inputPassword, login);
			httpRequest.setAttribute("txtPassword", encryptedPassword);
		}
		chain.doFilter(request, response);
	}

	public static String encryptPassword(String password, String name) {

		StringBuffer encryptedLogin = new StringBuffer();
		StringBuffer encryptedPassword = new StringBuffer();
		String encryptedJoin = "";
		@SuppressWarnings("unused")
		String deEncryptedPassword = "";

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(name.getBytes());
			byte[] digest = md.digest();
			for (byte b : digest) {
				encryptedLogin.append(String.format("%02x", b & 0xff));
			}

			md.update(password.getBytes());
			digest = md.digest();
			for (byte b : digest) {
				encryptedPassword.append(String.format("%02x", b & 0xff));
			}

			encryptedJoin = encryptedPassword.toString() + encryptedLogin.toString();

			deEncryptedPassword = encryptedJoin.substring(0, 32);
			
			return encryptedJoin.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
