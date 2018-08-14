package com.baltz.model;

import java.util.ArrayList;
import java.util.Date;
import com.baltz.model.Interactions;

public class Ticket {
	private int TicketID;
	private int CategoryID;
	private int CustomerID;
	private String CustomerName;
	private String CustomerEmail;
	private Date DateCreate;
	private Date DateUpdate;
	private ArrayList<Interactions> Interactions = new ArrayList<Interactions>();
	 
	public ArrayList<Interactions> getInteractions() {
		return Interactions;
	}
	public void setInteractions(ArrayList<Interactions> interactions) {
		Interactions = interactions;
	}
	public int getTicketID() {
		return TicketID;
	}
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public Date getDateUpdate() {
		return DateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		DateUpdate = dateUpdate;
	}
}
