package yankunwei.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.utils.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO implements IUserInfoDAO {
    private Logger logger = LogManager.getLogger(UserInfoDAO.class);
    
    @Override
    public List<Integer> getAllUserID() {
        List<Integer> userIDs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        logger.info("Query All UserID");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT \"UserID\" FROM \"User\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userIDs.add(resultSet.getInt("UserID"));
            }
        } catch (SQLException e) {
            logger.error("Query All UserID failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        logger.info("Query All UserID success");
        return userIDs;
    }
}
