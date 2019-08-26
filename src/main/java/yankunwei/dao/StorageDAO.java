package yankunwei.dao;

import common.dao.IStorageDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.javabean.ProductInfo;
import yankunwei.utils.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageDAO implements IStorageDAO {
    private Logger logger = LogManager.getLogger(StorageDAO.class);
    
    @Override
    public boolean canSaleProduct(long productID, int count) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query Product id:{} count", productID);
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT \"ProductCount\" - ? AS COUNT FROM \"Storage\" WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, count);
            preparedStatement.setLong(2, productID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt("COUNT") >= 0) {
                logger.info("Query Product count success and can sale");
                return true;
            } else {
                logger.info("Query Product count success and can\'t sale");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Query product count failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.error("Query product count failed");
        return false;
    }
}
