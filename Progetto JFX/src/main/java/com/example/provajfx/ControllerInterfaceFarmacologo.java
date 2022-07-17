package com.example.provajfx;

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
    private TableView Tabella;
    @FXML
    private TableColumn colMed;
    @FXML
    private TableColumn colPaz;
    @FXML
    private TableColumn colRez;
    @FXML
    private TableColumn colDataRa;
    @FXML
    private TableColumn colDataS;
    @FXML
    private TableColumn colVacc;
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

    //medico, paziente, reazione avversa, data reazione avversa, data segnalazione, vaccinazioni ricevute nei due mesi precedenti alla segnalazione


    private Stage stage;
    private Scene scene;
    private Parent root;

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
        scene2Controller.displayName("---");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void segn_grav (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniGravi.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniGravi scene2Controller = loader.getController();
        scene2Controller.displayName("---");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void segn_prov (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSegnalazioniProv.fxml"));
        Parent root = loader.load();
        ControllerFaSegnalazioniProv scene2Controller = loader.getController();
        scene2Controller.displayName("---");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void segn_sede (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FaSeganlazioniSede.fxml"));
        Parent root = loader.load();
        ControllerFaSeganlazioniSede scene2Controller = loader.getController();
        scene2Controller.displayName("---");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
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
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colMed.setCellValueFactory(new PropertyValueFactory<>("colMed"));
        colPaz.setCellValueFactory(new PropertyValueFactory<>("colPaz"));
        colRez.setCellValueFactory(new PropertyValueFactory<>("colRez"));
        colDataRa.setCellValueFactory(new PropertyValueFactory<>("colDataRa"));
        colDataS.setCellValueFactory(new PropertyValueFactory<>("colDataS"));
        colVacc.setCellValueFactory(new PropertyValueFactory<>("colMed"));

        //Tabella.setItems();

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
}
