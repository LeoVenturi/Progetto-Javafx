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
import java.util.ResourceBundle;


public class ControllerSegnalazione implements Initializable{ // aggiunge sia segnalazione che reazione avversa

    @FXML
    private ComboBox PazienteCombobox;
    @FXML
    private TextField DataTextfield;
    @FXML
    private ComboBox RischioCombobox;
    @FXML
    private TextArea DescrizioneTextarea;
    @FXML
    private Button SegnalazioneButton;
    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] codici = {};
    private final ObservableList<String> L_Codici = FXCollections.observableArrayList(codici);


    public void invia(ActionEvent event) throws IOException {

        String data = DataTextfield.getText();
        String descrizione = DescrizioneTextarea.getText();

        int grav = (int) RischioCombobox.getSelectionModel().getSelectedItem();
        //int cod = (int) PazienteCombobox.getSelectionModel().getSelectedItem();


        //new Segnalazioni();

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
        //RischioCombobox.setItems(L_Codici);
        RischioCombobox.getItems().addAll(1, 2, 3, 4, 5);
    }
}
