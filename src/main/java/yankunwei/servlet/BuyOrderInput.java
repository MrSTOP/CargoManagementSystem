package yankunwei.servlet;

import common.dao.IProductInfoDAO;
import common.dao.ISupplierInfoDAO;
import yankunwei.dao.ProductInfoDAO;
import yanzichao.dao.SupplierDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuyOrderInput", urlPatterns = "/BuyOrderInput")
public class BuyOrderInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISupplierInfoDAO supplierDAO = new SupplierDAO();
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        List<Long> products = productInfoDAO.getAllProductID();
        List<Long> suppliers = supplierDAO.getAllSupplierID();
        request.setAttribute("AllSupplier", suppliers);
        request.setAttribute("AllProduct", products);
        request.getRequestDispatcher("BuyOrderInput.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
