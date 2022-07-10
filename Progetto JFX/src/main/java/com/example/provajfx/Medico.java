package com.example.provajfx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Medico {
	private ArrayList<Paziente> lista_pazienti = new ArrayList<Paziente>();
//	private String Med_Username[] = {"M000", "M001", "M002"};
//	private String Med_Password[] = {"AAAA", "BBBB", "CCCC"};
	private Map<String,String> utenti = new HashMap<>();	// utente + password
	private int Farmacologo[] = {0, 0, 1};
	//private List<Integer> Medico_CodiciPazienti = new ArrayList<Integer>();
	private List <Paziente> pazienti = new ArrayList<>();
	
	
//	public int findMed_Username(String i) {
//		int c;
//		for (c = 0; c < Med_Username.length; c++)
//			if (i == Med_Username[c])
//				break;
//		return c;
//	}
	private void addMedico(String user, String pass) {	//aggiungere meedico, se non presente
		if(!utenti.containsKey(user))					// se non presente l'utente 
			utenti.put(user, pass);					// se presente non dovrebbe
		
		
	}
	public boolean findMed_Username(String username, String password) {	// ricerca nel map, se trova ritorna 
	//per essere sicuri che ci siano 
		utenti.put("1", "1");
		utenti.put("alberto", "alberto");
		
		for(Entry<String, String> utente: utenti.entrySet())	{		// true, altrimente ritornera false
			if(utente.getValue().compareTo(username) == 0 && utente.getKey().compareTo(password) == 0) {
				return true;
			}}
		return false;
		
	}
	
//	public String getMed_Username(String i) {
//		for(int Med = 0; Med < Med_Username.length; Med++)
//			if(Med_Username[Med] == i)
//				return Med_Username[Med];
//		return null;
//	}
	
//	public String getMed_Password(int i) {
//		return Med_Password[i];
//	}
//	
//	public int getFarmacologo(String i) {
//		for(int Med = 0; Med < Med_Username.length; Med++)
//			if(Med_Username[Med] == i)
//				return Farmacologo[Med];
//		return -1;
//	}
	
//	public void addMedico_CodiciPazienti(int i) {
//		Medico_CodiciPazienti.add(i);
//	}
//	
//	public int getMedico_CodiciPazienti(int i) {
//		return Medico_CodiciPazienti.get(i);
//	}
}
