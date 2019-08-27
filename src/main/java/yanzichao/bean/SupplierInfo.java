package yanzichao.bean;

public class SupplierInfo {
    private long supplierID;
    private String supplierName;
    private String supplierDescription;
    private String supplierAddress;
    private long supplierPhone;
    public SupplierInfo() {
    }

    public long getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(long supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public SupplierInfo(long SupplierID, String supplierName, String supplierDescription, String supplierAddress, long SupplierPhone)
    {
        this.supplierID = SupplierID;
        this.supplierName = supplierName;
        this.supplierDescription = supplierDescription;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = SupplierPhone;
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
