package com.epam.borshch.transport.db.model;

public class MessageModel {

	Integer id;
	String senderLogin;
	String receiverLogin;
	String type;
	String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenderLogin() {
		return senderLogin;
	}

	public void setSenderLogin(String senderLogin) {
		this.senderLogin = senderLogin;
	}

	public String getReceiverLogin() {
		return receiverLogin;
	}

	public void setReceiverLogin(String receiverLogin) {
		this.receiverLogin = receiverLogin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}