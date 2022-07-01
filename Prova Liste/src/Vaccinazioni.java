
public class Vaccinazioni {
	int Vaccinazioni_Codice[] = {};
	int Vaccinazioni_CodicePaziente[] = {};
	String Tipo_Vaccino[] = {};
	int Vaccinazioni_NSomministrazione[] = {}; 
	String Vaccinazioni_Sede[] = {};
	String Vaccinazioni_Data[] = {};

	public int getVaccinazioni_Codice(int i) {
		return Vaccinazioni_Codice[i];
	}
	
	public int getVaccinazioni_CodicePaziente(int i) {
		return Vaccinazioni_CodicePaziente[i];
	}
	
	public String getTipo_Vaccino(int i) {
		return Tipo_Vaccino[i];
	}
	
	public int getVaccinazioni_NSomministrazione(int i) {
		return Vaccinazioni_NSomministrazione[i];
	}
	
	public String getVaccinazioni_Sede(int i) {
		return Vaccinazioni_Sede[i];
	}
	
	public String getVaccinazioni_Data(int i) {
		return Vaccinazioni_Data[i];
	}
}
