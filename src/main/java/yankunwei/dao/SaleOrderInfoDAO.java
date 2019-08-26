package yankunwei.dao;

import common.dao.IProductInfoDAO;
import common.dao.ISaleOrderInfoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.jsonObj.OrderInfo;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class SaleOrderInfoDAO implements ISaleOrderInfoDAO {
    private Logger logger = LogManager.getLogger(SaleOrderInfoDAO.class);
    
    private long getNewSaleOrderID() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query new sale order id");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT SALE_ORDER_ID_SEQ.nextval AS SALE_ORDER_ID FROM DUAL";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long saleOrderID = resultSet.getLong("SALE_ORDER_ID");
            logger.info("Query new sale order id success");
            return saleOrderID;
        } catch (SQLException e) {
            logger.error("Query new sale order id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.error("Query new sale order id failed");
        return -1;
    }
    
    @Override
    public boolean insertSaleOrder(List<OrderInfo> orderInfos) {
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        long saleOrderID = getNewSaleOrderID();
        logger.info("Insert new saleOrder");
        
        try {
            connection = DataBaseHelper.getConnection();
            logger.info("Query new sale order id");
            //language=SQL
            String SQL = "INSERT INTO \"SaleOrder\"(\"SaleOrderID\", \"UserID\", \"ProductID\", \"SaleOrderCount\", \"SaleDate\", \"SaleProductPrice\", \"ReceiveStatus\") VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            for (OrderInfo orderInfo: orderInfos) {
                BigDecimal price = productInfoDAO.getProductSalePriceByID(orderInfo.getProductID());
                preparedStatement.setLong(1, saleOrderID);
                preparedStatement.setLong(2, orderInfo.getUserID());
                preparedStatement.setLong(3, orderInfo.getProductID());
                preparedStatement.setInt(4, orderInfo.getProductCount());
                preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                preparedStatement.setBigDecimal(6, price.multiply(new BigDecimal(orderInfo.getProductCount())));
                preparedStatement.setInt(7, ISaleOrderInfoDAO.RECEIVE_STATE_NOT_RECEIVE);
                preparedStatement.executeUpdate();
            }
            logger.info("Insert new saleOrder success");
            return true;
        } catch (SQLException e) {
            logger.error("Insert new saleOrder failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
}
