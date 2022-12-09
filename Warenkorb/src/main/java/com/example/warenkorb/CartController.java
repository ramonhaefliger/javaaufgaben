package com.example.warenkorb;

import java.io.IOException;
import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CartController {
    LinkedList<OrderItem> orderedItems = new LinkedList<>();
    @FXML
    TextArea produktListe;

    public static void showCartView(LinkedList<OrderItem> orderedItems) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(WarenkorbApplication.class.getResource("cart-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        CartController controller = fxmlLoader.getController();
        controller.setItems(orderedItems);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    private void setItems(LinkedList<OrderItem> list) {
        orderedItems = list;
        String l = "";
        for (OrderItem orderedItem : orderedItems) {
            l += orderedItem.getAmount() + " Ex.        " + orderedItem.getProductName() + "\n";
        }
        produktListe.setText(l);
    }

}