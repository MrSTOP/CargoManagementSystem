package yankunwei.dao;

import common.dao.IProductInfoDAO;
import common.dao.ISaleOrderInfoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.javabean.SaleOrderInfo;
import yankunwei.javabean.SaleOrderListInfo;
import yankunwei.jsonObj.OrderInfo;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleOrderInfoDAO implements ISaleOrderInfoDAO {
    private Logger logger = LogManager.getLogger(SaleOrderInfoDAO.class);

    public long getNewSaleOrderID() {
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

    public boolean updateSaleOrderStatus(long saleOrderID,long productID, long userID, int status)   //修改收货状态
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Update SALE order state");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "UPDATE \"SaleOrder\" SET \"ReceiveStatus\" = ? WHERE \"SaleOrderID\" = ? AND \"UserID\" =? AND \"ProductID\" = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, status);
            preparedStatement.setLong(2, saleOrderID);
            preparedStatement.setLong(3, productID);
            preparedStatement.setLong(4, userID);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update SALE order state success");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            logger.error("Update SALE order state failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        logger.error("Update SALE order state failed");
        return false;
    }
    public List<SaleOrderInfo> getAllSaleOrderInfoByID(long saleOrderID)  //依据货单 查询所有该货单的货物
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SaleOrderInfo> saleOrderInfos = new ArrayList<>();
        logger.info("Query all SALE order id:{}", saleOrderID);
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"SaleOrder\" WHERE \"SaleOrderID\" = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, saleOrderID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SaleOrderInfo saleOrderInfo = new SaleOrderInfo(
                        resultSet.getLong("SaleOrderID"),
                        resultSet.getLong("UserID"),
                        resultSet.getLong("ProductID"),
                        resultSet.getInt("SaleOrderCount"),
                        resultSet.getTimestamp("SaleDate"),
                        resultSet.getBigDecimal("SaleProductPrice"),
                        resultSet.getInt("ReceiveStatus")
                );
                BigDecimal productSalePrice = productInfoDAO.getProductSalePriceByID(saleOrderInfo.getProductID());

                saleOrderInfo.setProductTotalPrice(new BigDecimal(saleOrderInfo.getSaleOrderCount()).
                        multiply(productSalePrice));
                saleOrderInfo.setProductUnitPrice(productSalePrice);
                saleOrderInfos.add(saleOrderInfo);
            }
            logger.info("Query all SALE order by id success");
        } catch (SQLException e) {
            logger.error("Query all SALE order by id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return saleOrderInfos;
    }

    public List<Long> getAllSaleOrderID()             //得到所有货单ID
    {
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        List<Long> saleOrderIDs = new ArrayList<>();
        logger.info("Query all sale order id");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT DISTINCT \"SaleOrderID\" FROM \"SaleOrder\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                saleOrderIDs.add(resultSet.getLong("SaleOrderID"));
            }
            logger.info("Query all sale order id success");
        } catch (SQLException e) {
            logger.error("Query all sale order id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        return saleOrderIDs;
    }

    public List<SaleOrderListInfo> getAllSaleListInfo()     //获取所有总货单的情况
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Long> saleOrderIDs = getAllSaleOrderID();
        List<SaleOrderListInfo> saleOrderListInfos = new ArrayList<>();
        logger.info("Query all sale order list");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"SaleOrder\" WHERE \"SaleOrderID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            for (long saleOrderID: saleOrderIDs) {
                boolean received = true;
                Timestamp date = null;
                BigDecimal totalPrice = null;
                preparedStatement.setLong(1, saleOrderID);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next() && received) {                              //received 如果为 0 则不再进入循环
                    received = resultSet.getInt("ReceiveStatus") == RECEIVE_STATE_RECEIVED;
                    date = resultSet.getTimestamp("SaleDate");
                    totalPrice = resultSet.getBigDecimal("SaleProductPrice");
                }
                SaleOrderListInfo saleOrderListInfo = new SaleOrderListInfo(saleOrderID, date, received, totalPrice);
                saleOrderListInfos.add(saleOrderListInfo);
            }
            logger.info("Query all sale order list success");
        } catch (SQLException e) {
            logger.error("Query all sale order list failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        return saleOrderListInfos;
    }

   /* public List<SaleOrderInfo> getAllSaleOrderInfos()      //获取所有货单情况 ，单的
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Long> saleOrderIDs = getAllSaleOrderID();
        List<SaleOrderListInfo>
    }*/
}
