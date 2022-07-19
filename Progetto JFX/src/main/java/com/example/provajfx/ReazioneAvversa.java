package com.example.provajfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReazioneAvversa {
	protected final static ArrayList<String> nomeUnivoco = new ArrayList<>(Arrays.asList("malessere generale", "nausea", "mal di testa", "intorpidimento degli arti"));
	
	private final String nome;
	private String descrizione;
	private int livello;
	//private ArrayList<String>() lista = new ArrayList<>();
	
	
	public ReazioneAvversa(String codice, int livello, String descrizione) {
		if(livello < 1 || livello > 5)
			throw new IllegalArgumentException();
		else this.livello = livello;
		if(nomeUnivoco.contains(codice))
			this.nome = codice;
		else
			throw new IllegalArgumentException();
		if(descrizione == null )
			throw new IllegalArgumentException();
		else this.descrizione = descrizione;
	}
	public ArrayList ritornaListaReazioni(){
		return this.nomeUnivoco;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public int getLivello() {
		return this.livello;
	}
	
	
	
}
