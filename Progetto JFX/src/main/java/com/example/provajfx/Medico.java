package com.example.provajfx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medico extends Accessi {
	private ArrayList<Paziente> lista_pazienti = new ArrayList<Paziente>();
	public Medico(String pass, String nomeUtente) {
		super(pass, nomeUtente);
	}
	
	public boolean find_utente(String user, String password) {
		return super.findMed_Username(user, password);
		
	}
	
	public  ArrayList<Paziente> getPazienti(){
		return this.lista_pazienti;
	}

	
	
}
