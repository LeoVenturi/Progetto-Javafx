package com.example.provajfx;

import java.util.ArrayList;
import java.util.List;

public class ReazioneAvversa {
	private int codice;
	private String descrizione;
	private int livello;
	
	public ReazioneAvversa(int codice, String descrizione, int livello) {
		if(livello < 1 || livello > 5)
			throw new IllegalArgumentException();
		this.codice = codice;
		this.descrizione = descrizione;
		this.livello = livello;
	}
	
	public int getCodice() {
		return this.codice;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public int getLivello() {
		return this.livello;
	}
}
