package yankunwei.dao;

import yankunwei.jsonObj.OrderInfo;

import java.util.List;

public interface ISaleOrderInfoDAO {
    int RECEIVE_STATE_NOT_RECEIVE = 0;
    int RECEIVE_STATE_RECEIVED = 1;
    
    void insertSaleOrder(List<OrderInfo> orderInfos);
}
