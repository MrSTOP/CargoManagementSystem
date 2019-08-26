package yankunwei.servlet;

import common.dao.IBuyOrderInfoDAO;
import yankunwei.dao.BuyOrderInfoDAO;
import yankunwei.javabean.BuyOrderListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllBuyOrderListStatus", urlPatterns = "/ShowAllBuyOrderListStatus")
public class ShowAllBuyOrderListStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBuyOrderInfoDAO buyOrderInfoDAO = new BuyOrderInfoDAO();
        List<BuyOrderListInfo> buyOrderListInfos = buyOrderInfoDAO.getAllBuyListInfo();
        request.setAttribute("AllBuyOrderList", buyOrderListInfos);
        request.getRequestDispatcher("ShowAllBuyOrder.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
