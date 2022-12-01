module com.example.tannenbaum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tannenbaum to javafx.fxml;
    exports com.example.tannenbaum;
}