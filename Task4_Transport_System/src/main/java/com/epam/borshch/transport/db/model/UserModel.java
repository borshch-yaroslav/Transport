package com.epam.borshch.transport.db.model;

public class UserModel {

	private String login;
	private String password;
	private String name;
	private String email;
	private String role;
	private String locale;
	
	private Integer busTickets;
	private Integer tramTickets;
	private Integer trolleyTickets;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Integer getBusTickets() {
		return busTickets;
	}

	public void setBusTickets(Integer busTickets) {
		this.busTickets = busTickets;
	}

	public Integer getTramTickets() {
		return tramTickets;
	}

	public void setTramTickets(Integer tramTickets) {
		this.tramTickets = tramTickets;
	}

	public Integer getTrolleyTickets() {
		return trolleyTickets;
	}

	public void setTrolleyTickets(Integer trolleyTickets) {
		this.trolleyTickets = trolleyTickets;
	}
	
	
}
