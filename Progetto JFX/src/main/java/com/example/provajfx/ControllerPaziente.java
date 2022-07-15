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
    private TextField Data;

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
    private Medico medico;

    private final String[] Tipi = {"Paziente fumatore", "Iperteso", "Sovrappeso", "Paziente fragile per precedenti patologie cardiovascolari/oncologiche"};
    private final ObservableList<String> L_Tipi = FXCollections.observableArrayList(Tipi);

    private final String[] nomi = {"AstraZeneca", "Pfizer", "Moderna", "Sputnik", "Sinovac", "Antinfluenzale"};
    private final ObservableList<String> L_Nomi = FXCollections.observableArrayList(nomi);

    private ArrayList<FattoreRischio> ListaFattori = new ArrayList<>();
    private ArrayList<Vaccinazioni> ListaVaccini = new ArrayList<>();



    public void invia(ActionEvent event) throws IOException {
        int anno= Integer.parseInt(TextAnno.getText());
        String professione = ProfessioneText.getText();
        String prov = ProvinciaText.getText();

        medico.aggiungiPaziente(new Paziente(anno, prov, professione, ListaFattori, ListaVaccini));
        for(Paziente i: medico.getPazienti())
        	System.out.println("lista dei pazienti -> "+ i.toString());
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
        System.out.printf("Sono qui 1.");
        System.out.print(ListaFattori.size());
    }

    public void vaccini(ActionEvent event){
        String data = Data.getText();
        String sede = Sede.getText();
        String nome_vacc = (String) NomeVaccino.getSelectionModel().getSelectedItem();
        String dose = (String) TipoSomm.getSelectionModel().getSelectedItem();

        ListaVaccini.add(new Vaccinazioni(nome_vacc, dose, sede, data));
        System.out.print("Sono qui 2.");
        System.out.print(ListaVaccini.size());
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
    }
    public void questoMedico(Medico m) {	// si tira dietro il medico dal login
    	this.medico = m;
    }
}
