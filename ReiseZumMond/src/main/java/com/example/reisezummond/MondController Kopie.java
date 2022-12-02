package com.example.reisezummond;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MondController {
    @FXML
    private TextField geschwindigkeitInput;
    @FXML
    private TextField ausgabe;
    @FXML
    private RadioButton days;
    @FXML
    private RadioButton hours;

    @FXML
    protected void onButtonClick() {
        int geschwindigkeit = Integer.parseInt(geschwindigkeitInput.getText());
        Mondreise mondreise = new Mondreise(geschwindigkeit);
        if (hours.isSelected()) {
            ausgabe.setText("" + mondreise.getTravelDurationHours());
        } else if (days.isSelected()) {
            ausgabe.setText("" + mondreise.getTravelDurationDays());
        }
    }
}