package com.example.provajfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.provajfx.Medico;

// sono stato qyua
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ControllerAccesso {



	@FXML
    private TextField UsenameTextfield;
    @FXML
    private TextField PasswordTextfield;
    @FXML
    private Button AccediButton;

    private String pass, nome;

    
    
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
    protected Medico ritornaMedico() {
    	for(Medico i: listaMedici) {
    		if( i.findMed_Username(nome, pass))
    			return i;
    	}
    	return null;
    }


    public void accedi(ActionEvent event) throws IOException{
        String user = UsenameTextfield.getText();
        String pass = PasswordTextfield.getText();
        listaMedici.add(m1);
        listaMedici.add(m2);
        listaMedici.add(m3);
        listaMedici.add(m4);
        

		if (trovaMedico(user, pass)) {	// fallisce qua, mettendo false va meglio
			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/second_view.fxml"));
//            Parent root = (Parent) loader.load();
//
//            ControllerInterfacciaMedico secController=loader.getController();
//            secController.prendiPazienti("sono qua babyes");
//
////            Stage stage=new Stage();
////            stage.setScene(new Scene(root));
////            stage.show();
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//			 stage.setScene(scene);
//			stage.show();
			 

	           


		} else {
			Alert alert = new Alert(AlertType.INFORMATION );
			alert.setTitle("Informazione");
			alert.setHeaderText("La password o username incorretti");
			alert.showAndWait();
			UsenameTextfield.clear();
			PasswordTextfield.clear();
		}
	}

//// Implemento la funzione del tempo
    Calendar c = Calendar.getInstance(); 							// prende il giorno attuale
	SimpleDateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");   // scelgo il formato da usare
    
	 public void avanzaDiUnGiorno(ActionEvent event) throws IOException{
		 c.add(Calendar.DATE, 1);									// aggiunge un giorno
		 if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			 Farmacologo.mandaSegnale();
		 }
	 }
}	





