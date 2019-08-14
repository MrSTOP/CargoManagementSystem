package yankunwei.servlet;

import yankunwei.dao.IProductInfoDAO;
import yankunwei.dao.IUserInfoDAO;
import yankunwei.dao.ProductInfoDAO;
import yankunwei.dao.UserInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderInput", urlPatterns = "/OrderInput")
public class OrderInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserInfoDAO userInfoDAO = new UserInfoDAO();
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        List<Integer> userIDs = userInfoDAO.getAllUserID();
        List<Integer> productIDs = productInfoDAO.getAllProductID();
        request.setAttribute("AllUserID", userIDs);
        request.setAttribute("AllProductID", productIDs);
        request.getRequestDispatcher("OrderInput.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
