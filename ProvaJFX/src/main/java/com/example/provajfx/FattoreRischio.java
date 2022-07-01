
public class FattoreRischio {
	int FattoreRischio_Codice[] = {100, 101, 102};
	String FattoreRischio_Nome[] = {"Fumatore", "Iperteso", "Sovrappeso"};
	String FattoreRischio_Descrizione[] = {"Aa", "Bb", "Cc"};
	int FattoreRischio_Livello[] = {1, 2, 3};
	int FattoreRischio_Paziente[] = {000, 000, 001};
	
	public int FattoreRischio_Codice(int i) {
		return FattoreRischio_Codice[i];
	}
	
	public String getFattoreRischio_Nome(int i) {
		return FattoreRischio_Nome[i];
	}
	
	public String getFattoreRischio_Descrizione(int i) {
		return FattoreRischio_Descrizione[i];
	}
	
	public int getFattoreRischio_Livello(int i) {
		return FattoreRischio_Livello[i];
	}
	
	public int getFattoreRischio_Paziente(int i) {
		return FattoreRischio_Paziente[i];
	}
}
