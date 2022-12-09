package com.example.warenkorb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WarenkorbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(WarenkorbApplication.class.getResource("order-view.fxml"));
        Scene scene = new Scene(root.load(), 420, 320);
        stage.setTitle("Bestellungen erfassen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}