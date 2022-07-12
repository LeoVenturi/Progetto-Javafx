package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Vaccinazioni {
	
	private int codice_paziente;
	private Segnalazioni segnalazioni;
	private String vaccino;
	private String vaccini[] = {"AstraZeneca", "Pfizer", "Moderna", "Sputnik", "Sinovac", "antinfluenzale"};
	private ArrayList<String> vaccini_possibili = new ArrayList<String>(Arrays.asList(vaccini));
	private String dose;
	private String dosi[] = {"I", "II", "III", "IV", "dose unica"};
	private ArrayList<String> dosi_possibili = new ArrayList<String>(Arrays.asList(dosi));
	private String sede;
	private int anno_vaccinazione;
	
	

	
//	int Vaccinazioni_Codice[] = {};
//	int Vaccinazioni_CodicePaziente[] = {};
//	String Tipo_Vaccino[] = {};
//	int Vaccinazioni_NSomministrazione[] = {};
//	String Vaccinazioni_Sede[] = {};
//	String Vaccinazioni_Data[] = {};

	public Vaccinazioni(int codice, String vaccino, String dose, String sede, int anno) {

		this.codice_paziente = codice;


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
		this.anno_vaccinazione = anno;


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

//	public int getVaccinazioni_Codice(int i) {
//		return Vaccinazioni_Codice[i];
//	}
//
//	public int getVaccinazioni_CodicePaziente(int i) {
//		return Vaccinazioni_CodicePaziente[i];
//	}
//
//	public String getTipo_Vaccino(int i) {
//		return Tipo_Vaccino[i];
//	}
//
//	public int getVaccinazioni_NSomministrazione(int i) {
//		return Vaccinazioni_NSomministrazione[i];
//	}
//
//	public String getVaccinazioni_Sede(int i) {
//		return Vaccinazioni_Sede[i];
//	}
//
//	public String getVaccinazioni_Data(int i) {
//		return Vaccinazioni_Data[i];
//	}
}