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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowAllProduct", urlPatterns = "/ShowAllProduct")
public class ShowAllProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        List<ProductInfo> productInfos = productInfoDAO.getAllProductInfo();
        request.setAttribute("AllProductInfo", productInfos);
        request.getRequestDispatcher("ShowAllProduct.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
