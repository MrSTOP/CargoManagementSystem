package yankunwei.servlet;

import yankunwei.dao.SaleOrderInfoDAO;
import yankunwei.javabean.SaleOrderInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import yankunwei.javabean.SaleOrderListInfo;


@WebServlet(name = "ShowAllSaleOrderListStatus",urlPatterns = "/ShowAllSaleOrderListStatus")
public class ShowAllSaleOrderListStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SaleOrderInfoDAO saleOrderInfoDAO = new SaleOrderInfoDAO();
        List<SaleOrderListInfo> saleOrderInfoList = saleOrderInfoDAO.getAllSaleListInfo();   //获取货单总况
        request.setAttribute("AllSaleOrderList", saleOrderInfoList);
        request.getRequestDispatcher("ShowAllSaleOrder.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
