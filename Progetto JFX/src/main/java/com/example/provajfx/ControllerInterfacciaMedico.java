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

public class ControllerInterfacciaMedico {

    @FXML
    private Button SegnalazioneButton;

    @FXML
    private Button PazienteButton;

    @FXML
    private Button BackButton;
    private static Medico m;

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Medico medico1= getMedico();

    public void segnalazione (ActionEvent event) throws IOException {
        //root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Segnalazione.fxml"));
    	
    	root = loader.load();
    	
    	ControllerSegnalazione ilMedico = loader.getController();
    	ilMedico.MandaMedico(m);
    	
    	
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    public void paziente (ActionEvent event) throws IOException {
       // root = FXMLLoader.load(getClass().getResource("Paziente.fxml"));
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Paziente.fxml"));
    	root = loader.load();
    	
    	ControllerPaziente ilMedico = loader.getController();
    	ilMedico.questoMedico(m);
    	
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


    public void questoMedico(Medico i) {
    	this.m = i;
    }

}
