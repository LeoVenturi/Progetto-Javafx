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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVaccinazioni {

    @FXML
    private ComboBox NomeVaccino;
    @FXML
    private ComboBox TipoSomm;
    @FXML
    private TextField Sede;
    @FXML
    private TextField Data;
    @FXML
    private Button InviaButt;
    @FXML
    private Button Backbutt;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final String[] nomi = {"AstraZeneca", "Pfizer", "Moderna", "Sputnik", "Sinovac", "Antinfluenzale"};
    private final ObservableList<String> Nomi = FXCollections.observableArrayList(nomi);

    public void invia(ActionEvent event) throws IOException {

        String data = Data.getText();
        String descrizione = Sede.getText();

        String prov = (String) NomeVaccino.getSelectionModel().getSelectedItem();
        String cod = (String) NomeVaccino.getSelectionModel().getSelectedItem();


        //new Segnalazioni(codice, paziente, reazioni, data)

        //--------------------------------------
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
        //RischioCombobox.setItems(L_Codici);
        TipoSomm.getItems().addAll("I", "II", "III", "IV", "Dose Unica");
    }
}
