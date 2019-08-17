package yankunwei.dao;

import common.dao.IProductInfoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.javabean.ProductInfo;
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
    public List<Long> getAllProductID() {
        List<Long> productIDs = new ArrayList<>();
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
                productIDs.add(resultSet.getLong("ProductID"));
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
    public BigDecimal getProductSalePriceByID(long productID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BigDecimal price = null;
        logger.info("Query product price. productID:{}", productID);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT \"ProductSalePrice\" FROM \"Product\" WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, productID);
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
    
    @Override
    public ProductInfo getProductInfoByID(long productID) {
        ProductInfo productInfo = new ProductInfo();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query product info ID:{}", productInfo);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"Product\" WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, productID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productInfo.setProductID(resultSet.getLong("ProductID"));
                productInfo.setSupplierID(resultSet.getLong("SupplierID"));
                productInfo.setSupplierOrderID(resultSet.getLong("SupplierOrderID"));
                productInfo.setProductName(resultSet.getString("ProductName"));
                productInfo.setProductSalePrice(resultSet.getBigDecimal("ProductSalePrice"));
                productInfo.setProductBuyPrice(resultSet.getBigDecimal("ProductBuyPrice"));
                productInfo.setProductDescription(resultSet.getString("ProductDescription"));
            }
        } catch (SQLException e) {
            logger.error("Query product info failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query product info success");
        return productInfo;
    }
    
    @Override
    public boolean insertProduct(ProductInfo productInfo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Insert new product Name:{}", productInfo.getProductName());
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "INSERT INTO \"Product\"(\"ProductID\", \"SupplierID\", \"SupplierOrderID\", \"ProductName\", \"ProductSalePrice\", \"ProductBuyPrice\", \"ProductDescription\") VALUES (PRODUCT_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, productInfo.getSupplierID());
            preparedStatement.setLong(2, productInfo.getSupplierOrderID());
            preparedStatement.setString(3, productInfo.getProductName());
            preparedStatement.setBigDecimal(4, productInfo.getProductSalePrice());
            preparedStatement.setBigDecimal(5, productInfo.getProductBuyPrice());
            preparedStatement.setString(6, productInfo.getProductDescription());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Insert new product success");
                return true;
            } else {
                logger.error("Insert new product failed");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Insert new product failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
    
    @Override
    public boolean updateProduct(ProductInfo productInfo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Update product info ID:{}", productInfo.getProductID());
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE \"Product\" SET \"ProductID\"=?, \"SupplierID\"=?, \"SupplierOrderID\"=?, \"ProductName\"=?, \"ProductSalePrice\"=?, \"ProductBuyPrice\"=?, \"ProductDescription\"=? WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, productInfo.getProductID());
            preparedStatement.setLong(2, productInfo.getSupplierID());
            preparedStatement.setLong(3, productInfo.getSupplierOrderID());
            preparedStatement.setString(4, productInfo.getProductName());
            preparedStatement.setBigDecimal(5, productInfo.getProductSalePrice());
            preparedStatement.setBigDecimal(6, productInfo.getProductBuyPrice());
            preparedStatement.setString(7, productInfo.getProductDescription());
            preparedStatement.setLong(8, productInfo.getProductID());
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Update product info success");
                return true;
            } else {
                logger.error("Update product info failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        logger.error("Update product info failed");
        return false;
    }
    
    @Override
    public boolean deleteProduct(ProductInfo productInfo) {
        return this.deleteProductByID(productInfo.getProductID());
    }
    
    @Override
    public boolean deleteProductByID(long productID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Delete product ID:{}", productID);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "DELETE FROM \"Product\" WHERE \"ProductID\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, productID);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Delete product success");
                return true;
            } else {
                logger.error("Delete product failed");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Delete product failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
    
    @Override
    public List<ProductInfo> getAllProductInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ProductInfo> productInfos = new ArrayList<>();
        logger.info("Query all product info");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"Product\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductInfo productInfo = new ProductInfo(
                        resultSet.getLong("ProductID"),
                        resultSet.getLong("SupplierID"),
                        resultSet.getLong("SupplierOrderID"),
                        resultSet.getString("ProductName"),
                        resultSet.getBigDecimal("ProductSalePrice"),
                        resultSet.getBigDecimal("ProductBuyPrice"),
                        resultSet.getString("ProductDescription"));
                productInfos.add(productInfo);
            }
        } catch (SQLException e) {
            logger.error("Query all product info failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query all product info success");
        return productInfos;
    }
}
