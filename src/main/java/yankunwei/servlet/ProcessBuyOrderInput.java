package yankunwei.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import common.dao.IBuyOrderInfoDAO;
import yankunwei.dao.BuyOrderInfoDAO;
import yankunwei.javabean.BuyOrderInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProcessBuyOrderInput", urlPatterns = "/ProcessBuyOrderInput")
public class ProcessBuyOrderInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String JSONData = request.getParameter("BuyOrder");
        IBuyOrderInfoDAO buyOrderInfoDAO = new BuyOrderInfoDAO();
        Gson gson = new Gson();
        List<BuyOrderInfo> buyOrderInfos = gson.fromJson(JSONData, new TypeToken<ArrayList<BuyOrderInfo>>(){}.getType());
        //response.getWriter().write(String.valueOf(buyOrderInfoDAO.insertBuyOrder(buyOrderInfos)));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
