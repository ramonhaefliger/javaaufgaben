package com.example.tannenbaum;

public class Tanne {
    int stammbreite;
    int stammhoehe;
    int kronenhoehe;
    String zeichnung;

    public void setStammbreite(int stammbreite) {
        this.stammbreite = stammbreite;
    }

    public void setStammhoehe(int stammhoehe) {
        this.stammhoehe = stammhoehe;
    }

    public void setKronenhoehe(int kronenhoehe) {
        this.kronenhoehe = kronenhoehe;
    }

    public String getZeichnung() {
        return zeichnung;
    }

    public void zeichne() {
        int kronenBreite = (kronenhoehe * 2) - 1;
        zeichneKrone(kronenhoehe, kronenBreite);
        zeichneStamm(stammhoehe, stammbreite, kronenBreite);
    }

    private void zeichneKrone(int kronenHoehe, int kronenBreite) {
        int sterne = 1;
        int leerzeichen;
        for (int i = 0; i < kronenHoehe; i++) {
            leerzeichen = kronenBreite - sterne;
            zeichneZeile(leerzeichen, sterne);
            sterne += 2;
        }
    }

    private void zeichneStamm(int stammHoehe, int stammbreite, int kronenBreite) {
        for (int i = 0; i < stammHoehe; i++) {
            zeichneZeile((kronenBreite - stammbreite), stammbreite);
        }
    }

    private void zeichneZeile(int anzahlLeerzeichen, int anzahlSterne) {
        String leerzeichen = "";
        String sterne = "";

        for (int i = 0; i < anzahlLeerzeichen / 2; i++) {
            leerzeichen += "  ";
        }
        for (int i = 0; i < anzahlSterne; i++) {
            sterne += "*";
        }

        zeichnung += "\n" + leerzeichen + sterne + leerzeichen;
    }
}







/*
        String krone = "*\n";
        String stamm = "";
        int maxKronenhoehe = (kronenhoehe * 2) - 1;

        for (int i = 0; i < stammhoehe; i++) {
            String spaces = "";
            for (int j = 0; j < (maxKronenhoehe / 2) -1; j++) {
                spaces += "  ";
            }
            stamm += spaces;
            for (int j = 0; j < stammbreite; j++) {
                stamm += "*";
            }
            stamm += spaces;
            stamm += "\n";
        }

        int w = 1;

        int zeileBreite = maxKronenhoehe;
        for (int i = kronenhoehe-1; i > 0 ; i--) {
            String spaces = "";
            zeileBreite -= 2;
            for (int j = 0; j < zeileBreite; j++) {
                spaces += " ";
            }

            krone += spaces;

            w+=2;
            for (int j = 0; j < w; j++) {
                krone += "*";
            }
            krone += spaces;
            krone += "\n";
        }

        zeichnung = krone + stamm;

         */