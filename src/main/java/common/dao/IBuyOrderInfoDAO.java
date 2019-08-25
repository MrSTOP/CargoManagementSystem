package common.dao;

import yankunwei.javabean.BuyOrderInfo;
import yankunwei.javabean.BuyOrderListInfo;

import java.util.List;

public interface IBuyOrderInfoDAO {
    int SUPPLIER_STATE_NOT_RECEIVED = 0;
    int SUPPLIER_STATE_RECEIVED = 1;
    
    boolean insertBuyOrder(List<BuyOrderInfo> buyOrderInfos);
    
    boolean updateBuyOrderStatus(long supplierOrderID, long productID, long supplierID, int status);
    
    List<BuyOrderInfo> getAllBuyOrderInfo();
    
    List<BuyOrderListInfo> getAllBuyListInfo();
}
