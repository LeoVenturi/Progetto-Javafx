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
    private TextField ProvinciaText;
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
    ArrayList<Vaccinazioni> ListaVaccini = new ArrayList<>();



    public void invia(ActionEvent event) throws IOException {
        int anno= Integer.parseInt(TextAnno.getText());
        String professione = ProfessioneText.getText();
        String prov = ProvinciaText.getText();

        new Paziente(anno, prov, professione, ListaFattori, ListaVaccini);

        //ListaFattori = NULL

        root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fattoririschio(ActionEvent event) throws IOException {


        //ListaFattori.add(new FattoreRischio(a, b, 1));


        root = FXMLLoader.load(getClass().getResource("FattoriRischio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void vaccini(ActionEvent event) throws IOException {

        //ListaFattori.add(new FattoreRischio(a, b, 1));


        root = FXMLLoader.load(getClass().getResource("Vaccinazioni.fxml"));
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
}
