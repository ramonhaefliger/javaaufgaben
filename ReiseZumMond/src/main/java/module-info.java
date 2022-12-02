module com.example.reisezummond {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reisezummond to javafx.fxml;
    exports com.example.reisezummond;
}