import java.util.ArrayList;
import java.util.List;

public class Segnalazioni {
	List<Integer> Segnalazioni_Codice = new ArrayList<Integer>(); 
	List<Integer> Segnalazioni_CodicePaziente = new ArrayList<Integer>(); 
	List<Integer> Segnalazioni_CodiceReazione_Avversa = new ArrayList<Integer>(); 
	List Segnalazioni_Data_Reazione = new ArrayList(); 
	List Segnalazioni_Data_Segnalazione = new ArrayList(); 
	//List Segnalazioni_Vaccinazioni2MesiP = new ArrayList();
	
	public void addSegnalazioni_Codice(int i) {
		Segnalazioni_Codice.add(i);
	}
	public void addSegnalazioni_CodicePaziente(int i) {
		Segnalazioni_CodicePaziente.add(i);
	}
	public void addSegnalazioni_CodiceReazione_Avversa(int i) {
		Segnalazioni_CodiceReazione_Avversa.add(i);
	}
	public void addSegnalazioni_Data_Reazione() {}
	public void addSegnalazioni_Data_Segnalazione() {}
	//public void addSegnalazioni_Vaccinazioni2MesiP() {}
	
	public int getSegnalazioni_Codice(int i) {
		return Segnalazioni_Codice.get(i);
	}
	
	public int getSegnalazioni_CodicePaziente(int i) {
		return Segnalazioni_CodicePaziente.get(i);
	}
	
	public int getSegnalazioni_CodiceReazione_Avversa(int i) {
		return Segnalazioni_CodiceReazione_Avversa.get(i);
	}
	
	/*public String getSegnalazioni_Data_Reazione() {
		return Segnalazioni_Data_Reazione;
	}
	
	public String getSegnalazioni_Data_Segnalazione() {
		return Segnalazioni_Data_Segnalazione;
	}*/
}
