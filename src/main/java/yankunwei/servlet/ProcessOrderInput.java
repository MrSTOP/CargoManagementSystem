package yankunwei.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yankunwei.jsonObj.OrderInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProcessOrderInput", urlPatterns = "/ProcessOrderInput")
public class ProcessOrderInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(ProcessOrderInput.class);
        String JSONData = request.getParameter("JSONOrderInfoStr");
        logger.debug(JSONData);
        Gson gson = new Gson();
        List<OrderInfo> orderInfos = gson.fromJson(JSONData, new TypeToken<ArrayList<OrderInfo>>(){}.getType());
        for (OrderInfo i: orderInfos) {
            System.out.println(i);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
