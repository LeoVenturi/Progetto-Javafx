package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;

public class Paziente {

	ArrayList<Integer> Paz_Codice = new ArrayList<Integer>();
	ArrayList<Integer> Paz_AnnoNascita = new ArrayList<Integer>();
	ArrayList<String> Paz_Provincia = new ArrayList<String>();
	ArrayList<String> Paz_Professione = new ArrayList<String>();
	ArrayList<ArrayList<String>> Paz_FattoreRischio = new ArrayList<ArrayList<String>>();
	//	ArrayList<String> array_fattore = new ArrayList<String>();
	ArrayList<ArrayList<String>> Descrizione_fattore = new ArrayList<ArrayList<String>>();
	//	ArrayList<String> array_descrizione = new ArrayList<String>();
	ArrayList<ArrayList<Integer>> Livello_fattore = new ArrayList<ArrayList<Integer>>();
	//	ArrayList<String> array_livello = new ArrayList<String>();
	ArrayList<Integer> Paz_NReazioni_Avverse = new ArrayList<Integer>();
	ArrayList<Integer> Paz_NVaccini = new ArrayList<Integer>();
	private int codice = 0;
	private String Provincie[] = {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT",
			"AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL",
			"CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM",
			"FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE",
			"LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB",
			"NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE",
			"PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "RM",
			"RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN",
			"TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT"};
	ArrayList<String> Provincie_esistenti = new ArrayList<String>(Arrays.asList(Provincie));
	Vaccinazioni vaccini;
	//int Paz_Codice[] = {000, 001, 002};
	//int Paz_AnnoNascita[] = {1999, 2000, 2001};
	//String Paz_Provincia[] = {"VR", "PD", "VR"};
	//String Paz_Professione[] = {"Meccanico", "Programmatore", "Studente"};
	//String Paz_CodiceFattoriRischio[] = {"100", "101", "102"};
	//int Paz_NReazioni_Avverse[] = {0, 0, 0};
	//int Paz_NVaccini[] = {1, 2, 3};

	public void add_info_paziente(int anno, String provincia, String professione, ArrayList<String> fattori_rischio, ArrayList<String> descrizione, ArrayList<Integer> livello) {
		//aggiunta codice univoco paziente
		Paz_Codice.add(codice);
		codice ++;

		//aggiunta anno di nascita
		if(anno > 2022)
			throw new IllegalArgumentException();
		else
			Paz_AnnoNascita.add(anno);

		//aggiunta provincia
		if(Provincie_esistenti.contains(provincia))
			Paz_Provincia.add(provincia);
		else
			throw new IllegalArgumentException();

		//aggiunta prefessione
		Paz_Professione.add(professione);

		//aggiunta fattori a rischio
		if(fattori_rischio == null)
			throw new IllegalArgumentException();
		else
			Paz_FattoreRischio.add(fattori_rischio);

		//aggiunta descrizione
		if(descrizione == null || descrizione.size() != fattori_rischio.size())
			throw new IllegalArgumentException();
		else
			Descrizione_fattore.add(descrizione);

		//aggiunta livello
		if(livello == null || livello.size() != fattori_rischio.size())
			throw new IllegalArgumentException();
		else
			Livello_fattore.add(livello);


	}

	public int getPos(int codice) {
		if(Paz_Codice.contains(codice)) {
			int pos;
			pos = Paz_Codice.indexOf(codice);
			return pos;
		}
		else
			throw new IllegalArgumentException();
	}
	public int esiste_paziente(int codice) {
		if(Paz_Codice.contains(codice))
			return 1;
		else
			return 0;
	}

	public int getPaz_AnnoNascita(int codice) {
		int pos = getPos(codice);
		return Paz_AnnoNascita.get(pos);

	}

	public String getPaz_Provincia(int codice) {
		int pos = getPos(codice);
		return Paz_Provincia.get(pos);

	}

	public String getPaz_Professione(int codice) {
		int pos = getPos(codice);
		return Paz_Professione.get(pos);
	}

	public ArrayList getPaz_CodiceFattoriRischio(int codice) {
		int pos = getPos(codice);
		return Paz_FattoreRischio.get(pos);

	}

//	public int getPaz_NReazioni_Avverse(int i) {
//		return Paz_NReazioni_Avverse[i];
//	}

//	public int getPaz_NVaccini(int i) {
//		return Paz_NVaccini[i];
//	}
}