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
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    private String pass, nome;
    protected static Medico medico;

    
    
    private Medico m1 = new Medico("5", "5");
    private Medico m2 = new Medico("2", "2");
    private Medico m3 = new Medico("3", "3");
    private Medico m4 = new Medico("4", "4");
    private Farmacologo f1 = new Farmacologo("1", "1");
    private FattoreRischio f = new FattoreRischio("a caso", "A caso", 3);
    private Vaccinazioni v1 = new Vaccinazioni("AstraZeneca", "III", "Roma", "4");
    private ArrayList<FattoreRischio> listaFattori = new ArrayList<FattoreRischio>();
    private ArrayList<Vaccinazioni> listaVaccini = new ArrayList<Vaccinazioni>();
    private Paziente p1 = new Paziente(2, "VR", "alex",listaFattori ,listaVaccini);
    
    private static ArrayList<Medico> listaMedici = new ArrayList<>();
    private static ArrayList<Farmacologo> listaFarmacologo = new ArrayList<>();
    
    
    private boolean trovaMedico(String nome, String pass) {
    	for(Medico i: listaMedici) {
    		if( i.findMed_Username(nome, pass))
    	
    			return true;
    	}
    	return false;
    }
    
    private boolean trovaFarmacologo(String nome, String pass) {
    	for(Farmacologo i: listaFarmacologo) {
    		if( i.findMed_Username(nome, pass))
    	
    			return true;
    	}
    	return false;
    }
    
    protected Medico ritornaMedico(String user, String pass) {
    	for(Medico i: listaMedici) {
    		if( i.findMed_Username(user, pass)) {
    			this.medico = i;
    			return i;
    		}
    	}
    	return null;
    }
    protected Farmacologo ritornaFarmacologo(String user, String pass) {
    	for(Farmacologo i: listaFarmacologo) {
    		if( i.findMed_Username(user, pass)) 
    			return i;
    	
    	}
    	return null;
    }


    public void accedi(ActionEvent event) throws IOException{
        String user = UsenameTextfield.getText();
        String pass = PasswordTextfield.getText();
        medico = ritornaMedico(user,pass);
        
        m2.aggiungiPaziente(p1);
        listaMedici.add(m1);
        listaMedici.add(m2);
        listaMedici.add(m3);
        listaMedici.add(m4);
        
        listaVaccini.add(v1);
        listaFattori.add(f);
        
        listaFarmacologo.add(f1);
        
        f1.prendiMedici(listaMedici);
        

        if (trovaMedico(user, pass)) {	// fallisce qua, mettendo false va meglio
			//Parent root = FXMLLoader.load(getClass().getResource("InterfacciaMedico.fxml"));
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfacciaMedico.fxml"));
        	root = loader.load();
        	
        	ControllerInterfacciaMedico ilMedico = loader.getController();
        	ilMedico.questoMedico(ritornaMedico(user,pass));
        	
        	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else if(trovaFarmacologo(user, pass)){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceFarmacologo.fxml"));
        	root = loader.load();
        	
        	ControllerInterfaceFarmacologo ilFarmacologo = loader.getController();
        	
        	Farmacologo f2 = ritornaFarmacologo(user,pass);
        	
        	ilFarmacologo.questoFarmacologo(f2);
        	
        	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}else{
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
	 public Medico ritornaMedico() {
	    	return medico;
	    }
}	





