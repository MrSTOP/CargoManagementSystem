package yanzichao.servlet;



import common.dao.ISupplierInfoDAO;
import yanzichao.bean.SupplierInfo;
import yanzichao.dao.SupplierDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetAllSupplier",urlPatterns = "/GetAllSupplier")
public class GetAllSupplier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISupplierInfoDAO iSupplierInfoDAO = new SupplierDAO();
        List<SupplierInfo> supplierInfos = new ArrayList<>();/*productInfoDAO.getAllProductInfo();*/
        supplierInfos = iSupplierInfoDAO.getAllSupplierInfo();
        request.setAttribute("AllSupplierInfo", supplierInfos);
        request.getRequestDispatcher("ShowAllsupplier.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
