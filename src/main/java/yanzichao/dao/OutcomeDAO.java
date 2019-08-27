package yanzichao.dao;

import common.dao.IoutcomeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.utils.DataBaseHelper;
import yanzichao.bean.Income;
import yanzichao.bean.Outcome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OutcomeDAO implements IoutcomeDAO {
    private Logger logger = LogManager.getLogger(OutcomeDAO.class);
    @Override
    public List<Outcome> getAlloutcome() {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            List<Outcome> outcomes = new ArrayList<>();
            logger.info("Query all outcome info");
            try {
                connection = DataBaseHelper.getConnection();
                String SQL = "SELECT * FROM \"Outcome\"";
                preparedStatement = connection.prepareStatement(SQL);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Outcome outcome = new Outcome();
                    outcome.setSupplierId(resultSet.getLong("SupplierID"));
                    outcome.setOutTime(resultSet.getTimestamp("OutTime"));
                    outcome.setOutPrice(resultSet.getBigDecimal("OutPrice"));
                    outcome.setOutSupplierId(resultSet.getLong("OutSupplierId"));
                    outcome.setDescription(resultSet.getString("Description"));
                    outcomes.add(outcome);
                }
            } catch (SQLException e) {
                logger.error("Query all outcome info failed");
                e.printStackTrace();
            } finally {
                DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
            }
            logger.info("Query all outcome info success");
            return outcomes;

    }
}
