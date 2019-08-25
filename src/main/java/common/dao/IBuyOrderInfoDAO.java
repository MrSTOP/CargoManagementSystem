package common.dao;

import yankunwei.javabean.BuyOrderInfo;

import java.util.List;

public interface IBuyOrderInfoDAO {
    int SUPPLIER_STATE_NOT_RECEIVED = 0;
    int SUPPLIER_STATE_RECEIVED = 1;
    
    boolean insertBuyOrder(List<BuyOrderInfo> buyOrderInfos);
    
    List<BuyOrderInfo> getAllBuyOrderInfo();
}
