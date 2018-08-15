package com.ticket.engine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.ticket.data.TicketDTO;
import com.ticket.model.Interactions;
import com.ticket.model.Ticket;

public class ScoreManager {
	
	/*@
	 * Verifica se ultima interação foi do Expert ou do Costumer;
	@*/
	public void checkLastInteraction(List<Ticket> tickets){
		String sender="";
		for (Ticket ticket : tickets) {
			for(Interactions i : ticket.getInteractions()) {
				sender = i.getSender();
			}
			if(sender.equals("Costumer")) {
				ticket.addScore(5);
			}
		}
	}
	
	/*@
	 * Verifica se o tempo de duração dos tickets esta abaixo ou acima da média.
	@*/
	public void checkDaysBetween(List<Ticket> tickets){
		TicketDTO tdto = new TicketDTO(tickets); 
		long media = tdto.averageDuration();
		System.out.println("Media de duração dos tickets : "+media);
		for (Ticket ticket : tickets){
			if (ticket.diffDays() > media){
				ticket.addScore(5);
			}
		}
	}
	
	/*@
	 * Verifica se a(s) interações do ticket contém uma palavra chave e adiciona um valor X ao Score.
	@*/
	public void checkInteractions(List<Ticket> tickets){
		TicketDTO tdto = new TicketDTO(tickets);
		for(Ticket ticket : tickets){
			for (Map.Entry<String, Integer> entry : tdto.getRegexData().entrySet()){
	            String key = entry.getKey();
	            Integer value = entry.getValue();
	            for(Interactions i : ticket.getInteractions()){
					if(i.checkMessage(key)){
						ticket.addScore(value);
						break;
					}
				}
	        }
			
		}
	}
	 
	/*@
	 * Analisa se o Score do Ticket esta abaixo da média(Normal) ou acima (Alta);
	@*/
	public void priorityChecker(List<Ticket> tickets){
		TicketDTO tdto = new TicketDTO(tickets);
		for (Ticket ticket : tickets){
			if (ticket.getScore() < tdto.getAvrScore()){
				ticket.setPriority("Normal");
			}else{
				ticket.setPriority("Alta");
			}
		}
	}
	
}
