package yankunwei.servlet;

import common.dao.IProductInfoDAO;
import yankunwei.dao.ProductInfoDAO;
import yankunwei.javabean.ProductInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyProduct", urlPatterns = "/ModifyProduct")
public class ModifyProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productID = Long.parseLong(request.getParameter("ProductID"));
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        ProductInfo productInfo = productInfoDAO.getProductInfoByID(productID);
        request.setAttribute("ProductInfo", productInfo);
        request.getRequestDispatcher("ModifyProduct.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
