package com.example.provajfx;


import java.util.ArrayList;
import java.util.List;

public class Segnalazioni {

	public int codice;
	public Paziente paziente;
	public ReazioneAvversa reazione;
	public String data;


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
}
