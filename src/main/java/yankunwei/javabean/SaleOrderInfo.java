package yankunwei.javabean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SaleOrderInfo {
    private long saleOrderID;
    private long userID;
    private long productID;
    private int saleOrderCount;                 //货物数量
    private java.sql.Timestamp saleDate;
    private BigDecimal saleProductPrice;        //货单总价
    private BigDecimal productUnitPrice;         //货品单价
    private BigDecimal productTotalPrice;       //货品总价
    private int receiveStatus;   //状态

    public SaleOrderInfo(){
        this(-1,-1,-1,-1,null,null,-1);
    }

    public SaleOrderInfo(long saleOrderID, long userID, long productID, int saleOrderCount, Timestamp saleDate, BigDecimal saleProductPrice, int receiveStatus) {
        this.saleOrderID = saleOrderID;
        this.userID = userID;
        this.productID = productID;
        this.saleOrderCount = saleOrderCount;
        this.saleDate = saleDate;
        this.saleProductPrice = saleProductPrice;
        this.receiveStatus = receiveStatus;
    }



    public long getSaleOrderID() {
        return saleOrderID;
    }

    public void setSaleOrderID(long saleOrder) {
        this.saleOrderID = saleOrder;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getSaleOrderCount() {
        return saleOrderCount;
    }

    public void setSaleOrderCount(int saleOrderCount) {
        this.saleOrderCount = saleOrderCount;
    }

    public java.sql.Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getSaleProductPrice() {
        return saleProductPrice;
    }

    public void setSaleProductPrice(BigDecimal saleProductPrice) {
        this.saleProductPrice = saleProductPrice;
    }

    public BigDecimal getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(BigDecimal productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public int getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(int receiveStatus) {
        this.receiveStatus = receiveStatus;
    }
    public String getSaleDateStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(saleDate);
    }
    //获取时间字符串

    public String getSaleStatusStr(){
        switch (receiveStatus)
        {
            case 0:
                return "未到货";
            case 1:
                return "已到货";
            case 2:
                return "已退货";
            default:
                return "";
        }
    }
}
