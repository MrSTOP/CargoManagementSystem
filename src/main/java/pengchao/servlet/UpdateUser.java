package pengchao.servlet;

import pengchao.dao.UserInfoDAO;
import pengchao.javabean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUser",urlPatterns = "/UpdateUser")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo = new UserInfo();
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfo.setUserName(request.getParameter("UserName"));
        userInfo.setPhone(request.getParameter("Phone"));
        userInfo.setEmail(request.getParameter("Email"));
        userInfo.setAddress(request.getParameter("Address"));
        userInfo.setUserID(Long.parseLong(request.getParameter("UserID")));
        boolean bingo = userInfoDAO.updateUser(userInfo);
        response.getWriter().write(String.valueOf(bingo));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
