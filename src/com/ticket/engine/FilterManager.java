package com.ticket.engine;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.ticket.model.Ticket;

public class FilterManager {

	/*@
	 * Filtra e retorna uma lista apenas com Tickets da prioridade desejada;
	@*/
	public List<Ticket> filterByPriority(List<Ticket> tickets, String priority){
		List<Ticket> lt = tickets.stream().filter(p -> p.getPriority().equals(priority)).collect(Collectors.toList());
		return lt;
	}
	
	/*@
	 * Filtra e retorna uma lista com os tickets com data de criação no range informado 
	@*/
	public List<Ticket> filterByCreateDate(List<Ticket> tickets,Date start,Date end){		
		List<Ticket> lt = tickets.stream().filter(dates -> dates.getDateCreate().after(start) && dates.getDateCreate().before(end)
				).collect(Collectors.toList());
		return lt;
	}
}
