package yankunwei;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import yankunwei.jsonObj.OrderInfo;
import yankunwei.utils.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gitkeep {
    public static void main(String[] args) {
        String JSONData = "[{\"userID\":\"123\",\"productID\":\"456\",\"productCount\":\"789\"},{\"userID\":\"123\",\"productID\":\"45\",\"productCount\":\"789\"},{\"userID\":\"123\",\"productID\":\"4\",\"productCount\":\"789\"},{\"userID\":\"123\",\"productID\":\"5\",\"productCount\":\"789\"}]";
        Gson gson = new Gson();
        List<OrderInfo> orderInfos = gson.fromJson(JSONData, new TypeToken<ArrayList<OrderInfo>>(){}.getType());
        for (OrderInfo i: orderInfos) {
            System.out.println(i);
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"User\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("UserName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
    }
}
