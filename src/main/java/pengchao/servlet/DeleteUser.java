package pengchao.servlet;

import pengchao.dao.UserInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUser",urlPatterns = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserInfoDAO userInfoDAO = new UserInfoDAO();
        long userID = Long.parseLong(request.getParameter("UserID"));
        boolean bingo = userInfoDAO.deleteUser(userID);
        response.getWriter().write(String.valueOf(bingo));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
