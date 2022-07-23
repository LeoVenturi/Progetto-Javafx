package com.example.provajfx;

import java.util.*;

public class Farmacologo extends Accessi{
	private ArrayList<Medico> medici = new ArrayList<>();
	private static boolean segnale = false;		// messa a static in modo che tutti i farmacologi abbiano lo stesso attributo
	private static ArrayList<String> messaggi = new ArrayList();
	private static int gravi_tot = 0;
	private Map<String, Integer> num_segnalazioni = new HashMap<>();
	private Map<String, Integer> num_segnalazioni_provincia = new TreeMap<>();
	private Map<String, Integer> num_segnalazioni_sede = new HashMap<>();
	private Map<String, Integer> segnalazioni_vaccino_gravi_mese = new HashMap<>();
	private int segnalazioni_gravi_tot = 0;
	private Calendar oggi = Calendar.getInstance();
	
	public Farmacologo(String pass, String nomeUtente) {
		super(pass, nomeUtente);
		
	}
	public void prendiMedici(ArrayList<Medico> l1) {
		this.medici = l1;
	}

	public int controllaMedici(){
		if (medici == null)
			return 0;
		else
			return 1;
	}
	

	static void mandaSegnale() {		// diventato metodo di classe, applicabile a 
		Farmacologo.segnale = true;		// qualunque istanza di farmacologo, non invocato 
	}									// su qualcuno di preciso, usato in "ControllerAccesso riga 86"
	
