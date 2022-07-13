package com.example.provajfx;


import java.util.ArrayList;
import java.util.List;

public class Segnalazioni {

	public int codice;
	public Paziente paziente;
	public ReazioneAvversa reazione;
	public String data;
//	List<Integer> Segnalazioni_Codice = new ArrayList<Integer>();
//	List<Integer> Segnalazioni_CodicePaziente = new ArrayList<Integer>();
//	List<Integer> Segnalazioni_CodiceReazione_Avversa = new ArrayList<Integer>();
//	List Segnalazioni_Data_Reazione = new ArrayList();
//	List Segnalazioni_Data_Segnalazione = new ArrayList();
//	//List Segnalazioni_Vaccinazioni2MesiP = new ArrayList();


	public Segnalazioni(int codice, Paziente paziente, ReazioneAvversa reazioni, String data) {
		//aggiungere controlli
		this.codice = codice;
		this.paziente = paziente;
		this.reazione = reazioni;
		this.data = data;
	}

	public int getCodice() {
		return this.codice;
	}

	public Paziente getPaziente() {
		return this.paziente;
	}

	public ReazioneAvversa getReazione() {
		return this.reazione;
	}

	public String getData() {
		return this.data;
	}
//
//	public void addSegnalazioni_Codice(int i) {
//		Segnalazioni_Codice.add(i);
//	}
//	public void addSegnalazioni_CodicePaziente(int i) {
//		Segnalazioni_CodicePaziente.add(i);
//	}
//	public void addSegnalazioni_CodiceReazione_Avversa(int i) {
//		Segnalazioni_CodiceReazione_Avversa.add(i);
//	}
//	public void addSegnalazioni_Data_Reazione() {}
//	public void addSegnalazioni_Data_Segnalazione() {}
//	//public void addSegnalazioni_Vaccinazioni2MesiP() {}
//
//	public int getSegnalazioni_Codice(int i) {
//		return Segnalazioni_Codice.get(i);
//	}
//
//	public int getSegnalazioni_CodicePaziente(int i) {
//		return Segnalazioni_CodicePaziente.get(i);
//	}
//
//	public int getSegnalazioni_CodiceReazione_Avversa(int i) {
//		return Segnalazioni_CodiceReazione_Avversa.get(i);
//	}
//
//	/*public String getSegnalazioni_Data_Reazione() {
//		return Segnalazioni_Data_Reazione;
//	}
//
//	public String getSegnalazioni_Data_Segnalazione() {
//		return Segnalazioni_Data_Segnalazione;
//	}*/
}
