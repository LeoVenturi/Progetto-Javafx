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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInterfaceFarmacologo implements Initializable {

    @FXML
    private Label LimSegn;
    @FXML
    private Label PropVacc;
    @FXML
    private TableView<Segnalazioni> Tabella;
    @FXML
    private TableColumn<Segnalazioni, String> colMed;
    @FXML
    private TableColumn<Segnalazioni, Integer>  colPaz;
    @FXML
    private TableColumn<Segnalazioni, String> colRez;
    @FXML
    private TableColumn<Segnalazioni, String > colDataRa;
    @FXML
    private TableColumn<Segnalazioni, String> colDataS;
    @FXML
    private TableColumn<Segnalazioni, String> colVacc;
    @FXML
    private Button Visto;
    @FXML
    private Button SegnVacc;
    @FXML
    private Button SegnGrav;
    @FXML
    private Button SegnProv;
    @FXML
    private Button SegnSede;
    @FXML
    private Button Prop;
    @FXML
    private Button BackButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Farmacologo f;


    int i = 1;
    int a = 1;


    public void visto (ActionEvent event) throws IOException {
        LimSegn.setVisible(false);
        Visto.setVisible(false);
    }

    public void segn_vacc (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSeganlazioniVaccino.fxml"));
        Parent root = loader.load();
        ControllerFaSeganlazioniVaccino scene2Controller = loader.getController();
        scene2Controller.displayName(f.SegnalazioneVaccino());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Vaccino");
        stage.show();
    }

    public void segn_grav (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniGravi.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniGravi scene2Controller = loader.getController();
        scene2Controller.displayName(f.SegnalazioniGravi());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Gravi");
        stage.show();

    }

    public void segn_prov (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene2Controller = loader.getController();
        scene2Controller.displayName(f.SegnalazioniProvincia());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Provincia");
        stage.show();
    }

    public void segn_sede (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSeganlazioniSede.fxml"));
        Parent root = loader.load();
        ControllerFaSeganlazioniSede scene2Controller = loader.getController();
        scene2Controller.displayName(f.SegnalazioniSede());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Segnalazioni Sede");
        stage.show();
    }

    public void prop (ActionEvent event) throws IOException {
        PropVacc.setVisible(false);
        Prop.setVisible(false);
    }

    public void indietro (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Accesso.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Accesso");
        stage.show();
    }

    ObservableList<Segnalazioni> lista = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.f = ControllerAccesso.farmacologo;

        for(Medico med : f.getMedici()) {
            for(Segnalazioni segnalazione: med.getSegnalazioni())
                lista.add(segnalazione);
        }

        colMed.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("codMed"));
        colPaz.setCellValueFactory(new PropertyValueFactory<Segnalazioni, Integer>("codPaz"));
        colRez.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("codRe"));
        colDataRa.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("dataRe"));
        colDataS.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("dataSegn"));
        colVacc.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("colVacc"));

        Tabella.setItems(lista);

        if (i == 0){
            LimSegn.setVisible(false);
            Visto.setVisible(false);
        }
        else{
            LimSegn.setVisible(true);
            Visto.setVisible(true);
        }

        if (a == 0){
            PropVacc.setVisible(false);
            Prop.setVisible(false);
        }
        else{
            PropVacc.setVisible(true);
            Prop.setVisible(true);
        }
    }
    public void questoFarmacologo(Farmacologo i) {
    	System.out.println(i.toString());
    	this.f = i;
    }
}
