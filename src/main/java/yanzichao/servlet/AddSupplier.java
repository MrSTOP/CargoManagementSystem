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

@WebServlet(name = "AddSupplier",urlPatterns = "/AddSupplier")
public class AddSupplier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISupplierInfoDAO iSupplierInfoDAO = new SupplierDAO();
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSupplierName(request.getParameter("SupplierName"));
        supplierInfo.setSupplierDescription(request.getParameter("SupllierDescruption"));
        supplierInfo.setSupplierAddress(request.getParameter("SupplierAddress"));
//        supplierInfo.setSupplierID(Long.parseLong(request.getParameter("SupplierID")));
        response.getWriter().write(String.valueOf(iSupplierInfoDAO.insertSupplier(supplierInfo)));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
