package com.example.provajfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerFaSegnalazioniProv {
    @FXML
    Label nameLabel;

    public void displayName(String input) {
        nameLabel.setText(input);
    }
}
