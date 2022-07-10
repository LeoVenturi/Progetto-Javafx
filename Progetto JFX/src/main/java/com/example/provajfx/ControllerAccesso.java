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
import com.example.provajfx.Medico;

// sono stato qyua
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

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Medico m1 = new Medico("1", "1");
    private Medico m2 = new Medico("2", "2");
    private Medico m3 = new Medico("3", "3");
    private Medico m4 = new Medico("4", "4");
    
    private ArrayList<Medico> listaMedici = new ArrayList<>();
    
    private boolean trovaMedico(String nome, String pass) {
    	for(Medico i: listaMedici) {
    		if( i.findMed_Username(nome, pass))
    			return true;
    	}
    	return false;
    }


    public void accedi(ActionEvent event) throws IOException{
        String user = UsenameTextfield.getText();
        String pass = PasswordTextfield.getText();
        listaMedici.add(m1);
        listaMedici.add(m2);
        listaMedici.add(m3);
        listaMedici.add(m4);
        

		if (trovaMedico(user, pass)) {	// fallisce qua, mettendo false va meglio
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
