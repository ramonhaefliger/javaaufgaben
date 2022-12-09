package com.example.warenkorb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class OrderController {
    LinkedList<OrderItem> orderedItems = new LinkedList<>();

    @FXML
    private Label produktCount;
    @FXML
    private TextField produktNameInput;
    @FXML
    private TextField produktAnzahlInput;

    @FXML
    protected void onButtonClick() {
        String produktname = produktNameInput.getText();
        int produktAnzahl = Integer.parseInt(produktAnzahlInput.getText());

        OrderItem item = new OrderItem();
        item.setProductName(produktname);
        item.setAmount(produktAnzahl);
        orderedItems.add(item);
        produktCount.setText("(" + orderedItems.size() + ")");
    }

    @FXML
    protected void onLinkClick() throws IOException {
        CartController.showCartView(orderedItems);
    }

}