	static void deleteSegnale() {
		Farmacologo.segnale = false;
	}
	public boolean find_utente(String user, String password) {
		return super.findMed_Username(user, password);
		
	}
	public String SegnalazioniGravi() {
		oggi.getTime();
		int giorno = oggi.DAY_OF_WEEK;
		segnalazioni_gravi_tot = 0;
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {

					Calendar cal = Calendar.getInstance();		// prendo il primo giorno della settimana
					cal.add(Calendar.DAY_OF_MONTH, - giorno);
					Date inizioSettimana = cal.getTime();
					if(segnalazione.getGravita() > 3 &&
							(segnalazione.getData().after(inizioSettimana) ||
									segnalazione.getData().equals(inizioSettimana)))
						segnalazioni_gravi_tot ++;
				}
			}
		}
		String result = "";
		return result += "\n Numero di segnalazioni gravi in settimana = " + segnalazioni_gravi_tot + "\n";
	}

	public String SegnalazioneVaccino() {
		AzzeraSegnalazioni();
		String result = "\n Segnalazioni per vaccino: \n";

		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				int num = 0;
				for(Vaccinazioni vaccini: paziente.getVaccino()) {
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						Date due_mesi_prima = new Date(segnalazione.getData().getYear(), segnalazione.getData().getMonth() -2, segnalazione.getData().getDay());
						if(vaccini.getData().before(due_mesi_prima) || vaccini.getData().after(segnalazione.getData()));
						else
							num++;
							
						
					}
					if(num_segnalazioni.containsKey(vaccini.getVaccino())) {
						int temp = num_segnalazioni.get(vaccini.getVaccino());
						num_segnalazioni.put(vaccini.getVaccino(), temp + num);
					}
					else
						num_segnalazioni.put(vaccini.getVaccino(), num);
				}
			}
		}

		for(String temp: num_segnalazioni.keySet())
			result += temp + " = " + num_segnalazioni.get(temp) + "\n";
		return result;
	}

	public String SegnalazioniSede(){
		AzzeraSedi();
		String result = "\n Segnalazioni per sede: \n";
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				int num = 0;
				for(Segnalazioni segnalazione: paziente.getSegnalazioni())
					num++;
				for(Vaccinazioni vaccini: paziente.getVaccino()) {
					if(num_segnalazioni_sede.containsKey(vaccini.getSede())) {
						int temp = num_segnalazioni_sede.get(vaccini.getSede());
						num_segnalazioni_sede.put(vaccini.getSede(), num + temp);
					}
					else
						num_segnalazioni_sede.put(vaccini.getSede(), num);
				}
			}
		}
		for(String temp: num_segnalazioni_sede.keySet())
			result += temp + " = " + num_segnalazioni_sede.get(temp) + "\n";

		return result;
	}

	public String SegnalazioniProvincia() {
		AzzeraProvincie();
		String result = "Segnalazioni per provincia: \n";

		//segnalazioni per vaccino
		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {

				if(num_segnalazioni_provincia.containsKey(paziente.getProvincia())) {
					int num = num_segnalazioni_provincia.get(paziente.getProvincia());
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						num++;
					}
					num_segnalazioni_provincia.put(paziente.getProvincia(), num);
				}
				else {
					int num = 0;
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						num++;
					}
					num_segnalazioni_provincia.put(paziente.getProvincia(), num);

				}


			}
		}
		for(String provincia: num_segnalazioni_provincia.keySet())
			result += provincia  + " = " + num_segnalazioni_provincia.get(provincia) + "\n";

		return result;

	}
	
	public void AzzeraSegnalazioni() {
		for(String temp: num_segnalazioni.keySet())
			num_segnalazioni.put(temp, 0);
	}
	public void AzzeraProvincie() {
		for(String temp: num_segnalazioni_provincia.keySet())
			num_segnalazioni_provincia.put(temp, 0);
		
	}
	
	public void AzzeraSedi() {
		for(String temp: num_segnalazioni_sede.keySet())
			num_segnalazioni_sede.put(temp, 0);
		
	}
	
	public String toString() {
		String result = SegnalazioniGravi() + SegnalazioneVaccino() + SegnalazioniSede() + SegnalazioniProvincia();
		return result;
	}

	public ArrayList<Medico> getMedici(){return medici;}
	
	static void addGravi() {
		gravi_tot++;
	}
	
	static Boolean getGravi() {
		if(Farmacologo.gravi_tot > 50)
			return true;
		else
			return false;
	}
	static void addMessaggio(String messaggio) {
		messaggi.add(messaggio);
	}
	public void SegnalazioneGraviVaccino() {
		AzzeraSegnalazioniGraviVaccino();
		
		Date oggi = new Date();
		
		String result = "\n Segnalazioni per vaccino: \n";

		for(Medico medico: medici) {
			for(Paziente paziente: medico.getPazienti()) {
				int num = 0;
				for(Vaccinazioni vaccini: paziente.getVaccino()) {
					
					for(Segnalazioni segnalazione: paziente.getSegnalazioni()) {
						System.out.println("sdfghj" +  oggi.getMonth());
						if(vaccini.getData().getMonth() == oggi.getMonth()  && segnalazione.getGravita() > 3 && vaccini.getData().getYear() == oggi.getYear())
								num++;
							
						
					}
					if(segnalazioni_vaccino_gravi_mese.containsKey(vaccini.getVaccino())) {
						int temp = segnalazioni_vaccino_gravi_mese.get(vaccini.getVaccino());
						segnalazioni_vaccino_gravi_mese.put(vaccini.getVaccino(), temp + num);
						System.out.println("segnalazioni di " + vaccini + "= " + temp + num);
					}
					else {
						segnalazioni_vaccino_gravi_mese.put(vaccini.getVaccino(), num);
						System.out.println("segnalazioni di " + vaccini + "= " + num);
					}
				}
			}
		}
		for(String temp: segnalazioni_vaccino_gravi_mese.keySet())
			if(segnalazioni_vaccino_gravi_mese.get(temp) > 5) {
				Farmacologo.addMessaggio("il vaccino" + temp + "ha raggiunto   \npiù di 5 segnalazione");
				System.out.println("il vaccino" + temp + "ha raggiunto   \npiù di 5 segnalazione");
			}
			else
				System.out.println("non ha funzionato " + segnalazioni_vaccino_gravi_mese.get(temp) + "vaccino " + temp);
			
		
		
	}
	public void AzzeraSegnalazioniGraviVaccino() {
		for(String temp: segnalazioni_vaccino_gravi_mese.keySet())
			segnalazioni_vaccino_gravi_mese.put(temp, 0);
	}
	
	public String visualizzaMessaggi() {
		String result = "";
		for(String messaggio: messaggi)
			result += messaggio + "\n";
		return result;
	}

	public String segnalazioniMedico() {
		String result = "";
		for(Medico medico: medici)
			for(Paziente paziente: medico.getPazienti()) {
				for(Segnalazioni segnalazione: paziente.getSegnalazioni())
					result += "Medico:" + segnalazione.codiceMedico() + "\n segnalazioni: \n" +
							"  codice paziente: " + segnalazione.getPaziente().getCodice() +
							"\n  codice reazione avversa: " + segnalazione.getCodiceRe() +
							"\n  data reazione avversa:" + segnalazione.getDataRe() +
							"\n  data segnalazione: " + segnalazione.getData() + "\n" + "\n";
			}
		return result;
	}

	public void leggiMessaggi() {
		messaggi = null;
	}

}