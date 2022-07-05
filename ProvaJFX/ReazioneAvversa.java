package application;

import java.util.ArrayList;
import java.util.List;

public class ReazioneAvversa {
	List<Integer> ReazioneAvversa_Codice = new ArrayList<Integer>();
	List<Integer> ReazioneAvversa_Gravità = new ArrayList<Integer>();
	List<String> ReazioneAvversa_Descrizione = new ArrayList<String>();
	List<Integer> ReazioneAvversa_CodiceMedico= new ArrayList<Integer>();
	
	public void addReazioneAvversa_Codice(int i) {
		ReazioneAvversa_Codice.add(i);
	}
	
	public void addReazioneAvversa_Gravità(int i) {
		ReazioneAvversa_Gravità.add(i);
	}
	
	public void addReazioneAvversa_Descrizione(String i) {
		ReazioneAvversa_Descrizione.add(i);
	}
	
	public void addReazioneAvversa_CodiceMedico(int i) {
		ReazioneAvversa_CodiceMedico.add(i);
	}
	
}
