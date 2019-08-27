package pengchao.servlet;

import pengchao.dao.UserInfoDAO;
import pengchao.javabean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessUpdateUser", urlPatterns = "/ProcessUpdateUser")
public class ProcessUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        long userID = Long.parseLong(request.getParameter("UserID"));
        UserInfo userInfo = userInfoDAO.getUserInfoByID(userID);
        request.setAttribute("UserInfo", userInfo);
        request.getRequestDispatcher("UpdateUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
