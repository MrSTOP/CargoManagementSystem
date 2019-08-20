package common.dao;

import yankunwei.javabean.BuyOrderInfo;

import java.util.List;

public interface IBuyOrderInfoDAO {
    boolean insertBuyOrder(BuyOrderInfo buyOrderInfo);
    
    boolean updateBuyOrder(BuyOrderInfo buyOrderInfo);
    
    List<BuyOrderInfo> getAllBuyOrderInfo();
}
