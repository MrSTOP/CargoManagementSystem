package pengchao.servlet;

import yankunwei.dao.SaleOrderInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSaleOrdreStatusReceived", urlPatterns = "/UpdateSaleOrdreStatusReceived")
public class UpdateSaleOrdreStatusReceiced extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long saleOrderID = Long.parseLong(request.getParameter("SaleOrderID"));
        long productID = Long.parseLong(request.getParameter("ProductID"));
        long userID = Long.parseLong(request.getParameter("UserID"));
        SaleOrderInfoDAO saleOrderInfoDAO = new SaleOrderInfoDAO();

        response.getWriter().write(String.valueOf(
                saleOrderInfoDAO.updateSaleOrderStatus(
                        saleOrderID, productID, userID, SaleOrderInfoDAO.RECEIVE_STATE_RECEIVED)));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
