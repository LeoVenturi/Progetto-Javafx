package com.example.provajfx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Farmacologo extends Accessi{
	private ArrayList<Medico> medici = new ArrayList<>();
	private boolean segnale = false;
	
	public Farmacologo(String pass, String nomeUtente, ArrayList<Medico> medici) {
		super(pass, nomeUtente);
		this.medici = medici;
		
	}
	
	public void mandaSegnale() {
		this.segnale = true;
	}
	
	public void deleteSegnale() {
		this.segnale = false;
	}
	public boolean find_utente(String user, String password) {
		return super.findMed_Username(user, password);
		
	}
	
	
	public String toString() {
		return null;
	}
	
	

}