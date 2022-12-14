package com.example.kontaktmanager;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class KontaktManagerController {
    ContactList contactList = new ContactList();
    @FXML
    TableView tableContacts;
    @FXML
    TextField nameInput;
    @FXML
    TextField phoneInput;
    @FXML
    TextField emailInput;

    @FXML
    public void onButtonAddClick() {
        if (Objects.equals(nameInput.getText(), "") || Objects.equals(emailInput.getText(), "") || Objects.equals(phoneInput.getText(), "")) {
            return;
        }

        Contact contact = new Contact();

        contact.setName(nameInput.getText());
        contact.setEmail(emailInput.getText());
        contact.setPhone(phoneInput.getText());

        contactList.getContacts().add(contact);
    }

    @FXML
    public void onExportClick() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Kontakte exportieren");
        File file = fileChooser.showSaveDialog(null);
        if(file != null) {
            String path = file.getPath();
            contactList.exportCsv(path);
        }
    }

    @FXML
    public void onImportClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Kontakte importieren");
        File file = fileChooser.showOpenDialog(null);
        if(file != null) {
            String path = file.getPath();
            contactList.importCsv(path);
        }
    }

    @FXML
    public void onClearClick() {
        contactList.clear();
    }

    @FXML
    public void initialize() {
        tableContacts.getColumns().clear();
        TableColumn tColName = new TableColumn("Name");
        tColName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn tColEmail = new TableColumn("Email");
        tColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn tColPhone = new TableColumn("Phone");
        tColPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableContacts.getColumns().addAll(tColName, tColEmail, tColPhone);
        tableContacts.setItems(contactList.getContacts());
    }

}