package com.example.provajfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class ControllerFattoriRischio {

    @FXML
    private ComboBox Tipo;
    @FXML
    private ComboBox Livello;
    @FXML
    private TextArea Descrizione;
    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String Tipi[] = {"Paziente fumatore", "Iperteso", "Sovrappeso", "Paziente fragile per precedenti patologie cardiovascolari/oncologiche"};

    private final ObservableList<String> L_Tipi = FXCollections.observableArrayList(Tipi);

    public void invia(ActionEvent event) throws IOException {
        String descrizione = Descrizione.getText();

        int livello = (int) Livello.getSelectionModel().getSelectedItem();
        String tipo = (String) Tipo.getSelectionModel().getSelectedItem();

        //---------------------------------------------------

        root = FXMLLoader.load(getClass().getResource("Paziente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Paziente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourcebundle){
        Tipo.setItems(L_Tipi);
        Livello.getItems().addAll(1, 2, 3, 4, 5);
    }
}
