package com.example.autosimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Objects;

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
    public void showCars() {
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        autos.add(new Auto("Porsche", 250));
        autos.add(new Auto("Opel", 90));
        autos.add(new Auto("Ferrari", 370));
        comboBoxAutos.setItems(autos);
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
        if(Objects.equals(motorStart.getText(), "Start")) {
            motorStart.setText("Stop");
        } else {
            motorStart.setText("Start");
        }
    }

}