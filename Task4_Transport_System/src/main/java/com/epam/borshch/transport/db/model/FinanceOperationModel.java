package com.epam.borshch.transport.db.model;

public class FinanceOperationModel {

	Integer id;
	String description;
	Integer financeChange;
	String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFinanceChange() {
		return financeChange;
	}
	public void setFinanceChange(Integer finance_change) {
		this.financeChange = finance_change;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
