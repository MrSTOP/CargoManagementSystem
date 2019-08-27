package pengchao;

import pengchao.dao.UserInfoDAO;
import pengchao.javabean.*;
import yankunwei.dao.SaleOrderInfoDAO;
import yankunwei.javabean.SaleOrderInfo;


import java.util.ArrayList;
import java.util.List;

public class gitkeep {
      //Git提交空目录，pull后可以删除
    public static void main(String[] args)
    {
        //UserInfo userInfo = new UserInfo(2,"pb","1523658452","1555@126.com","11路");
     //   UserInfoDAO userInfoDAO = new UserInfoDAO();
       // List<Long> userList = userInfoDAO.getAllUserID();
        //List<UserInfo> userInfos = new ArrayList();

       // userInfos = userInfoDAO.getAllUserInfo();
        // long userID;
       /* for(int i=0; i<userList.size(); i++)
        {
            userID = userList.get(i);
            System.out.println(userID);
        }*/

    //   userInfoDAO.deleteUser(2);

       //System.out.println(userInfo.getUserName());
        /*
            UserInfo userInfo = userInfos.get(0);
            System.out.println(userInfo.getUserName());
            System.out.println(userInfo.getAddress());
            System.out.println(userInfo.getEmail());
            System.out.println(userInfo.getPhone());
            System.out.println(0);
        */

        SaleOrderInfoDAO saleOrderInfoDAO = new SaleOrderInfoDAO();
        //SaleOrderInfo saleOrderInfo = new SaleOrderInfo();
        System.out.println(saleOrderInfoDAO.getAllSaleOrderID().get(0));
    }

}
