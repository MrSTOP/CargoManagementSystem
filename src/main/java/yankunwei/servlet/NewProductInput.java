package yankunwei.servlet;

import common.dao.ISupplierInfoDAO;
import yanzichao.dao.SupplierDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewProductInput", urlPatterns = "/NewProductInput")
public class NewProductInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISupplierInfoDAO supplierInfoDAO = new SupplierDAO();
        List<Long> suppliers = supplierInfoDAO.getAllSupplierID();
        request.setAttribute("AllSupplierID", suppliers);
        request.getRequestDispatcher("NewProductInput.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
