package yanzichao.bean;

public class SupplierInfo {
    private long supplierID;
    private String supplierName;
    private String supplierDescription;
    private String supplierAddress;
    public SupplierInfo() {
    }
    public SupplierInfo(long supplierID, String supplierName, String supplierDescription, String supplierAddress)
    {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierDescription = supplierDescription;
        this.supplierAddress = supplierAddress;
    }
    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDescription() {
        return supplierDescription;
    }

    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = supplierDescription;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }





}
