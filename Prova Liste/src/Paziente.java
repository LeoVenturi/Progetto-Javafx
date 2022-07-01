
public class Paziente {
	int Paz_Codice[] = {000, 001, 002};
	int Paz_AnnoNascita[] = {1999, 2000, 2001};
	String Paz_Provincia[] = {"VR", "PD", "VR"};
	String Paz_Professione[] = {"Meccanico", "Programmatore", "Studente"};
	//String Paz_CodiceFattoriRischio[] = {"100", "101", "102"};
	int Paz_NReazioni_Avverse[] = {0, 0, 0};
	int Paz_NVaccini[] = {1, 2, 3};
	
	public int findPaz_Codice(int i) {
		int c;
		for (c = 0; c < Paz_Codice.length; c++)
			if (Paz_Codice[i] == Paz_Codice[c])
				break;
		return c;
	}

	public int getPaz_Codice(int i) {
		return Paz_Codice[i];
	}
	
	public int getPaz_AnnoNascita(int i) {
		return Paz_AnnoNascita[i];
	}
	
	public String getPaz_Provincia(int i) {
		return Paz_Provincia[i];
	}
	
	public String getPaz_Professione(int i) {
		return Paz_Professione[i];
	}
	
	/*public String getPaz_CodiceFattoriRischio(int i) {
		return Paz_CodiceFattoriRischio[i];
	}*/
	
	public int getPaz_NReazioni_Avverse(int i) {
		return Paz_NReazioni_Avverse[i];
	}
	
	public int getPaz_NVaccini(int i) {
		return Paz_NVaccini[i];
	}
}
