package com.ticket.engine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ticket.model.Ticket;

public class SortManager {

	/*@
	 * Ordena os tickets pela data de Criação
	@*/
	public void sortByCreateDate(List<Ticket> ltickets,int flagSort){
		Collections.sort(ltickets, new Comparator<Ticket>(){
		     public int compare(Ticket o1, Ticket o2){
		         if(o1.getDateCreate().getTime() == o2.getDateCreate().getTime())
		             return 0;
		         if (flagSort == 0){
		        	 return o1.getDateCreate().getTime() < o2.getDateCreate().getTime() ? -1 : 1;
		         }else{
		        	 return o1.getDateCreate().getTime() > o2.getDateCreate().getTime() ? -1 : 1;
		         }
		     }
		});
	}
	
	/*@
	 * Ordena os tickets pela data de Atualização
	@*/
	public void sortByUpdateDate(List<Ticket> ltickets,int flagSort){
		Collections.sort(ltickets, new Comparator<Ticket>(){
		     public int compare(Ticket o1, Ticket o2){
		         if(o1.getDateUpdate().getTime() == o2.getDateUpdate().getTime())
		             return 0;
		         if (flagSort == 0){
		        	 return o1.getDateUpdate().getTime() < o2.getDateUpdate().getTime() ? -1 : 1; 
		         }else{
		        	 return o1.getDateUpdate().getTime() > o2.getDateUpdate().getTime() ? -1 : 1;
		         }
		     }
		});
	}
	
	/*@
	 * Ordena os tickets pela prioridade
	@*/
	public void sortByPriority(List<Ticket> ltickets){
		Collections.sort(ltickets, new Comparator<Ticket>(){
		     public int compare(Ticket o1, Ticket o2){
		         if(o1.getPriority().equals(o2.getPriority()))
		             return 0;
		        return o1.getPriority() != o2.getPriority() ? -1 : 1; 
		         
		     }
		});
	}
	
}
