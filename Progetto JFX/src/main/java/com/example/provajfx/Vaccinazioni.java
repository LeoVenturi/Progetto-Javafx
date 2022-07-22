package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Vaccinazioni {
	
	private int codice_paziente;
	private Segnalazioni segnalazioni;
	private String vaccino;
	private String vaccini[] = {"AstraZeneca", "Pfizer", "Moderna", "Sputnik", "Sinovac", "Antinfluenzale"};
	private ArrayList<String> vaccini_possibili = new ArrayList<String>(Arrays.asList(vaccini));
	private String dose;
	private String dosi[] = {"I", "II", "III", "IV", "Dose Unica"};
	private ArrayList<String> dosi_possibili = new ArrayList<String>(Arrays.asList(dosi));
	private String sede;
	private Date dataVaccinazione;


	public Vaccinazioni(String vaccino, String dose, String sede, Date dataVaccino) {

		if(vaccini_possibili.contains(vaccino))
			this.vaccino = vaccino;
		else
			throw new IllegalArgumentException();

		if(dosi_possibili.contains(dose))
			this.dose  = dose;
		else
			throw new IllegalArgumentException();

		this.sede = sede;

		Calendar cal = Calendar.getInstance();		// andro a comparare la data attuale con la data attuale -3 min
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, -3);				// sottraggo 3 minuti 
		Date dateBefore1Days = cal.getTime();
		Date dataBefore2Month = cal.getTime();		// per il controllo che non sia piu vecchio di 2 mesi
		
		if(dataVaccino.after(dateBefore1Days) || dataVaccino.before(dataBefore2Month))	// tecnicamente il new Date prende la data attuale
			this.dataVaccinazione = dataVaccino;
		else
			throw new IllegalArgumentException("Vaccino piu vecchio di 2 mesi oppure data non valida");

	}
	public String getVaccino() {
		return this.vaccino;
	}
	public Segnalazioni getSegnalazione() {
		return this.segnalazioni;
	}
	
	public String getSede() {
		return this.sede;
	}
}