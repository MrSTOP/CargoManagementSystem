package yanzichao.bean;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class Income {

  private long userId;
  private java.sql.Timestamp saleTime;
  private BigDecimal salePrice;
  private long saleIncomeOrderId;
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Income() {
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public Timestamp getSaleTime() {
    return saleTime;
  }

  public void setSaleTime(Timestamp saleTime) {
    this.saleTime = saleTime;
  }

  public BigDecimal getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
  }

  public long getSaleIncomeOrderId() {
    return saleIncomeOrderId;
  }

  public void setSaleIncomeOrderId(long saleIncomeOrderId) {
    this.saleIncomeOrderId = saleIncomeOrderId;
  }
}
