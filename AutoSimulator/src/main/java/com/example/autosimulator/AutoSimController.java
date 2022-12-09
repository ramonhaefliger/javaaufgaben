package com.example.autosimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.lang.annotation.Native;

public class AutoSimController {

    @FXML
    public ComboBox comboBoxAutos;
    @FXML
    private Auto auto;
    @FXML
    private Label psAnzeige;
    @FXML
    private Label kmhAnzeige;
    @FXML
    private Label gearAnzeige;
    @FXML
    private Button motorStart;

    @FXML
    private void onComboBoxAutosSelectionChanged() {
        auto = (Auto) comboBoxAutos.getValue();
        if (auto.istMotorGestartet) {
            motorStart.setText("Stop");
        } else {
            motorStart.setText("Start");
        }
        psAnzeige.setText(auto.getPs() + " PS");
        kmhAnzeige.setText(auto.getAktuelleGeschwindigkeit() + "");
        gearAnzeige.setText(auto.getAktuellerGang() + "");
    }

    @FXML
    private void onGasClick() {
        auto.gibGas();
        kmhAnzeige.setText(auto.getAktuelleGeschwindigkeit() + "");
        gearAnzeige.setText(auto.getAktuellerGang() + "");
    }

    @FXML
    private void onBreakClick() {
        auto.bremse();
        kmhAnzeige.setText(auto.getAktuelleGeschwindigkeit() + "");
        gearAnzeige.setText(auto.getAktuellerGang() + "");
    }

    @FXML
    private void onHupe() {
        auto.hupe();
    }

    @FXML
    private void onMotorStart() {
        auto.starteMotor();
        gearAnzeige.setText(auto.getAktuellerGang() + "");
        if (auto.istMotorGestartet) {
            motorStart.setText("Stop");
        } else {
            motorStart.setText("Start");
        }
    }

    @FXML
    private void initialize() {
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        Auto porsche = new Auto("Porsche", 250);
        Auto opel = new Auto("Opel", 90);
        Auto ferrari = new Auto("Ferrari", 370);
        autos.addAll(porsche, opel, ferrari);
        comboBoxAutos.setItems(autos);
        comboBoxAutos.setValue(porsche);
        onComboBoxAutosSelectionChanged();
    }

}