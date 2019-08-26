package yankunwei.servlet;

import common.dao.IBuyOrderInfoDAO;
import yankunwei.dao.BuyOrderInfoDAO;
import yankunwei.javabean.BuyOrderInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowBuyOrderListDetail", urlPatterns = "/ShowBuyOrderListDetail")
public class ShowBuyOrderListDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long buyOrderListID = Long.parseLong(request.getParameter("BuyOrderListID"));
        IBuyOrderInfoDAO buyOrderInfoDAO = new BuyOrderInfoDAO();
        List<BuyOrderInfo> buyOrderInfos = buyOrderInfoDAO.getAllBuyOrderInfoByID(buyOrderListID);
        request.setAttribute("AllBuyOrderInfo", buyOrderInfos);
        request.setAttribute("SUPPLIER_STATE_RECEIVED", IBuyOrderInfoDAO.SUPPLIER_STATE_RECEIVED);
        request.getRequestDispatcher("ShowBuyOrderListDetail.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
