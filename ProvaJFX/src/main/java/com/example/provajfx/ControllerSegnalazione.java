package com.example.provajfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ControllerSegnalazione {

    //@FXML
    //private ComboBox PazienteCombobox;
    @FXML
    private TextField DataTextfield;
    //@FXML
    //private ComboBox RischioCombobox;
    @FXML
    private TextArea DescrizioneTextarea;
    @FXML
    private Button SegnalazioneButton;

    ComboBox RischioCombobox = new ComboBox();

    String[] Pazienti = {};

    int Livelli[] = {1, 2, 3, 4, 5};

    RischioCombobox.getItems().add(1);

    PazienteCombobox.setPromptText("Codice Paziente");
    RischioCombobox.setPromptText("Livello Gravità");
}
