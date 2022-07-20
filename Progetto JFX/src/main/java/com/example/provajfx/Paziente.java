package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;

public class Paziente {

		private int codice;
		private int anno;
		private String provincia;
		private String professione;
		private ArrayList<FattoreRischio> fattori = new ArrayList<>();
		ArrayList<Vaccinazioni> vaccini = new ArrayList<Vaccinazioni>();
		ArrayList<Segnalazioni> segnalazioni = new ArrayList<>();
		private static int codice_assegnato = 0;
		private static String Provincie[] = {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT",
				"AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL",
				"CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM",
				"FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE",
				"LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB",
				"NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE",
				"PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "RM",
				"RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN",
				"TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT"};
		ArrayList<String> Provincie_esistenti = new ArrayList<String>(Arrays.asList(Provincie));


		public Paziente(int anno, String provincia, String professione, ArrayList<FattoreRischio> fattori_rischio, ArrayList<Vaccinazioni> vaccinazioni) {
			//aggiunta codice univoco paziente
			this.codice = codice_assegnato;
			codice_assegnato ++;

			//aggiunta anno di nascita
			if(anno > 2022)
				throw new IllegalArgumentException();
			else
				this.anno = anno;

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
		
		


	}