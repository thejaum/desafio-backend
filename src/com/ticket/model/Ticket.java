package com.ticket.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ticket.model.Interactions;

public class Ticket {
	private int TicketID;
	private int CategoryID;
	private int CustomerID;
	private String CustomerName;
	private String CustomerEmail;
	private Date DateCreate;
	private Date DateUpdate;
	private ArrayList<Interactions> Interactions = new ArrayList<Interactions>();
	private int Score;
	private String Priority;
	
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
	public Date getDateCreate() {
		return DateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		DateCreate = dateCreate;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	
	public void addScore(int score) {
		this.setScore(this.getScore() + score);
	}
	
	public void subScore(int score) {
		this.setScore(this.getScore() - score);
	}
	
	public long diffDays(){
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		d1.setTime(this.getDateCreate());
		d2.setTime(this.getDateUpdate());
		long daysBetween = ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
		return daysBetween;
	}
	
}
