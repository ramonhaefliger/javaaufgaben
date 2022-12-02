package com.example.warenkorb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class FensterController {
    LinkedList<OrderItem> orderedItems = new LinkedList<OrderItem>();

    protected void setStage() {

    }

    protected void setItems(LinkedList<OrderItem> list) {
        orderedItems = list;
    }

}
