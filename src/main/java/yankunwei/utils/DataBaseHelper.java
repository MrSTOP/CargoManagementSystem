package yankunwei.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseHelper {

    public static final String DriverName;
    public static final String DBName;
    public static final String DBPort;
    public static final String UserName;
    public static final String Password;
    public static final String DBURL;
    public static final Logger logger;

    static  {
        logger = LogManager.getLogger(DataBaseHelper.class);
        logger.info("Start loading Database Config ...");
        Properties properties = new Properties();
        try {
            properties.load(DataBaseHelper.class.getResourceAsStream("/Config.properties"));
        } catch (IOException e) {
            logger.fatal("Load Database config file failed");
            e.printStackTrace();
        }
        DriverName = properties.getProperty("DriverName");
        DBName = properties.getProperty("DBName");
        DBPort = properties.getProperty("DBPort");
        UserName = properties.getProperty("UserName");
        Password = properties.getProperty("Password");
        DBURL = String.format(properties.getProperty("DBURLFormat"),
                              DBPort, DBName);
        logger.info("Load Database Config success");
        logger.info("Start Loading Driver ...");
        try {
            Class.forName(DriverName);
        } catch (ClassNotFoundException e) {
            logger.fatal("Loading Driver failed");
            e.printStackTrace();
        }
        logger.info("Loading Driver success");
    }

    public static Connection getConnection() throws SQLException {
        logger.info("Getting Database Connection ...");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, UserName, Password);
        } catch (Exception e) {
            logger.error("Get Database Connection failed");
            e.printStackTrace();
        }
        logger.info("Get Database Connection success");
        return connection;
    }

    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                logger.info("Closing ResultSet ...");
                resultSet.close();
                logger.info("Close ResultSet success");
            } catch (SQLException e) {
                logger.error("Close ResultSet failed");
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                logger.info("Closing Statement ...");
                statement.close();
                logger.info("Close Statement success");
            } catch (SQLException e) {
                logger.error("Close Statement failed");
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                logger.info("Closing Connection ...");
                connection.close();
                logger.info("Close Connection success");
            } catch (SQLException e) {
                logger.error("Close Connection failed");
                e.printStackTrace();
            }
        }
    }
}
