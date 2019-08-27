package yankunwei.dao;

import common.dao.IAdministratorDAO;
import yankunwei.utils.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDAO implements IAdministratorDAO {
    @Override
    public boolean checkAdministrator(String userName, String passwordEncrypted) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DataBaseHelper.getConnection();
            //language=Oracle
            String SQL = "SELECT * FROM \"Administrator\" WHERE \"UserName\"=? AND \"PassWord\"=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passwordEncrypted);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
        return false;
    }
}
