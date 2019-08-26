package yankunwei.servlet;

import common.dao.IBuyOrderInfoDAO;
import yankunwei.dao.BuyOrderInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MarkBuyOrderProductAsReceived", urlPatterns = "/MarkBuyOrderProductAsReceived")
public class MarkBuyOrderProductAsReceived extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBuyOrderInfoDAO buyOrderInfoDAO = new BuyOrderInfoDAO();
        long buyOrderID = Long.parseLong(request.getParameter("BuyOrderID"));
        long productID = Long.parseLong(request.getParameter("ProductID"));
        long supplierID = Long.parseLong(request.getParameter("SupplierID"));
        response.getWriter().write(String.valueOf(
                buyOrderInfoDAO.updateBuyOrderStatus(
                        buyOrderID, productID, supplierID, IBuyOrderInfoDAO.SUPPLIER_STATE_RECEIVED)));
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
