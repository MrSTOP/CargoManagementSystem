package yanzichao.servlet;

import common.dao.ISupplierInfoDAO;
import yanzichao.dao.SupplierDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSupplier",urlPatterns = "/DeleteSupplier")
public class DeleteSupplier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISupplierInfoDAO iSupplierInfoDAO = new SupplierDAO();
        long SupplierID = Long.parseLong(request.getParameter("SupplierID"));
        response.getWriter().write(String.valueOf(iSupplierInfoDAO.deleteSupplier(SupplierID)));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
