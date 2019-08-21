package yankunwei.javabean;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class BuyOrderInfo {

  private long supplierOrderId;
  private long productId;
  private long supplierId;
  private java.sql.Timestamp supplierDate;
  private int supplierStatus;
  private int supplierCount;
  private BigDecimal supplierPrice;
  
  public BuyOrderInfo() {
    this(-1, -1, -1, null, -1, -1, null);
  }
  
  public BuyOrderInfo(long supplierOrderId, long productId, long supplierId, Timestamp supplierDate, int supplierStatus, int supplierCount, BigDecimal supplierPrice) {
    this.supplierOrderId = supplierOrderId;
    this.productId = productId;
    this.supplierId = supplierId;
    this.supplierDate = supplierDate;
    this.supplierStatus = supplierStatus;
    this.supplierCount = supplierCount;
    this.supplierPrice = supplierPrice;
  }
  
  public long getSupplierOrderId() {
    return supplierOrderId;
  }

  public void setSupplierOrderId(long supplierOrderId) {
    this.supplierOrderId = supplierOrderId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }


  public java.sql.Timestamp getSupplierDate() {
    return supplierDate;
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


  public BigDecimal getSupplierPrice() {
    return supplierPrice;
  }

  public void setSupplierPrice(BigDecimal supplierPrice) {
    this.supplierPrice = supplierPrice;
  }

}
