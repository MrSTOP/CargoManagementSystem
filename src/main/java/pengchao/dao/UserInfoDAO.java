package pengchao.dao;

import common.dao.IUserInfoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pengchao.javabean.UserInfo;
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
    public List<Long> getAllUserID() {
        List<Long> userIDs = new ArrayList<>();
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
                userIDs.add(resultSet.getLong("UserID"));
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

    @Override
    public boolean insertUser(UserInfo userInfo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int n;
        logger.info("Insert New User");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "INSERT INTO \"User\"(\"UserID\", \"UserName\", \"Phone\", \"Email\", \"Address\") VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1,userInfo.getUserID());
            preparedStatement.setString(2,userInfo.getUserName());
            preparedStatement.setString(3,userInfo.getPhone());
            preparedStatement.setString(4,userInfo.getEmail());
            preparedStatement.setString(5,userInfo.getAddress());
            n = preparedStatement.executeUpdate();
            if(n >0)
            {
                logger.info("Insert New User Success");
                return true;
            }
            else
            {
                logger.error("Insert New User Failed");
                return false;
            }

        } catch (SQLException e) {
            logger.error("Insert New User failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }

        return false;
    }
    @Override
    public boolean updateUser(UserInfo userInfo)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int n;
        logger.info("Update A User");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "UPDATE \"User\" SET \"UserName\" =? , \"Phone\" =? ,  \"Email\" =? , \"Address\" =? WHERE \"UserID\" = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(5, userInfo.getUserID());
            preparedStatement.setString(1, userInfo.getUserName());
            preparedStatement.setString(2, userInfo.getPhone());
            preparedStatement.setString(3, userInfo.getEmail());
            preparedStatement.setString(4, userInfo.getAddress());
            n = preparedStatement.executeUpdate();

            if(n >0)
            {
                logger.info("Update A User Success");
                return true;
            }
            else
            {
                logger.error("Update A User Failed");
                return false;
            }

        } catch (SQLException e) {
            logger.error("Update A User failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }

        return false;
    }
    @Override
    public boolean deleteUser(long userID) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int n;
        logger.info("Delete A User");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "DELETE from \"User\" WHERE \"UserID\" =?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1,userID);
            n = preparedStatement.executeUpdate();

            if(n >0)
            {
                logger.info("Delete A User Success");
                return true;
            }
            else
            {
                logger.error("Delete A User Failed");
                return false;
            }

        } catch (SQLException e) {
            logger.error("Delete A User failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }

        return false;
    }
    @Override
    public UserInfo getUserInfoByID(long userID)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserInfo userInfo = new UserInfo();
        logger.info("Find A User");
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"User\" WHERE \"UserID\" =?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1,userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                userInfo.setUserID(userID);
                userInfo.setUserName(resultSet.getString(2));
                userInfo.setPhone(resultSet.getString(3));
                userInfo.setEmail(resultSet.getString(4));
                userInfo.setAddress(resultSet.getString(5));
            }

        } catch (SQLException e) {
            logger.error("Find A User failed");
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }

        return userInfo;
    }
    @Override
    public List<UserInfo> getAllUserInfo()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<UserInfo> userInfos = new ArrayList<>();

        logger.info("Find All UserInfo");
        try
        {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT  * FROM \"User\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserID(resultSet.getLong(1));
                userInfo.setUserName(resultSet.getString(2));
                userInfo.setPhone(resultSet.getString(3));
                userInfo.setEmail(resultSet.getString(4));
                userInfo.setAddress(resultSet.getString(5));
                userInfos.add(userInfo);
            }
        }catch (SQLException e)
        {
            logger.error("Find All UserInfo Failed");
        }
        finally {
            DataBaseHelper.closeResource(null, preparedStatement, connection);
        }
        logger.info("Find All User Success");
        return userInfos;
    }
}