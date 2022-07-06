package com.example.provajfx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAccesso {

    @FXML
    private TextField UsenameTextfield;
    @FXML
    private TextField PasswordTextfield;
    @FXML
    private Button AccediButton;

    String u, p;

    private Stage stage;
    private Scene scene;
    private Parent root;
//----------------------prova---------------------
    String Med_Username[] = {"M000", "M001", "M002"};
    String Med_Password[] = {"AAAA", "BBBB", "CCCC"};
    int Farmacologo[] = {0, 0, 1};
    List<Integer> Medico_CodiciPazienti = new ArrayList<Integer>();

    public int findMed_Username(String i) {
        int c;
        for (c = 0; c < Med_Username.length; c++)
            if (i == Med_Username[c])
                break;
        return c;
    }

    public int getFarmacologo(int i) {
        return Farmacologo[i];
    }
//----------------------------------------------


    public void accedi(ActionEvent event) throws IOException{
        u = UsenameTextfield.getText();
        p = PasswordTextfield.getText();
        System.out.println(u);
        System.out.println(p);

        int f = findMed_Username(u);

        if (getFarmacologo(f) == 0) {
            root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        /*else{
        try {
            root = FXMLLoader.load(getClass().getResource(".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}*/}

    /*public void accedi(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Segnalazione.fxml"));
        Stage window = (Stage) AccediButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }*/

    public String getAccessoUser(){
        return u;
    }
    public String getAccessoPass(){
        return p;
    }
}
