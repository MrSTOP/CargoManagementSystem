package yankunwei.servlet;

import common.dao.IProductInfoDAO;
import yankunwei.dao.ProductInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExecDeleteProduct", urlPatterns = "/ExecDeleteProduct")
public class ExecDeleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        long productID = Long.parseLong(request.getParameter("ProductID"));
        response.getWriter().write(String.valueOf(productInfoDAO.deleteProductByID(productID)));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
