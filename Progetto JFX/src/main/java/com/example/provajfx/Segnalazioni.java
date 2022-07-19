package com.example.provajfx;


import java.util.ArrayList;
import java.util.List;

public class Segnalazioni {

	
	private static int inizio = 0;
	private int codice;
	private Paziente paziente;
	private ReazioneAvversa reazione;
	private String data;


	public Segnalazioni(Paziente paziente, ReazioneAvversa reazioni, String data) {
		//aggiungere controlli
		
		this.codice = inizio;		// assegno piu incremento
		inizio = inizio +2;
		System.out.println("Il codice usatp -> " + this.codice);
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
}
