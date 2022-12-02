package com.example.reisezummond;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MondApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(MondApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root.load(), 460, 340);
        stage.setTitle("Reisedauer zum Mond");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}