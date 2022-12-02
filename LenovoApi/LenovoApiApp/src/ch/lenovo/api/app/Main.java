package ch.lenovo.api.app;

import ch.lenovo.api.library.Api;
import ch.lenovo.api.library.MachineInfo;
import ch.lenovo.api.library.Warranty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("**********************************************************************************************");
        System.out.println("Lenovo Warranty Lookup - Einzelabfrage [ https://pcsupport.lenovo.com/ch/en/warrantylookup#/ ]");
        System.out.println("**********************************************************************************************\n");

        System.out.println("Seriennummer eingeben: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String serial = in.readLine();
        MachineInfo machineInfo = Api.getMachineInfo(serial);

        System.out.println("\n--- Gerät ---");
        System.out.println("Produktgruppe: " + machineInfo.getProductGroup());
        System.out.println("Produkt: " + machineInfo.getProduct());
        System.out.println("Modell: " + machineInfo.getModel());

        System.out.println("\n--- Aktuelle Garantie ---");
        Warranty warranty = machineInfo.getCurrentWarranty();
        System.out.println("Name: " + warranty.getName());
        System.out.println("Kategorie: " + warranty.getCategory());
        System.out.println("Typ: " + warranty.getType());
        System.out.println("Dauer: " + warranty.getDuration());
        System.out.println("Von: " + warranty.getStart());
        System.out.println("Bis: " + warranty.getEnd());
        System.out.println("Beschreibung: " + warranty.getDescription());

        System.out.println("\n--- Garantie Upgrade Optionen ---");
        LinkedList<Warranty> list = machineInfo.getUpgradeWarranties();
        for (int i = 0; i < list.size(); i++) {
            int j = i+1;
            System.out.println("Option " + j);
            System.out.println("--------");
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("Kategorie: " + list.get(i).getCategory());
            System.out.println("Typ: " + list.get(i).getType());
            System.out.println("Dauer: " + list.get(i).getDuration());
            System.out.println("Von: " + list.get(i).getStart());
            System.out.println("Bis: " + list.get(i).getEnd());
            System.out.println("Beschreibung: " + list.get(i).getDescription());
            System.out.println();
        }
    }
}