package yanzichao.dao;

import common.dao.ISupplierInfoDAO;
import yankunwei.utils.DataBaseHelper;
import yanzichao.bean.SupplierInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierInfoDAO {
    private Logger logger = LogManager.getLogger(SupplierDAO.class);
    @Override
    public List<Long> getAllSupplierID() {

        List<Long> SupplierIDs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query All ProductID");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT \"SupplierID\" FROM \"Supplier\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SupplierIDs.add(resultSet.getLong("SupplierID"));
            }
        } catch (SQLException e) {
            logger.error("Query All SupplierID failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query All ProductID success");
        return SupplierIDs;
    }

    @Override
    public boolean deleteSupplier(long SupplierID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Delete Supplier");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "DELETE  FROM \"Supplier\" where \"SupplierID\" = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, SupplierID);
            if(preparedStatement.executeUpdate() == 1)
            {
                logger.info("Delete  Supplier success");
                return true;
            }
        } catch (SQLException e) {
            logger.error("Delete  Supplier failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public List<SupplierInfo> getAllSupplierInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SupplierInfo> supplierInfos = new ArrayList<>();
        logger.info("Query all supplier info");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"Supplier\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SupplierInfo supplierInfo = new SupplierInfo(
                        resultSet.getLong("SupplierID"),
                        resultSet.getString("SupplierName"),
                        resultSet.getString("SupplierDescription"),
                        resultSet.getString("SupplierAddress"));
                supplierInfos.add(supplierInfo);
            }
        } catch (SQLException e) {
            logger.error("Query all Supplier info failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query all Supplier info success");
        return supplierInfos;
    }


    @Override
    public boolean updateSupplier(SupplierInfo supplierInfo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Update Supplier");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE  \"Supplier\" SET \"SupplierName\" = ? , \"SupplierDescription\" = ?, \"SupplierAddress\" = ? where \"SupplierID\" = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, supplierInfo.getSupplierName());
            preparedStatement.setString(2, supplierInfo.getSupplierDescription());
            preparedStatement.setString(3, supplierInfo.getSupplierAddress());
            preparedStatement.setLong(4, supplierInfo.getSupplierID());
            if(preparedStatement.executeUpdate() == 1)
            {
                logger.info("Update  Supplier success");
                return true;
            }
        } catch (SQLException e) {
            logger.error("Update  Supplier failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public SupplierInfo findSupplier(long SupplierID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SupplierInfo supplierInfos = new SupplierInfo();
        logger.info("find A supplier info");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"Supplier\" where \"SupplierID\" = ? ";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                supplierInfos.setSupplierID(resultSet.getLong("SupplierID"));
                supplierInfos.setSupplierName(resultSet.getString("SupplierName"));
                supplierInfos.setSupplierDescription(resultSet.getString("SupplierDescription"));
                supplierInfos.setSupplierAddress(resultSet.getString("SupplierAddress"));
            }
        } catch (SQLException e) {
            logger.error("find supplier info failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("find supplier info success");
        return supplierInfos;
    }

    @Override
    public boolean insertSupplier(SupplierInfo supplierInfo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Update Supplier");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "CALL SUPPLIER_INSERT(?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, supplierInfo.getSupplierName());
            preparedStatement.setString(2, supplierInfo.getSupplierDescription());
            preparedStatement.setString(3, supplierInfo.getSupplierAddress());
            if(preparedStatement.executeUpdate() == 1)
            {
                logger.info("insert  Supplier success");
                return true;
            }
        } catch (SQLException e) {
            logger.error("insert  Supplier failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
}

