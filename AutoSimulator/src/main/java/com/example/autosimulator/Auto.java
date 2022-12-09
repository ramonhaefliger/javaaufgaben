package com.example.autosimulator;

public class Auto {
    private final String marke;
    private final int ps;
    private int aktuelleGeschwindigkeit;
    private int aktuellerGang;
    public boolean istMotorGestartet;

    public Auto(String marke, int ps) {
        this.marke = marke;
        this.ps = ps;
    }

    public String getMarke() {
        return marke;
    }

    public int getPs() {
        return ps;
    }

    public int getAktuelleGeschwindigkeit() {
        return aktuelleGeschwindigkeit;
    }

    public int getAktuellerGang() {
        return aktuellerGang;
    }

    public void starteMotor() {

//        String file = "motor.mp3";
//        Media sound = new Media(new File(file).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        aktuellerGang = 1;
        if (!istMotorGestartet) {
            istMotorGestartet = true;
        } else {
            schalteMotorAus();
        }
    }

    public void schalteMotorAus() {
        istMotorGestartet = false;
        aktuellerGang = 0;
    }

    public void gibGas() {
        int beschleinigung = ps / 20;
        int maxGeschwindigkeit = (ps - ps / 6);
        if (istMotorGestartet  && aktuelleGeschwindigkeit < maxGeschwindigkeit) {
            if (aktuelleGeschwindigkeit + beschleinigung > maxGeschwindigkeit) {
                aktuelleGeschwindigkeit = maxGeschwindigkeit;
            } else {
                aktuelleGeschwindigkeit += beschleinigung;
            }
            schalten();
        }
    }

    public void bremse() {
        if (aktuelleGeschwindigkeit - 9 <= 0) {
            aktuelleGeschwindigkeit = 0;
        } else {
            aktuelleGeschwindigkeit -= 9;
        }

        if (istMotorGestartet) {
            schalten();
        }
    }

    private void schalten() {
        if (aktuelleGeschwindigkeit <= 10) {
            aktuellerGang = 1;
        } else if (aktuelleGeschwindigkeit < 21) {
            aktuellerGang = 2;
        } else if (aktuelleGeschwindigkeit < 41) {
            aktuellerGang = 3;
        } else if (aktuelleGeschwindigkeit < 71) {
            aktuellerGang = 4;
        } else if (aktuelleGeschwindigkeit < 101) {
            aktuellerGang = 5;
        } else {
            aktuellerGang = 6;
        }
    }

    public void hupe() {
//        String file = "hupe.mp3";
//        Media sound = new Media(new File(file).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
    }

    @Override
    public String toString() {
        return marke;
    }

}