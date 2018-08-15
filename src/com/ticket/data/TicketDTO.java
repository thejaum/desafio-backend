package com.ticket.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ticket.model.Ticket;

public class TicketDTO {
	private List<Ticket> tickets;
	private Map<String, Integer> regexData = new HashMap<String, Integer>();
	private long avrScore;

	public long getAvrScore() {
		return avrScore;
	}

	public void setAvrScore(long avrScore) {
		this.avrScore = avrScore;
	}

	public TicketDTO(List<Ticket> Tickets){
		this.setTickets(Tickets);
		defRegex();
		averageScore();
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Map<String, Integer> getRegexData() {
		return regexData;
	}

	public void setRegexData (Map<String, Integer> regexData) {
		this.regexData = regexData;
	}

	
	public long averageDuration(){
		long total=0;
		for (Ticket t : this.getTickets()) {
			total += t.diffDays();
		}
		long media = total / this.getTickets().size();
		return media;
	}
	public void defRegex(){
		this.regexData.put("pedido", 5);
		this.regexData.put("prazo", 5);
		this.regexData.put("esperando", 5);
		this.regexData.put("infeliz", 5);
		this.regexData.put("insatisfeito", 10);
		this.regexData.put("reembolso", 10);
		this.regexData.put("procon", 10);
		this.regexData.put("reclameaqui", 10);
		this.regexData.put("reclame aqui", 10);
	}
	
	public void averageScore(){
		long total=0;
		for (Ticket t : this.getTickets()) {
			total += t.getScore();
		}
		this.avrScore = total / this.getTickets().size();
	}
}
