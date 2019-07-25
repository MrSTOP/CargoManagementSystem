package yankunwei.utils;

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

    static  {
        Properties properties = new Properties();
        try {
            if (DataBaseHelper.class.getResourceAsStream("/main/java/yankunwei/Config.properties") == null) {
                System.out.println("DDDD");
            }
            properties.load(DataBaseHelper.class.getResourceAsStream("/yankunwei/Config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverName = properties.getProperty("DriverName");
        DBName = properties.getProperty("DBName");
        DBPort = properties.getProperty("DBPort");
        UserName = properties.getProperty("UserName");
        Password = properties.getProperty("Password");
        DBURL = String.format(properties.getProperty("DBURLFormat"),
                              DBName, UserName, Password);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(DBURL, UserName, Password);
        return connection;
    }

    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
