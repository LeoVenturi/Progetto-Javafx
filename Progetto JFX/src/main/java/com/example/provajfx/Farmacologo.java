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
	
	public Farmacologo(String pass, String nomeUtente) {
		super(pass, nomeUtente);
		
	}
	public void prendiMedici(ArrayList<Medico> l1) {
		this.medici = l1;
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
	public String SegnalazioniGravi() {
		segnalazioni_gravi_tot = 0;
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
					if(segnalazione.getReazione().getLivello() > 2 )
						segnalazioni_gravi_tot ++;
				}
			}
		}
		String result = "";
		return result += "\n Numero di segnalazioni gravi in settimana = " + segnalazioni_gravi_tot + "\n";
	}
	
	public String SegnalazioneVaccino() {
		AzzeraSegnalazioni();
		String result = "\n Segnalazioni per vaccino: \n";
		
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				int num = 0;
				for(Segnalazioni segnalazione: paziente.getSegnalazioni())
					num++;
				for(Vaccinazioni vaccini: paziente.getVaccino()) {
					if(num_segnalazioni.containsKey(vaccini.getVaccino())) {
						int temp = num_segnalazioni.get(vaccini.getVaccino());
						num_segnalazioni.put(vaccini.getVaccino(), temp + num);		
					}
					else
						num_segnalazioni.put(vaccini.getVaccino(), num);
				}
			}
		}
		
		for(String temp: num_segnalazioni.keySet())
			result += temp + " = " + num_segnalazioni.get(temp) + "\n";
		return result;
	}
	
	public String SegnalazioniSede(){
		AzzeraSedi();
		String result = "\n Segnalazioni per sede: \n";
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				int num = 0;
				for(Segnalazioni segnalazione: paziente.getSegnalazioni())
					num++;
				for(Vaccinazioni vaccini: paziente.getVaccino()) {
					if(num_segnalazioni_sede.containsKey(vaccini.getSede())) {
						int temp = num_segnalazioni_sede.get(vaccini.getSede());
						num_segnalazioni_sede.put(vaccini.getSede(), num + temp);
					}
					else
						num_segnalazioni_sede.put(vaccini.getSede(), num);
				}
			}
		}
		for(String temp: num_segnalazioni_sede.keySet())
			result += temp + " = " + num_segnalazioni_sede.get(temp) + "\n";
		
		return result;
	}
	
	public String SegnalazioniProvincia() {
		AzzeraProvincie();
		String result = "Segnalazioni per provincia: \n";
	
		//segnalazioni per vaccino
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
													
				if(num_segnalazioni_provincia.containsKey(paziente.getProvincia())) {
					int num = num_segnalazioni_provincia.get(paziente.getProvincia());
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						num++;
					}
					num_segnalazioni_provincia.put(paziente.getProvincia(), num);
				}
				else {
					int num = 0;
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						num++;
					}
					num_segnalazioni_provincia.put(paziente.getProvincia(), num);
					
				}
					
					
			}
		}
		for(String provincia: num_segnalazioni_provincia.keySet())
			result += provincia  + " = " + num_segnalazioni_provincia.get(provincia) + "\n";
		
		return result;
		
	}
	
	public void AzzeraSegnalazioni() {
		for(String temp: num_segnalazioni.keySet())
			num_segnalazioni.put(temp, 0);
	}
	public void AzzeraProvincie() {
		for(String temp: num_segnalazioni_provincia.keySet())
			num_segnalazioni_provincia.put(temp, 0);
		
	}
	
	public void AzzeraSedi() {
		for(String temp: num_segnalazioni_sede.keySet())
			num_segnalazioni_sede.put(temp, 0);
		
	}
	
	public String toString() {
		String result = SegnalazioniGravi() + SegnalazioneVaccino() + SegnalazioniSede() + SegnalazioniProvincia();
		return result;
	}
	
	
	
	

}