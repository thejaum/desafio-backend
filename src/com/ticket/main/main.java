package com.ticket.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

import com.ticket.util.GsonUTCDateAdapter;
import com.ticket.model.Ticket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Teste.");
		final String path = "C:\\Users\\B4ltz\\Documents\\Dev\\desafio-backend\\tickets.json";
		try {
			BufferedReader in = new BufferedReader(
						   new InputStreamReader(
				                      new FileInputStream(path), "UTF8"));  
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
			builder.disableHtmlEscaping();
			Gson gson2 = builder.create();
			Object json = gson2.fromJson(in, Object.class);
			System.out.println(json.toString());
			String jsonString = gson2.toJson(json);
			Type collectionType = new TypeToken<Collection<Ticket>>(){}.getType();
			Collection<Ticket> tickets = gson2.fromJson(jsonString, collectionType);
			System.out.println("JSON Parsed.");
			
			/*for (Ticket t : tickets) {
				//Tickets
				System.out.println(t.getTicketID());
				//Size of interactions
				System.out.println(t.getInteractions().size());
				for(Interactions i : t.getInteractions()) {
					System.out.println(i .getSubject());
				}
			}*/
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
