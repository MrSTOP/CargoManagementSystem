package pengchao.servlet;

import pengchao.dao.UserInfoDAO;
import pengchao.javabean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "FindAllUser",urlPatterns = "/FindAllUser")
public class FindAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // UserInfo userInfo = new UserInfo();
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        List<UserInfo> userInfoList = userInfoDAO.getAllUserInfo();
        request.setAttribute("AllUserInfo",userInfoList);
        request.getRequestDispatcher("ShowAllUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
