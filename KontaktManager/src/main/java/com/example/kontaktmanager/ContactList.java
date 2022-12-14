package com.example.kontaktmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactList {

    private ObservableList<Contact> contacts = FXCollections.observableArrayList();;

    public void clear() {
        contacts.clear();
    }

    public void exportCsv (String filePath) throws IOException {
        String spalten = "Name,Email,Phone";
        String zeilen = "";
        for (Contact contact : contacts) {
            zeilen += "\"" + contact.getName() + "\"," + "\"" + contact.getEmail() + "\"," + "\"" + contact.getPhone() + "\"\n";
        }
        String fileContent = spalten + "\n" + zeilen;
        Path path = Paths.get(filePath + ".csv");
        Files.write(path, fileContent.getBytes());
        System.out.println(fileContent);
    }

    public void importCsv (String filePath) {

    }

    public ObservableList<Contact> getContacts() {
        return contacts;
    }

}