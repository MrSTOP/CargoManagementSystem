package yankunwei.javabean;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BuyOrderListInfo {
    long buyOrderID = -1;
    Timestamp time = null;
    boolean isAllReceived = false;
    
    public BuyOrderListInfo() {
    }
    
    public BuyOrderListInfo(long buyOrderID, Timestamp time, boolean isAllReceived) {
        this.buyOrderID = buyOrderID;
        this.time = time;
        this.isAllReceived = isAllReceived;
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
}
