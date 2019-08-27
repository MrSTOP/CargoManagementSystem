package yankunwei.dao;

import common.dao.IBuyOrderInfoDAO;
import common.dao.IProductInfoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.javabean.BuyOrderInfo;
import yankunwei.javabean.BuyOrderListInfo;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyOrderInfoDAO implements IBuyOrderInfoDAO {
    private Logger logger = LogManager.getLogger(BuyOrderInfoDAO.class);
    
    @Override
    public boolean insertBuyOrder(List<BuyOrderInfo> buyOrderInfos) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        long supplierOrderID = getNewSupplierOrderID();
        logger.info("Insert new buy order");
        BigDecimal totalPrice = new BigDecimal("0.0");
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        for (BuyOrderInfo buyOrderInfo: buyOrderInfos) {
            BigDecimal productPrice = productInfoDAO.getProductBuyPriceByID(buyOrderInfo.getProductID());
            buyOrderInfo.setSupplierID(productInfoDAO.getSupplierByID(buyOrderInfo.getProductID()));
            totalPrice = totalPrice.add(productPrice.multiply(new BigDecimal(buyOrderInfo.getSupplierCount())));
        }
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "INSERT INTO \"BuyOrder\"(\"SupplierOrderID\", \"ProductID\", \"SupplierID\", \"SupplierDate\", \"SupplierStatus\", \"SupplierCount\", \"SupplierPrice\") VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            for (BuyOrderInfo buyOrderInfo: buyOrderInfos) {
                preparedStatement.setLong(1, supplierOrderID);
                preparedStatement.setLong(2, buyOrderInfo.getProductID());
                preparedStatement.setLong(3, buyOrderInfo.getSupplierID());
                preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                preparedStatement.setInt(5, IBuyOrderInfoDAO.SUPPLIER_STATE_NOT_RECEIVED);
                preparedStatement.setInt(6, buyOrderInfo.getSupplierCount());
                preparedStatement.setBigDecimal(7, totalPrice);
                preparedStatement.executeUpdate();
            }
            logger.info("Insert new buy order success");
            return true;
        } catch (SQLException e) {
            logger.error("Insert new buy order failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
    
    @Override
    public boolean updateBuyOrderStatus(long supplierOrderID, long productID, long supplierID, int status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Update buy order state");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "UPDATE \"BuyOrder\" SET \"SupplierStatus\"=? WHERE \"SupplierOrderID\"=? AND \"ProductID\"=? AND \"SupplierID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, status);
            preparedStatement.setLong(2, supplierOrderID);
            preparedStatement.setLong(3, productID);
            preparedStatement.setLong(4, supplierID);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update buy order state success");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            logger.error("Update buy order state failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        logger.error("Update buy order state failed");
        return false;
    }
    
    private long getNewSupplierOrderID() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query new supplierOrderID");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT BUY_ORDER_ID_SEQ.nextval AS BUY_ORDER_ID FROM DUAL";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long buyOrderID = resultSet.getLong("BUY_ORDER_ID");
            logger.info("Query new buy order id success");
            return buyOrderID;
        } catch (SQLException e) {
            logger.error("Query new buy order id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.error("Query new buy order id failed");
        return -1;
    }
    
    @Override
    public List<BuyOrderInfo> getAllBuyOrderInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BuyOrderInfo> buyOrderInfos = new ArrayList<>();
        logger.info("Query all buy order");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"BuyOrder\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BuyOrderInfo buyOrderInfo = new BuyOrderInfo(
                        resultSet.getLong("SupplierOrderID"),
                        resultSet.getLong("ProductID"),
                        resultSet.getLong("SupplierID"),
                        resultSet.getTimestamp("SupplierDate"),
                        resultSet.getInt("SupplierStatus"),
                        resultSet.getInt("SupplierCount"),
                        resultSet.getBigDecimal("SupplierPrice")
                );
                buyOrderInfos.add(buyOrderInfo);
            }
            logger.info("Query all buy order success");
        } catch (SQLException e) {
            logger.error("Query all buy order failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return buyOrderInfos;
    }
    
    @Override
    public List<BuyOrderInfo> getAllBuyOrderInfoByID(long supplierOrderID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BuyOrderInfo> buyOrderInfos = new ArrayList<>();
        logger.info("Query all buy order id:{}", supplierOrderID);
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"BuyOrder\" WHERE \"SupplierOrderID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, supplierOrderID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BuyOrderInfo buyOrderInfo = new BuyOrderInfo(
                        resultSet.getLong("SupplierOrderID"),
                        resultSet.getLong("ProductID"),
                        resultSet.getLong("SupplierID"),
                        resultSet.getTimestamp("SupplierDate"),
                        resultSet.getInt("SupplierStatus"),
                        resultSet.getInt("SupplierCount"),
                        resultSet.getBigDecimal("SupplierPrice")
                );
                BigDecimal productBuyPrice = productInfoDAO.
                        getProductBuyPriceByID(buyOrderInfo.getProductID());
                buyOrderInfo.setCurrentProductPrice(
                        new BigDecimal(buyOrderInfo.getSupplierCount()).
                                multiply(productBuyPrice));
                buyOrderInfo.setCurrentProductBuyPrice(productBuyPrice);
                buyOrderInfos.add(buyOrderInfo);
            }
            logger.info("Query all buy order by id success");
        } catch (SQLException e) {
            logger.error("Query all buy order by id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return buyOrderInfos;
    }
    
    private List<Long> getAllBuyOrderID() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Long> buyOrderIDs = new ArrayList<>();
        logger.info("Query all buy order id");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT DISTINCT \"SupplierOrderID\" FROM \"BuyOrder\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buyOrderIDs.add(resultSet.getLong("SupplierOrderID"));
            }
            logger.info("Query all buy order id success");
        } catch (SQLException e) {
            logger.error("Query all buy order id failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        return buyOrderIDs;
    }
    
    @Override
    public List<BuyOrderListInfo> getAllBuyListInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Long> buyOrderIDs = getAllBuyOrderID();
        List<BuyOrderListInfo> buyOrderListInfos = new ArrayList<>();
        logger.info("Query all buy order list");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"BuyOrder\" WHERE \"SupplierOrderID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            for (long buyOrderID: buyOrderIDs) {
                boolean received = true;
                Timestamp date = null;
                BigDecimal totalPrice = null;
                preparedStatement.setLong(1, buyOrderID);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next() && received) {
                    received = resultSet.getInt("SupplierStatus") == SUPPLIER_STATE_RECEIVED;
                    date = resultSet.getTimestamp("SupplierDate");
                    totalPrice = resultSet.getBigDecimal("SupplierPrice");
                }
                BuyOrderListInfo buyOrderListInfo = new BuyOrderListInfo(buyOrderID, date, received, totalPrice);
                buyOrderListInfos.add(buyOrderListInfo);
            }
            logger.info("Query all buy order list success");
        } catch (SQLException e) {
            logger.error("Query all buy order list failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        return buyOrderListInfos;
    }
}
