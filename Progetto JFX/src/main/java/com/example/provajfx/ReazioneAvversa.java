package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReazioneAvversa {
	protected final static ArrayList<String> nomeUnivoco = new ArrayList<>(Arrays.asList("malessere generale", "nausea", "mal di testa", "intorpidimento degli arti"));

	private int codice;
	private final String nome;
	private String descrizione;
	private int livello;
	private static int codice_assegnato = 0;
	
	
	public ReazioneAvversa(String codice, int livello, String descrizione) {
		this.codice = codice_assegnato;
		codice_assegnato ++;

		this.livello = livello;
		if(nomeUnivoco.contains(codice))
			this.nome = codice;
		else
			throw new IllegalArgumentException();
		if(descrizione == null )
			throw new IllegalArgumentException();
		else this.descrizione = descrizione;
	}
	public ArrayList<String> ritornaListaReazioni(){
		return ReazioneAvversa.nomeUnivoco;
	}

	public int getCodice(){return this.codice;}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public int getLivello() {
		return this.livello;
	}
}
