package com.example.provajfx;

import java.util.HashMap;
import java.util.Map;

public abstract class Accessi {
	private Map<String,String> utenti = new HashMap<>();	// utente + password
	public Accessi(String pass, String nomeUtente) {
		if(pass == null && nomeUtente == null)
			throw new IllegalArgumentException();
		this.utenti.put(nomeUtente, pass);
		
	}
	
	public boolean findMed_Username(String username, String password) {	// ricerca nel map, se trova ritorna
			for(Map.Entry<String, String> utente: utenti.entrySet())	{		// true, altrimente ritornera false
				if(utente.getValue().compareTo(username) == 0 && utente.getKey().compareTo(password) == 0) {
					return true;
				}}
			return false;

	}
}
