package yankunwei.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.jsonObj.OrderInfo;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class SaleOrderInfoDAO {
    public static final int RECEIVE_STATE_NOT_RECEIVE = 0;
    public static final int RECEIVE_STATE_RECEIVED = 1;
    private Logger logger = LogManager.getLogger(SaleOrderInfoDAO.class);
    public void insertSaleOrder(List<OrderInfo> orderInfos) {
        ProductInfoDAO productInfoDAO = new ProductInfoDAO();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Insert new saleOrder");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "INSERT INTO \"SaleOrder\"(\"SaleOrderID\", \"UserID\", \"ProductID\", \"SaleOrderCount\", \"SaleDate\", \"SaleProductPrice\", \"ReceiveStatus\") VALUES (SALEORDERID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            for (OrderInfo orderInfo: orderInfos) {
                BigDecimal price = productInfoDAO.getProductSalePriceByID(orderInfo.getProductID());
                preparedStatement.setInt(1, orderInfo.getUserID());
                preparedStatement.setInt(2, orderInfo.getProductID());
                preparedStatement.setInt(3, orderInfo.getProductCount());
                preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                preparedStatement.setBigDecimal(5, price.multiply(new BigDecimal(orderInfo.getProductCount())));
                preparedStatement.setInt(6, RECEIVE_STATE_NOT_RECEIVE);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Insert new saleOrder failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        logger.info("Insert new saleOrder success");
    }
}
