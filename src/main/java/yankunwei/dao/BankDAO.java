package yankunwei.dao;

import common.dao.IBankDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.utils.DataBaseHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO implements IBankDAO {
    private Logger logger = LogManager.getLogger(BankDAO.class);
    
    @Override
    public BigDecimal getBankBalance() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BigDecimal bankBalance = null;
        logger.info("Query company account balance");
        try {
            connection = DataBaseHelper.getConnection();
            //language=SQL
            String SQL = "SELECT * FROM \"Bank\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bankBalance = resultSet.getBigDecimal("CompanyAccount");
            }
        } catch (SQLException e) {
            logger.error("Query company account balance failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query company account balance success");
        return bankBalance;
    }
    
    @Override
    public boolean setBankBalance(BigDecimal bankBalance) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Set company account balance");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE \"Bank\" SET \"CompanyAccount\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setBigDecimal(1, bankBalance);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Set bank balance success");
                return true;
            } else {
                logger.error("Set bank balance failed");
            }
        } catch (SQLException e) {
            logger.error("Set bank balance failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
    
    @Override
    public boolean bankBalanceAdd(BigDecimal add) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Company account add {}", add);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE \"Bank\" SET \"CompanyAccount\"=\"CompanyAccount\"+?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setBigDecimal(1, add);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Company account add success");
                return true;
            } else {
                logger.error("Company account add failed");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Company account add failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
    
    @Override
    public boolean bankBalanceSub(BigDecimal sub) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        logger.info("Company account sub {}", sub);
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE \"Bank\" SET \"CompanyAccount\"=\"CompanyAccount\"-?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setBigDecimal(1, sub);
            if (preparedStatement.executeUpdate() == 1) {
                logger.info("Company account sub success");
                return true;
            } else {
                logger.error("Company account sub failed");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Company account sub failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        return false;
    }
}
