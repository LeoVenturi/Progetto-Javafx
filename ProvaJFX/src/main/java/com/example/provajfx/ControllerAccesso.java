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

    public void accedi(ActionEvent event){
        u = UsenameTextfield.getText();
        p = PasswordTextfield.getText();
        System.out.println(u);
        System.out.println(p);

        /*int f = findMed_Username(u);
        if(getFarmacologo(f) == 0){*/
        try {
            root = FXMLLoader.load(getClass().getResource("ControllerSegnalazione.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*} else{
        try {
            root = FXMLLoader.load(getClass().getResource(".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}*/
    }

    public String getAccessoUser(){
        return u;
    }
    public String getAccessoPass(){
        return p;
    }
}
