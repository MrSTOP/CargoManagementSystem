package yanzichao.bean;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class Outcome {

  private long supplierId;
  private java.sql.Timestamp outTime;
  private BigDecimal outPrice;
  private long outSupplierId;
  private String description;

  public Outcome() {
  }

  public long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }

  public Timestamp getOutTime() {
    return outTime;
  }

  public void setOutTime(Timestamp outTime) {
    this.outTime = outTime;
  }

  public BigDecimal getOutPrice() {
    return outPrice;
  }

  public void setOutPrice(BigDecimal outPrice) {
    this.outPrice = outPrice;
  }

  public long getOutSupplierId() {
    return outSupplierId;
  }

  public void setOutSupplierId(long outSupplierId) {
    this.outSupplierId = outSupplierId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
