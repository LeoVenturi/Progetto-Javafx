package com.example.provajfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAccesso extends Medico{

    @FXML
    private TextField UsenameTextfield;
    @FXML
    private TextField PasswordTextfield;
    @FXML
    private Button AccediButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void accedi(ActionEvent event) throws IOException{
        String user = UsenameTextfield.getText();
        String pass = PasswordTextfield.getText();

		if (findMed_Username(pass, user)) {	// fallisce qua, mettendo false va meglio
			root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else {
			Alert alert = new Alert(AlertType.INFORMATION );
			alert.setTitle("Informazione");
			alert.setHeaderText("La password o username incorretti");
			alert.showAndWait();
			UsenameTextfield.clear();
			PasswordTextfield.clear();
			
		}
	}


//    public String getAccessoUser(){
//        return user;
//    }
//    public String getAccessoPass(){
//        return p;
//    }
}
