package com.example.provajfx;

import java.util.*;

public class Vaccinazioni {
	
	private int codice_paziente;
	private Segnalazioni segnalazioni;
	private String vaccino;
	private String dose;
	private String sede;
	private Date dataVaccinazione;


	public Vaccinazioni(String vaccino, String dose, String sede, Date dataVaccino) {
		this.sede = sede;

		Calendar cal = Calendar.getInstance();		// andro a comparare la data attuale con la data attuale -3 min
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, +2);				// sottraggo 3 minuti
		Date dateBefore1Days = cal.getTime();
		cal.add(Calendar.MONTH, -2);
		Date dataBefore2Month = cal.getTime(); // per il controllo che non sia piu vecchio di 2 mesi
		if(dataVaccino.before(dateBefore1Days) && dataVaccino.after(dataBefore2Month))	// tecnicamente il new Date prende la data attuale
			this.dataVaccinazione = dataVaccino;
		else {
			System.out.println(dataVaccino.toString() + dateBefore1Days.toString());
			throw new IllegalArgumentException("Vaccino piu vecchio di 2 mesi oppure data non valida");
		}
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
	public Date getData() {
		return this.dataVaccinazione;
	}
	
}