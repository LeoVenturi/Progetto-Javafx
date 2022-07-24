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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerInterfaceFarmacologo implements Initializable {

    @FXML
    private Label Testo;
    @FXML
    private ScrollPane Pannello;
    @FXML
    private Button SegnVacc;
    @FXML
    private Button SegnGrav;
    @FXML
    private Button SegnProv;
    @FXML
    private Button SegnSede;
    @FXML
    private Button VisMess;
    @FXML
    private Button AzzMess;
    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Farmacologo f;


    int i = 0;
    int a = 0;
    ObservableList<Segnalazioni> lista = FXCollections.observableArrayList();


    public void vis_mess (ActionEvent event) throws IOException {
        AzzMess.setVisible(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene23Controller = loader.getController();
        String mess = f.visualizzaMessaggi();
        System.out.println(mess);
        scene23Controller.displayName(mess);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Messaggi");
        stage.show();
    }

    public void azz_mess (ActionEvent event) throws IOException {
        VisMess.setVisible(false);
        AzzMess.setVisible(false);
        f.segnalazioniMedico();
    }

    public void segn_vacc (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene21Controller = loader.getController();
        String vacc = f.SegnalazioneVaccino();
        System.out.println(vacc);
        scene21Controller.displayName(vacc);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Vaccino");
        stage.show();
    }

    public void segn_grav (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene22Controller = loader.getController();
        String grav = f.SegnalazioniGravi();
        System.out.println(grav);
        scene22Controller.displayName(grav);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Gravi");
        stage.show();

    }

    public void segn_prov (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene23Controller = loader.getController();
        String prov = f.SegnalazioniProvincia();
        System.out.println(prov);
        scene23Controller.displayName(prov);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Provincia");
        stage.show();
    }

    public void segn_sede (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene24Controller = loader.getController();
        String sede = f.SegnalazioniSede();
        System.out.println(sede);
        scene24Controller.displayName(f.SegnalazioniSede());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Sede");
        stage.show();
    }

    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Accesso.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Accesso");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AzzMess.setVisible(false);

        this.f = ControllerAccesso.farmacologo;
        f.segnalazioniMedico();

        Testo.setText(f.segnalazioniMedico());
        Pannello.setContent(Testo);
    }
    public void questoFarmacologo(Farmacologo i) {
    	System.out.println(i.toString());
    	this.f = i;
    }
}
