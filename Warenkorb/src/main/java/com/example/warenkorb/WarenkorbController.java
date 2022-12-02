package com.example.warenkorb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class WarenkorbController {
    LinkedList<OrderItem> orderedItems = new LinkedList<OrderItem>();

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waren-liste.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        FensterController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setItems(orderedItems);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

}