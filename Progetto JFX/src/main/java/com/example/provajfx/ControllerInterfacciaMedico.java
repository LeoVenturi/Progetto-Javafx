package com.example.provajfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInterfacciaMedico implements Initializable{

    @FXML
    private Button SegnalazioneButton;

    @FXML
    private Button PazienteButton;

    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Medico medico1= getMedico();

    public void segnalazione (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    public void paziente (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Paziente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Accesso.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    public String prendiPazienti(String i) {	// qua
//    	String acc = "";
//    	for(Paziente paz : i.getPazienti())
//    		acc += paz.toString();
    	System.out.println(i );
    	return null;
    }
}
