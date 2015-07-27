package com.epam.borshch.transport.db.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.borshch.transport.db.dao.MessageModelDAO;
import com.epam.borshch.transport.db.model.MessageModel;

/**
 * MessageModelService.
 * 
 * + calls methods of analogical DAO.
 * 
 * @author Slavko
 *
 */

public class MessageModelService {

	public static List<MessageModel> getAllMessages() {
		try {
			return MessageModelDAO.getAllMessages();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception int MessageModelService in getAllMessages()");
			return null;
		}
	}
	
	public static void removeMessageById(Integer id){
		try {
			MessageModelDAO.removeMessageById(id);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception in MessageModelService in removeMessageById()");
		}
	}
	
	public static MessageModel getMessageById(Integer id){
		try {
			return MessageModelDAO.getMessageById(id);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception in MessageModelService in getMessageById()");
			return null;
		}
	}
	
	public static List<MessageModel> getMessageByReceiverLogin(String receiverLogin){
		try {
			return MessageModelDAO.getMessagesByReceiverLogin(receiverLogin);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception in MessageModelService in getMessageByReceiverLogin()");
			return null;
		}
	}

	public static void insert(String sender_login, String receiver_login, String type, String message){
		try {
			MessageModelDAO.insert(sender_login, receiver_login, type, message);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception int MessageModelService in insert.");
		}
	}
	
	public static void modifyReceiverLogin(String whereValue, String newValue){
		try {
			MessageModelDAO.modifyReceiverLogin(whereValue, newValue);
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println("Exception int MessageModelService in modify.");
		}
	}
}
