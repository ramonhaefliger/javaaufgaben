package com.example.tannenbaum;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TanneController {
    @FXML
    TextField stammBreiteInput;
    @FXML
    TextField stammHoeheInput;
    @FXML
    TextField kronenHoeheInput;
    @FXML
    TextArea ausgabe;

    @FXML
    private void onButtonClick() {
        int stammBreite = Integer.parseInt(stammBreiteInput.getText());
        int stammHoehe = Integer.parseInt(stammHoeheInput.getText());
        int kronenHoehe = Integer.parseInt(kronenHoeheInput.getText());
        Tanne t = new Tanne();
        t.setStammbreite(stammBreite);
        t.setStammhoehe(stammHoehe);
        t.setKronenhoehe(kronenHoehe);
        t.zeichne();
        ausgabe.setText(t.getZeichnung());
    }
}