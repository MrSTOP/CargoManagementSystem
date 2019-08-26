package yankunwei.javabean;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BuyOrderInfo {
    
    private long supplierOrderID;
    private long productID;
    private long supplierID;
    private java.sql.Timestamp supplierDate;
    private int supplierStatus;
    private int supplierCount;
    private BigDecimal currentProductPrice;
    private BigDecimal currentProductBuyPrice;
    private BigDecimal supplierPrice;
    
    public BuyOrderInfo() {
        this(-1, -1, -1, null, -1, -1, null);
    }
    
    public BuyOrderInfo(long supplierOrderID, long productID, long supplierID, Timestamp supplierDate, int supplierStatus, int supplierCount, BigDecimal supplierPrice) {
        this.supplierOrderID = supplierOrderID;
        this.productID = productID;
        this.supplierID = supplierID;
        this.supplierDate = supplierDate;
        this.supplierStatus = supplierStatus;
        this.supplierCount = supplierCount;
        this.supplierPrice = supplierPrice;
    }
    
    public long getSupplierOrderID() {
        return supplierOrderID;
    }
    
    public void setSupplierOrderID(long supplierOrderID) {
        this.supplierOrderID = supplierOrderID;
    }
    
    
    public long getProductID() {
        return productID;
    }
    
    public void setProductID(long productID) {
        this.productID = productID;
    }
    
    
    public long getSupplierID() {
        return supplierID;
    }
    
    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }
    
    
    public java.sql.Timestamp getSupplierDate() {
        return supplierDate;
    }
    
    public String getSupplierDateStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(supplierDate);
    }
    
    public void setSupplierDate(java.sql.Timestamp supplierDate) {
        this.supplierDate = supplierDate;
    }
    
    
    public int getSupplierStatus() {
        return supplierStatus;
    }
    
    public void setSupplierStatus(int supplierStatus) {
        this.supplierStatus = supplierStatus;
    }
    
    
    public int getSupplierCount() {
        return supplierCount;
    }
    
    public void setSupplierCount(int supplierCount) {
        this.supplierCount = supplierCount;
    }
    
    
    public BigDecimal getCurrentProductPrice() {
        return currentProductPrice;
    }
    
    public void setCurrentProductPrice(BigDecimal currentProductPrice) {
        this.currentProductPrice = currentProductPrice;
    }
    
    public BigDecimal getCurrentProductBuyPrice() {
        return currentProductBuyPrice;
    }
    
    public void setCurrentProductBuyPrice(BigDecimal currentProductBuyPrice) {
        this.currentProductBuyPrice = currentProductBuyPrice;
    }
    
    public BigDecimal getSupplierPrice() {
        return supplierPrice;
    }
    
    public void setSupplierPrice(BigDecimal supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
    
}
