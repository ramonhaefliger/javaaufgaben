package ch.lenovo.api.library;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;


/*  *******************************************************************
 *     Inspired by https://pcsupport.lenovo.com/ch/en/warrantylookup#/
 *     und Silas von der TRISA AG
 *  *******************************************************************
 */
public abstract class Api {

    final static String API_URI = "https://pcsupport.lenovo.com/ch/en/api/v4/upsell/redport/getIbaseInfo";

    public static MachineInfo getMachineInfo(String serialNumber) throws IOException {

        String jsonString = requestResponseFromAPI("{\"serialNumber\":\"" + serialNumber + "\"}");

        JSONObject jsonObj = (JSONObject) JSONValue.parse(jsonString);
        JSONObject dataObj = (JSONObject) jsonObj.get("data");
        JSONObject machineInfoObj = (JSONObject) dataObj.get("machineInfo");
        JSONObject currentWarrantyObj = (JSONObject) dataObj.get("currentWarranty");

        MachineInfo mi = new MachineInfo();
        mi.setModel(machineInfoObj.get("model").toString());
        mi.setProduct(machineInfoObj.get("product").toString());
        mi.setProductName(machineInfoObj.get("productName").toString());
        mi.setProductGroup(machineInfoObj.get("group").toString());
        mi.setSerial(machineInfoObj.get("serial").toString());
        mi.setShipDate(machineInfoObj.get("shipDate").toString());
        mi.setProductImageURL(machineInfoObj.get("productImage").toString());
        mi.setCurrentWarranty(new Warranty());
        populateWarranty(mi.getCurrentWarranty(), currentWarrantyObj);

        JSONArray baseWarrantiesArr = (JSONArray) dataObj.get("baseWarranties");
        for (int i = 0; i < baseWarrantiesArr.size(); i++) {
            mi.getBaseWarranties().add(new Warranty());
            populateWarranty(mi.getBaseWarranties().get(i), (JSONObject)baseWarrantiesArr.get(i));
        }

        JSONArray upgradeWarrantiesArr = (JSONArray) dataObj.get("upgradeWarranties");
        for (int i = 0; i < upgradeWarrantiesArr.size(); i++) {
            mi.getUpgradeWarranties().add(new Warranty());
            populateWarranty(mi.getUpgradeWarranties().get(i), (JSONObject)upgradeWarrantiesArr.get(i));
        }

        JSONArray contractWarrantiesArr = (JSONArray) dataObj.get("contractWarranties");
        for (int i = 0; i < contractWarrantiesArr.size(); i++) {
            mi.getContractWarranties().add(new Warranty());
            populateWarranty(mi.getContractWarranties().get(i), (JSONObject)contractWarrantiesArr.get(i));
        }

        return mi;
    }

    private static void populateWarranty(Warranty warranty, JSONObject sourceObj) {
        warranty.setName(sourceObj.get("name").toString());
        warranty.setDescription(sourceObj.get("description").toString());
        warranty.setCategory(sourceObj.get("category").toString());
        warranty.setType(sourceObj.get("type").toString());
        warranty.setDuration(Integer.valueOf(sourceObj.get("duration").toString()));
        warranty.setStart(Date.valueOf(sourceObj.get("startDate").toString()));
        warranty.setEnd(Date.valueOf(sourceObj.get("endDate").toString()));
    }


    private static String requestResponseFromAPI(String postData) throws IOException {
        URL url = new URL(API_URI);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type","application/json");
        connection.setRequestProperty("Accept", "application/json");
        /* connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((userName + ":" + password).getBytes())); */

        String payload = postData;
        byte[] out = payload.getBytes();

        OutputStream stream = connection.getOutputStream();
        stream.write(out);
        //System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage()); // this is optional

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();

        connection.disconnect();

        return response.toString();
    }
}