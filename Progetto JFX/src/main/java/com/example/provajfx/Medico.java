package com.example.provajfx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medico {
	private ArrayList<Paziente> lista_pazienti = new ArrayList<Paziente>();
	private Map<String,String> utenti = new HashMap<>();	// utente + password


	
	public Medico(String pass, String nomeUtente) {
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
