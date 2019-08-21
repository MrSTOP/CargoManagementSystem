package yankunwei.javabean;


import java.math.BigDecimal;

public class ProductInfo {
    
    private long productID;
    private long supplierID;
    private long supplierOrderID;
    private String productName;
    private BigDecimal productSalePrice;
    private BigDecimal productBuyPrice;
    private String productDescription;
    
    public ProductInfo() {
        this(-1, -1, -1, null, null, null, null);
    }
    
    public ProductInfo(long productID, long supplierID, long supplierOrderID, String productName, BigDecimal productSalePrice, BigDecimal productBuyPrice, String productDescription) {
        this.productID = productID;
        this.supplierID = supplierID;
        this.supplierOrderID = supplierOrderID;
        this.productName = productName;
        this.productSalePrice = productSalePrice;
        this.productBuyPrice = productBuyPrice;
        this.productDescription = productDescription;
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
    
    
    public long getSupplierOrderID() {
        return supplierOrderID;
    }
    
    public void setSupplierOrderID(long supplierOrderID) {
        this.supplierOrderID = supplierOrderID;
    }
    
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
    public BigDecimal getProductSalePrice() {
        return productSalePrice;
    }
    
    public void setProductSalePrice(BigDecimal productSalePrice) {
        this.productSalePrice = productSalePrice;
    }
    
    
    public BigDecimal getProductBuyPrice() {
        return productBuyPrice;
    }
    
    public void setProductBuyPrice(BigDecimal productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
    }
    
    
    public String getProductDescription() {
        return productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
}
