package yankunwei.servlet;

import yankunwei.dao.SaleOrderInfoDAO;
import yankunwei.javabean.SaleOrderInfo;
import yankunwei.javabean.SaleOrderListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowSaleOrderListDetail", urlPatterns = "/ShowSaleOrderListDetail")
public class ShowSaleOrderListDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long saleOrderListID = Long.parseLong(request.getParameter("SaleOrderListID"));
        SaleOrderInfoDAO saleOrderInfoDAO = new SaleOrderInfoDAO();
        List<SaleOrderInfo> saleOrderInfos = saleOrderInfoDAO.getAllSaleOrderInfoByID(saleOrderListID);
        request.setAttribute("AllSaleOrderInfo", saleOrderInfos);
        request.setAttribute("SALE_STATE_RECEIVED", SaleOrderInfoDAO.RECEIVE_STATE_RECEIVED);

        request.getRequestDispatcher("ShowSaleOrderListDetail.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
