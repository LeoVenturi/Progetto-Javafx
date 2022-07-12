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

public class ControllerPaziente {
    @FXML
    private TextField TextAnno;
    @FXML
    private ComboBox ProvinciaCombobox;
    @FXML
    private TextField ProfessioneText;
    @FXML
    private Button ButtonInvia;
    @FXML
    private Button ButtonFattoriRischio;
    @FXML
    private Button BackButton;


    private Stage stage;
    private Scene scene;
    private Parent root;

    ArrayList<FattoreRischio> ListaFattori = new ArrayList<>();

    private String Provincie[] = {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT",
            "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL",
            "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM",
            "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE",
            "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB",
            "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE",
            "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "RM",
            "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN",
            "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT"};

    private final ObservableList<String> L_Provincie = FXCollections.observableArrayList(Provincie);



    public void invia(ActionEvent event) throws IOException {
        String anno = TextAnno.getText();
        String professione = ProfessioneText.getText();

        String prov = (String) ProvinciaCombobox.getSelectionModel().getSelectedItem();
    }

    public void fattoririschio(ActionEvent event) throws IOException {


        //ListaFattori.add(new FattoreRischio(a, b, 1));


        root = FXMLLoader.load(getClass().getResource("FattoriRischio.fxml"));
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
        ProvinciaCombobox.setItems(L_Provincie);
    }
}
