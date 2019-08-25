package yankunwei.javabean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BuyOrderListInfo {
    private long buyOrderID = -1;
    private Timestamp time = null;
    private boolean isAllReceived = false;
    private BigDecimal totalPrice = null;
    
    public BuyOrderListInfo() {
    }
    
    public BuyOrderListInfo(long buyOrderID, Timestamp time, boolean isAllReceived, BigDecimal totalPrice) {
        this.buyOrderID = buyOrderID;
        this.time = time;
        this.isAllReceived = isAllReceived;
        this.totalPrice = totalPrice;
    }
    
    public long getBuyOrderID() {
        return buyOrderID;
    }
    
    public void setBuyOrderID(long buyOrderID) {
        this.buyOrderID = buyOrderID;
    }
    
    public Timestamp getTime() {
        return time;
    }
    
    public String getTimeStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
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
}
