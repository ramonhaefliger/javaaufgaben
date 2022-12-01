package com.example.tannenbaum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TanneApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(TanneApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root.load(), 350, 430);
        stage.setTitle("Tannenbaum");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}