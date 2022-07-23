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
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerInterfaceFarmacologo implements Initializable {

    @FXML
    private Label LimSegn;
    @FXML
    private Label PropVacc;
    @FXML
    private Label Testo;
    @FXML
    private TableView<Segnalazioni> Tabella;
    @FXML
    private TableColumn<Segnalazioni, String> colMed;
    @FXML
    private TableColumn<Segnalazioni, Integer>  colPaz;
    @FXML
    private TableColumn<Segnalazioni, Integer> colRez;
    @FXML
    private TableColumn<Segnalazioni, Date> colDataRa;
    @FXML
    private TableColumn<Segnalazioni, Date> colDataS;
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


    public void visto (ActionEvent event) throws IOException {
        LimSegn.setVisible(false);
        Visto.setVisible(false);
    }

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
        //sede = "Provaaaaa";
        System.out.println(sede);
        scene24Controller.displayName(f.SegnalazioniSede());
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AzzMess.setVisible(false);

        this.f = ControllerAccesso.farmacologo;
        f.segnalazioniMedico();

        Testo.setText(f.segnalazioniMedico());
        /*for(Medico med : f.getMedici()) {
            for(Segnalazioni segnalazione: med.getSegnalazioni())
                lista.add(segnalazione);
        }

        colMed.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("codMed"));
        colPaz.setCellValueFactory(new PropertyValueFactory<Segnalazioni, Integer>("codPaz"));
        colRez.setCellValueFactory(new PropertyValueFactory<Segnalazioni, Integer>("codRe"));
        colDataRa.setCellValueFactory(new PropertyValueFactory<Segnalazioni, Date>("dataRe"));
        colDataS.setCellValueFactory(new PropertyValueFactory<Segnalazioni, Date>("dataSegn"));
        //colVacc.setCellValueFactory(new PropertyValueFactory<Segnalazioni, String>("colVacc"));

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
        }*/
    }
    public void questoFarmacologo(Farmacologo i) {
    	System.out.println(i.toString());
    	this.f = i;
    }
}
