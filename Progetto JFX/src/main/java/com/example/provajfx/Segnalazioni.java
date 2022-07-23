package com.example.provajfx;


import java.util.ArrayList;
import java.util.Date;
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
	private Date dataSegn;
	private Date dataRe;
	private int gravità;

	//lista vaccini ultimi 2 mesi
	public Segnalazioni(Paziente paziente, ReazioneAvversa reazioni, Date datasegn, Date datare, String codmed, int codpaz, int codre) {
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

	public Date getData() {
		return this.dataSegn;
	}

	public String toString() {
		return this.codice + "";
	}
	public void addGravità(int gravità) {
		this.gravità = gravità;
		
	}
	public int getGravità() {
		return this.gravità;
	}

	public Date getDataRe() {
		return this.dataRe;
	}
	public int getCodiceRe() {
		return this.codRe;
	}
	public String codiceMedico() {
		return this.codMed;
	}
}
