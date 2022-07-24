package com.example.provajfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerPaziente implements Initializable{
    @FXML
    private DatePicker AnnoNascita;
    @FXML
    private DatePicker DataRez;
    @FXML
    private TextField ProvinciaText;
    @FXML
    private TextField ProfessioneText;
    @FXML
    private ComboBox ReazioenAvversa;
    @FXML
    private ComboBox RischioCombobox;
    @FXML
    private TextArea DescrizioneTextarea;

    @FXML
    private ComboBox <String> Tipo;
    @FXML
    private ComboBox Livello;
    @FXML
    private TextArea Descrizione;

    @FXML
    private ComboBox <String> NomeVaccino;
    @FXML
    private ComboBox <String> TipoSomm;
    @FXML
    private TextField Sede;
    @FXML
    private DatePicker DataV;

    @FXML
    private Button ButtonInvia;
    @FXML
    private Button ButtonFattoriRischio;
    @FXML
    private Button ButtonVaccini;
    @FXML
    private Button BackButton;


    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Medico medico;

    private final String[] Tipi = {"Paziente fumatore", "Iperteso", "Sovrappeso", "Paziente fragile per precedenti patologie cardiovascolari/oncologiche"};
    private final ObservableList<String> L_Tipi = FXCollections.observableArrayList(Tipi);

    private final String[] nomi = {"AstraZeneca", "Pfizer", "Moderna", "Sputnik", "Sinovac", "Antinfluenzale"};
    private final ObservableList<String> L_Nomi = FXCollections.observableArrayList(nomi);
    private LocalDate dataNascita;
    private LocalDate dataReazione;
    ArrayList<FattoreRischio> ListaFattori = new ArrayList<>();
    ArrayList<Vaccinazioni> ListaVaccini = new ArrayList<>();



    public void invia(ActionEvent event) throws IOException {
        dataNascita = AnnoNascita.getValue();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dataDiNascita = Date.from(dataNascita.atStartOfDay(defaultZoneId).toInstant());

        dataReazione= DataRez.getValue();
        ZoneId defaultZoneId2 = ZoneId.systemDefault();
        Date dataDellaReazione = Date.from(dataReazione.atStartOfDay(defaultZoneId2).toInstant());

        String professione = ProfessioneText.getText();
        String prov = ProvinciaText.getText();

        Date dataOggi = new Date();				// prende la data di oggi
        String descrizione = DescrizioneTextarea.getText();

        Date dataRe = dataDellaReazione;
        Calendar due_mesi_fa = Calendar.getInstance();
        Date due_mesi_fa2 = due_mesi_fa.getTime();
        due_mesi_fa.add(Calendar.MONTH, -2);
        
        for(Vaccinazioni vaccini: ListaVaccini)
        	if(vaccini.getData().before(dataDiNascita)) {
        		throw new IllegalArgumentException();
        	}
        
        Paziente p1 = new Paziente(dataDiNascita, prov, professione, ListaFattori, ListaVaccini);
        int codPaz = p1.getCodice();

        String codMed = medico.toString();
        	
        int livello = (int) Livello.getSelectionModel().getSelectedItem();		// prendo i dati per creare la Reazione avversa
        String desc = Descrizione.getText();

        String tipo = (String) ReazioenAvversa.getSelectionModel().getSelectedItem();
        ReazioneAvversa r1 = new ReazioneAvversa(tipo, livello,desc); // reazione adversa
        int codRe = r1.getCodice();
        
        Segnalazioni segnalazione = new Segnalazioni(p1, r1, dataOggi, dataRe, codMed, codPaz, codRe); // segnalazione
        p1.addSegnalazione(segnalazione);
        System.out.println((int) RischioCombobox.getValue());
        segnalazione.addGravita((int) RischioCombobox.getValue());
        if((int) RischioCombobox.getValue() > 3) {
        	Farmacologo.addGravi();
        	System.out.println("è stata agginuta una segnalazione grave");
        }
        if(Farmacologo.getGravi())
        	Farmacologo.addMessaggio("sono state raggiunte le 50 segnalazioni gravi");

        medico.aggiungiPaziente(p1);
        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Interfaccia Medico");
        stage.show();
    }

    public void fattoririschio(ActionEvent event){
        String descrizione = Descrizione.getText();
        int livello = (int) Livello.getSelectionModel().getSelectedItem();
        String tipo = (String) Tipo.getSelectionModel().getSelectedItem();

        ListaFattori.add(new FattoreRischio(tipo, descrizione, livello));
        //System.out.printf("Sono qui 1.");
    }

    public void vaccini(ActionEvent event){

        LocalDate localDate = DataV.getValue();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date data = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        String sede = Sede.getText();
        String nome_vacc = (String) NomeVaccino.getSelectionModel().getSelectedItem();
        String dose = (String) TipoSomm.getSelectionModel().getSelectedItem();
        ListaVaccini.add(new Vaccinazioni(nome_vacc, dose, sede, data));
        //System.out.printf("Sono qui 2.");
    }

    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Interfaccia Medico");
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourcebundle){
        Tipo.getItems().addAll(L_Tipi);
        Livello.getItems().addAll(1, 2, 3, 4, 5);

        NomeVaccino.getItems().addAll(L_Nomi);
        TipoSomm.getItems().addAll("I", "II", "III", "IV", "Dose Unica");
        																	 
        ObservableList<String> L_Reazioni = FXCollections.observableArrayList(ReazioneAvversa.nomeUnivoco);
        ReazioenAvversa.getItems().addAll(L_Reazioni);								// teandina possibili reazioni
        RischioCombobox.getItems().addAll(1, 2, 3, 4, 5);						// tendina gravita
    }
    public void questoMedico(Medico m) {	// si tira dietro il medico dal login
    	this.medico = m;
    }
    
}
