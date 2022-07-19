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


public class ControllerSegnalazione implements Initializable{ // aggiunge sia segnalazione che reazione avversa

    @FXML
    private ComboBox PazienteCombobox;
    @FXML
    private TextField DataTextfield;
    @FXML
    private ComboBox RischioCombobox;
    @FXML
    private ComboBox ReazAvversa;			// usero qu
    @FXML
    private TextArea DescrizioneTextarea;
    @FXML
    private Button SegnalazioneButton;
    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Medico medico;

    public void invia(ActionEvent event) throws IOException {
        String data = DataTextfield.getText();
        String descrizione = DescrizioneTextarea.getText();
        
        int grav = (int) RischioCombobox.getSelectionModel().getSelectedItem();	
        int cod = (int) PazienteCombobox.getSelectionModel().getSelectedItem();
        String reazione = (String) ReazAvversa.getSelectionModel().getSelectedItem();
        
        for(Paziente i: medico.getPazienti()) {
        	if (i.getCodice() == cod) {
        		ReazioneAvversa r1 = new ReazioneAvversa(reazione, grav, descrizione);
        		Segnalazioni s1 = new Segnalazioni(i, r1, data);
        
        	}
        }

        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourcebundle){

    	this.medico = ControllerAccesso.medico;		// ottengo il medico dall'accesso

    	ArrayList<String> codici = new ArrayList<>();
    	for(Paziente i: medico.getPazienti()) {
    		codici.add(String.valueOf(i.getCodice()));
    		//System.out.println(String.valueOf(i.getCodice()));
    	}
    	ObservableList<String> L_Codici = FXCollections.observableArrayList(codici);
    	PazienteCombobox.setItems(L_Codici);

    	ObservableList<String> L_Reazioni = FXCollections.observableArrayList(ReazioneAvversa.nomeUnivoco);
    	ReazAvversa.getItems().addAll(L_Reazioni);									// teandina possible reazioni

    	RischioCombobox.getItems().addAll(1, 2, 3, 4, 5);
    }
    
    public void questoMedico(Medico m) {	// si tira dietro il medico dal login
    	this.medico = m;
    }
}
