package yankunwei.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoDAO implements IProductInfoDAO {
    private Logger logger = LogManager.getLogger(ProductInfoDAO.class);
    
    @Override
    public List<Integer> getAllProductID() {
        List<Integer> productIDs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query All ProductID");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT \"ProductID\" FROM \"Product\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productIDs.add(resultSet.getInt("ProductID"));
            }
        } catch (SQLException e) {
            logger.error("Query All ProductID failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query All ProductID success");
        return productIDs;
    }
    
    @Override
    public BigDecimal getProductSalePriceByID(int productID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BigDecimal price = null;
        logger.info("Query product price. productID:{}", productID);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT \"ProductSalePrice\" FROM \"Product\" WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, productID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                price = resultSet.getBigDecimal("ProductSalePrice");
            }
        } catch (SQLException e) {
            logger.error("Query product price failed.");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query product price success. productID:{} price:{}", productID, price);
        return price;
    }
}
