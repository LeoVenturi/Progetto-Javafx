package com.example.provajfx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Farmacologo extends Accessi{
	private ArrayList<Medico> medici = new ArrayList<>();
	static boolean segnale = false;		// messa a static in modo che tutti i farmacologi abbiano lo stesso attributo
	private Map<String, Integer> num_segnalazioni = new HashMap<>();
	private Map<String, Integer> num_segnalazioni_provincia = new TreeMap<>();
	private Map<String, Integer> num_segnalazioni_sede = new HashMap<>();
	private int segnalazioni_gravi_tot = 0;
	
	public Farmacologo(String pass, String nomeUtente, ArrayList<Medico> medici) {
		super(pass, nomeUtente);
		this.medici = medici;
		
	}
	
	static void mandaSegnale() {		// diventato metodo di classe, applicabile a 
		Farmacologo.segnale = true;		// qualunque istanza di farmacologo, non invocato 
	}									// su qualcuno di preciso, usato in "ControllerAccesso riga 86"
	
	static void deleteSegnale() {
		Farmacologo.segnale = false;
	}
	public boolean find_utente(String user, String password) {
		return super.findMed_Username(user, password);
		
	}
	
	public void riempimento() {
		//segnalazioni per vaccino
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				ArrayList<Vaccinazioni> vaccini = new ArrayList<>();
				vaccini = paziente.getVaccino();
				for(Vaccinazioni vaccino: vaccini) {
					String vax = vaccino.getVaccino();
					Segnalazioni segnalazione = vaccino.getSegnalazione();
					ReazioneAvversa reazione = segnalazione.getReazione();
																				//segnalazioni gravi
					if(reazione.getLivello() == 5 || reazione.getLivello() == 4 || reazione.getLivello() == 3)
						segnalazioni_gravi_tot ++;
																				//segnalazioni per vaccino
					if(num_segnalazioni.containsKey(vax)) {
						int num = num_segnalazioni.get(vax);
						num ++;
						num_segnalazioni.put(vax, num);
					}
					else
						num_segnalazioni.put(vax, 1);
					
					if(num_segnalazioni_sede.containsKey(vaccino.getSede())) {
						int num = num_segnalazioni_sede.get(vaccino.getSede());
						num ++;
						num_segnalazioni_sede.put(vaccino.getSede(), num);
					}
					else
						num_segnalazioni_sede.put(vaccino.getSede(), 1);
						
				}
																				//segnalazioni per prvincia
				if(num_segnalazioni_provincia.containsKey(paziente.getProvincia())) {
					int num = num_segnalazioni_provincia.get(paziente.getProvincia());
					num ++;
					num_segnalazioni_provincia.put(paziente.getProvincia(), num);
				}
				else
					num_segnalazioni_provincia.put(paziente.getProvincia(), 1);
					
			}
		}
		
	}
	public void azzera() {
		for(String temp: num_segnalazioni.keySet())
			num_segnalazioni.put(temp, 0);
		
		segnalazioni_gravi_tot = 0;
		
		for(String temp: num_segnalazioni_provincia.keySet())
			num_segnalazioni_provincia.put(temp, 0);
		
		for(String temp: num_segnalazioni_sede.keySet())
			num_segnalazioni_sede.put(temp, 0);
	}
	
	public String toString() {
		azzera();
		riempimento();
		String result = "Segnalazioni per vaccino: \n";
		//segnalazioni per vaccino
		for(String temp: num_segnalazioni.keySet())
			result += temp + " = " + num_segnalazioni.get(temp) + "\n";
		
		//segnalazioni gravi in settimana
		result += "Numero di segnalazioni gravi in settimana = " + segnalazioni_gravi_tot + "\n";
		
		//segnalazioni gravi per provincia
		for(String temp: num_segnalazioni_provincia.keySet())
			result += temp + " = " + num_segnalazioni_provincia.get(temp) + "\n";
		
		//segnalazioni gravi per sede
		for(String temp: num_segnalazioni_sede.keySet())
			result += temp + " = " + num_segnalazioni_sede.get(temp) + "\n";
		
		return result;
		
	}
	
	

}