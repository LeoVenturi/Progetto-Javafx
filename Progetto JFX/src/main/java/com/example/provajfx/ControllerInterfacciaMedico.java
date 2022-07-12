package com.example.provajfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerInterfacciaMedico {

    @FXML
    private Button SegnalazioneButton;

    @FXML
    private Button PazienteButton;

    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void segnalazione (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void paziente (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
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
}
