package com.example.provajfx;


import java.util.ArrayList;
import java.util.List;

public class Segnalazioni {

	
	private static int inizio = 0;
	private String codMed;
	private int codPaz;
	private int codRe;
	//private List<Vaccinazioni> = new List;

	private int codice;
	private Paziente paziente;
	private ReazioneAvversa reazione;
	private String dataSegn;
	private String dataRe;

	//lista vaccini ultimi 2 mesi
	public Segnalazioni(Paziente paziente, ReazioneAvversa reazioni, String datasegn, String datare, String codmed, int codpaz, int codre) {
		//aggiungere controlli
		
		this.codice = inizio;		// assegno piu incremento
		inizio = inizio +2;
		System.out.println("Il codice usatp -> " + this.codice);
		this.paziente = paziente;
		this.reazione = reazioni;
		this.dataSegn = datasegn;
		this.dataRe = datare;
		this.codMed = codmed;
		this.codPaz = codpaz;
		this.codRe = codre;
		//this.vacc = vacc;
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
		return this.dataSegn;
	}
}
