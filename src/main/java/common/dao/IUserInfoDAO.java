package common.dao;

import java.util.List;
import pengchao.javabean.UserInfo;
public interface IUserInfoDAO {
    List<Long> getAllUserID();   //查询全部ID

    UserInfo getUserInfoByID(long userID);  //以ID查询信息

    boolean insertUser(UserInfo userInfo);

    boolean updateUser(UserInfo userInfo);

    boolean deleteUser(long userID);

    List<UserInfo> getAllUserInfo();

    boolean IsIDUseful(long userID);

    long getNewSaleOrderID();
}
