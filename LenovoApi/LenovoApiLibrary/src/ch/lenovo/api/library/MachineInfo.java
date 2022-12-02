package ch.lenovo.api.library;

import java.util.LinkedList;

public class MachineInfo {

    private String model;

    private String product;

    private String productName;

    private String productGroup;

    private String serial;

    private String shipDate;

    private String productImageURL;

    private Warranty currentWarranty;

    private LinkedList<Warranty> baseWarranties;

    private LinkedList<Warranty> upgradeWarranties;

    private LinkedList<Warranty> contractWarranties;

    public MachineInfo() {
        baseWarranties = new LinkedList<Warranty>();
        upgradeWarranties = new LinkedList<Warranty>();
        contractWarranties = new LinkedList<Warranty>();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public Warranty getCurrentWarranty() {
        return currentWarranty;
    }

    public void setCurrentWarranty(Warranty currentWarranty) {
        this.currentWarranty = currentWarranty;
    }

    public LinkedList<Warranty> getBaseWarranties() {
        return baseWarranties;
    }

    public LinkedList<Warranty> getUpgradeWarranties() {
        return upgradeWarranties;
    }

    public LinkedList<Warranty> getContractWarranties() {
        return contractWarranties;
    }



    /*
    private UpgradeWarranties UpgradeWarrantyList { get; set; }

    private ContractWarranties ContractWarrantyList { get; set; }

    */
}
