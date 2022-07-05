package application;
import java.util.ArrayList;
import java.util.List;

public class Medico {
	String Med_Username[] = {"M000", "M001", "M002"};
	String Med_Password[] = {"AAAA", "BBBB", "CCCC"};
	int Farmacologo[] = {0, 0, 1};
	List<Integer> Medico_CodiciPazienti = new ArrayList<Integer>();
	
	public int findMed_Username(String i) {
		int c;
		for (c = 0; c < Med_Username.length; c++)
			if (i == Med_Username[c])
				break;
		return c;
	}
	
	public String getMed_Username(String i) {
		for(int Med = 0; Med < Med_Username.length; Med++)
			if(Med_Username[Med] == i)
				return Med_Username[Med];
		return null;
	}
	
	public String getMed_Password(int i) {
		return Med_Password[i];
	}
	
	public int getFarmacologo(String i) {
		for(int Med = 0; Med < Med_Username.length; Med++)
			if(Med_Username[Med] == i)
				return Farmacologo[Med];
		return -1;
	}
	
	public void addMedico_CodiciPazienti(int i) {
		Medico_CodiciPazienti.add(i);
	}
	
	public int getMedico_CodiciPazienti(int i) {
		return Medico_CodiciPazienti.get(i);
	}
}
