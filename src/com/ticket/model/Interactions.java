package com.baltz.model;

import java.util.Calendar;
import java.util.Date;

public class Interactions {
	private String Subject;
	private String Message;
	private Date DateCreate;
	private String Sender;
	
	public Date getDateCreate() {
		return DateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		DateCreate = dateCreate;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
}
