module com.example.kontaktmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kontaktmanager to javafx.fxml;
    exports com.example.kontaktmanager;
}