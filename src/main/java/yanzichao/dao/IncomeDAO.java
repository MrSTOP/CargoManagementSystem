package yanzichao.dao;

import common.dao.IIncomeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.utils.DataBaseHelper;
import yanzichao.bean.Income;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO implements IIncomeDAO {
    private Logger logger = LogManager.getLogger(IncomeDAO.class);
    @Override
    public List<Income> getAllincome() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Income> incomes = new ArrayList<>();
        logger.info("Query all supplier info");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"Income\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Income income = new Income();
                income.setUserId(resultSet.getLong("UserID"));
                income.setSaleTime(resultSet.getTimestamp("SaleTime"));
                income.setSalePrice(resultSet.getBigDecimal("SalePrice"));
                income.setSaleIncomeOrderId(resultSet.getLong("SaleIncomeOrderID"));
                income.setDescription(resultSet.getString("Description"));
                incomes.add(income);
            }
        } catch (SQLException e) {
            logger.error("Query all income info failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query all income info success");
        return incomes;
    }
}
