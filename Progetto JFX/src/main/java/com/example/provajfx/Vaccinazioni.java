package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
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
	private String data_vaccinazione;


	public Vaccinazioni(String vaccino, String dose, String sede, String data) {

		if(vaccini_possibili.contains(vaccino))
			this.vaccino = vaccino;
		else
			throw new IllegalArgumentException();

		if(dosi_possibili.contains(dose))
			this.dose  = dose;
		else
			throw new IllegalArgumentException();

		this.sede = sede;

		//aggiungere controll ovalidità anno
		this.data_vaccinazione = data;


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