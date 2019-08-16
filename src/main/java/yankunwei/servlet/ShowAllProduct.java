package yankunwei.servlet;

import common.dao.IProductInfoDAO;
import yankunwei.dao.ProductInfoDAO;
import yankunwei.javabean.ProductInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowAllProduct", urlPatterns = "/ShowAllProduct")
public class ShowAllProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        List<ProductInfo> productInfos = new ArrayList<>();/*productInfoDAO.getAllProductInfo();*/
        for (int i = 0; i < 5; i++) {
            productInfos.add(new ProductInfo(i, 1, 1, "TTTT", new BigDecimal("152.2565"), new BigDecimal("100.2566"), "SDF啊搜地方还哦皮肤的规划司讴歌红负和哦啊是个覅偶阿三哥黑哦噶色UI岁哦瓜熟蒂递易风元素的一首歌费十多个佛山大概福iODFSERFER"));
        }
        request.setAttribute("AllProductInfo", productInfos);
        request.getRequestDispatcher("ShowAllProduct.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
