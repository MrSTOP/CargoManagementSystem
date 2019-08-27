package yankunwei.javabean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SaleOrderListInfo {
    private long saleOrderID = -1;
    private Timestamp time = null;              //时间

    private boolean isAllReceived = false;         //是否收到货物
    private BigDecimal totalPrice = null;     //总价

    public SaleOrderListInfo(long saleOrderID, Timestamp time, boolean isAllReceived, BigDecimal totalPrice) {
        this.saleOrderID = saleOrderID;
        this.time = time;
        this.isAllReceived = isAllReceived;
        this.totalPrice = totalPrice;
    }
    public SaleOrderListInfo()
    {
    }

    public long getSaleOrderID() {
        return saleOrderID;
    }

    public void setSaleOrderID(long saleOrderID) {
        this.saleOrderID = saleOrderID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isAllReceived() {
        return isAllReceived;
    }

    public void setAllReceived(boolean allReceived) {
        isAllReceived = allReceived;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }



    public String getTimeStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
    }
}
