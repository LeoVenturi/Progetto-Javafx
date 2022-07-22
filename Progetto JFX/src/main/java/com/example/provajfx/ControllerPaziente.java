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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPaziente implements Initializable{
    @FXML
    private TextField TextAnno;
    @FXML
    private TextField ProvinciaText;
    @FXML
    private TextField ProfessioneText;
    @FXML
    private TextField DataTextfield;
    @FXML
    private TextField DataReTextfield;
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
    private TextField DataV;

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

    ArrayList<FattoreRischio> ListaFattori = new ArrayList<>();
    ArrayList<Vaccinazioni> ListaVaccini = new ArrayList<>();



    public void invia(ActionEvent event) throws IOException {
        int anno= Integer.parseInt(TextAnno.getText());
        String professione = ProfessioneText.getText();
        String prov = ProvinciaText.getText();

        String currentdata = DataTextfield.getText();
        String dataRe = DataReTextfield.getText();
        String descrizione = DescrizioneTextarea.getText();
        
        Paziente p1 = new Paziente(anno, prov, professione, ListaFattori, ListaVaccini);
        int codPaz = p1.getCodice();

        String codMed = medico.toString();
        	
        int livello = (int) Livello.getSelectionModel().getSelectedItem();		// prendo i dati per creare la Reazione avversa
        String desc = Descrizione.getText();

        String tipo = (String) ReazioenAvversa.getSelectionModel().getSelectedItem();
        ReazioneAvversa r1 = new ReazioneAvversa(tipo, livello,desc); // reazione adversa
        int codRe = r1.getCodice();
        
        Segnalazioni segnalazione = new Segnalazioni(p1, r1, currentdata, dataRe, codMed, codPaz, codRe); // segnalazione
        p1.addSegnalazione(segnalazione);
        medico.aggiungiPaziente(p1);
        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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
        String data = DataV.getText();
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
    	//System.out.println(m.toString());
    	this.medico = m;
    }
    
}
