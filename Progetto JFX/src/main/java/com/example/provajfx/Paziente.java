package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Paziente {

		private int codice;
		private Date anno;
		private String provincia;
		private String professione;
		private ArrayList<FattoreRischio> fattori = new ArrayList<>();
		private ArrayList<Vaccinazioni> vaccini = new ArrayList<Vaccinazioni>();
		private  ArrayList<Segnalazioni> segnalazioni = new ArrayList<>();
		private static int codice_assegnato = 0;
		private static String provincie[] = {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT",
				"AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL",
				"CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM",
				"FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE",
				"LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB",
				"NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE",
				"PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "RM",
				"RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN",
				"TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT"};
		private ArrayList<String> Provincie_esistenti = new ArrayList<String>(Arrays.asList(provincie));


	public Paziente(Date anno, String provincia, String professione, ArrayList<FattoreRischio> fattori_rischio, ArrayList<Vaccinazioni> vaccinazioni) {
		//aggiunta codice univoco paziente
		this.codice = codice_assegnato;
		codice_assegnato ++;

		Calendar cal = Calendar.getInstance();		// andro a comparare la data attuale con la data attuale -3 min
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, -3);		// sottraggo 3 minuti
		Date dateBefore1Days = cal.getTime();
		//aggiunta anno di nascita
		if(!anno.after(dateBefore1Days))	// tecnicamente il new Date prende la data attuale
			this.anno = anno;
		else
			throw new IllegalArgumentException();

		//aggiunta provincia
		if(Provincie_esistenti.contains(provincia))
			this.provincia = provincia;
		else
			throw new IllegalArgumentException();

		//aggiunta prefessione
		this.professione = professione;

		//aggiunta fattori a rischio
		this.fattori = fattori_rischio;

		//aggiunta vaccinazioni
		this.vaccini = vaccinazioni;

	}
		
		public ArrayList<Vaccinazioni> getVaccino(){
			return this.vaccini;
		}
		
		public String getProvincia() {
			return this.provincia;
		}

		public int getCodice() {
			return this.codice;
		}
		
		public String toString() {
			return this.codice +", " +this.professione;
		}
		
		public void addSegnalazione (Segnalazioni segnalazione) {
			segnalazioni.add(segnalazione);
		}

		public ArrayList<Segnalazioni> getSegnalazioni(){
			return this.segnalazioni;
		}

	public String stampaSegnalazioni() {
		String acc = "";
		for(Segnalazioni i : segnalazioni)
			acc += i + " " + "\n";
		return acc;
	}
	}