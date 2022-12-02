module com.example.warenkorb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.warenkorb to javafx.fxml;
    exports com.example.warenkorb;
}