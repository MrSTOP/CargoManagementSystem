package yankunwei.servlet;

import common.dao.IAdministratorDAO;
import yankunwei.dao.AdministratorDAO;
import yankunwei.utils.MD5Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginCheck", urlPatterns = "/LoginCheck")
public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("UserName");
        String passwordEncrypted = MD5Tool.MD5Encrypt(request.getParameter("Password"));
        IAdministratorDAO administratorDAO = new AdministratorDAO();
        response.getWriter().write(String.valueOf(administratorDAO.checkAdministrator(userName, passwordEncrypted)));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
