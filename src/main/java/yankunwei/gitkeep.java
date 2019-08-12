package yankunwei;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import yankunwei.utils.DataBaseHelper;
import yankunwei.utils.LoggerOutputStream;
import yankunwei.utils.LoggerRedirect;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class gitkeep {
    //Git提交空目录，pull后可以删除
    static final int T = 100;
    static ArrayList<Thread> threads = new ArrayList<>();
    public static void main(String[] args) {
//        LoggerPrintStream.redirectSystemOutAndErr();
        LoggerRedirect.getInstance().redirectSystemOutAndErr();
        System.out.println(String.format("FMT: %s", "AA", "BB", "CC"));
        conn();
//       try {
//           Class<?> fos = System.out.getClass().getSuperclass();
//           Field f = fos.getDeclaredField("ou threads");
//           System.out.println("F: " + f.getType().getName());
//       } catch (NoSuchFieldException e) {
//           e.printStackTrace();
//       }
//        Runnable r = () -> {
//            while (true) {
//                conn();
//            }
//        };
//        r.run();
        //for (int i = 0; i < T; i++) {
        //    Thread thread = new Thread(r);
        //    thread.start();
        //    threads.add(thread);
        //}
    }

    public static void conn() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DataBaseHelper.getConnection();
            String SQL = "SELECT * FROM \"User\"";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("UserID"));
                System.out.println(resultSet.getString("UserName"));
                System.out.println(resultSet.getString("Phone"));
                System.out.println(resultSet.getString("Email"));
                System.out.println(resultSet.getString("Address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseHelper.closeResource(resultSet, preparedStatement, connection);
        }
    }
}
