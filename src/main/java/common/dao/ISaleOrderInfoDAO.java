package common.dao;

import yankunwei.javabean.SaleOrderInfo;
import yankunwei.javabean.SaleOrderListInfo;
import yankunwei.jsonObj.OrderInfo;

import java.util.List;

public interface ISaleOrderInfoDAO {
    int RECEIVE_STATE_NOT_RECEIVE = 0;
    int RECEIVE_STATE_RECEIVED = 1;
    int RECEIVE_STATE_BACK = 2;
    boolean insertSaleOrder(List<OrderInfo> orderInfos);

    boolean updateSaleOrderStatus(long saleOrderID,long productID, long userID, int status);  //修改发货状态

    //List<SaleOrderInfo> getAllSaleOrderInfos();

    List<SaleOrderInfo> getAllSaleOrderInfoByID(long saleOrderID);

    List<SaleOrderListInfo> getAllSaleListInfo();     //获取所有销售单得情况，总况

    long getNewSaleOrderID();

    List<Long> getAllSaleOrderID();
}
