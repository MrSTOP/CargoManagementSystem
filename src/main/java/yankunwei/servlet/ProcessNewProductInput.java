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

@WebServlet(name = "ProcessNewProductInput", urlPatterns = "/ProcessNewProductInput")
public class ProcessNewProductInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductInfoDAO productInfoDAO = new ProductInfoDAO();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setSupplierID(Long.parseLong(request.getParameter("SupplierID")));
        productInfo.setProductName(request.getParameter("ProductName"));
        productInfo.setProductSalePrice(new BigDecimal(request.getParameter("ProductSalePrice")));
        productInfo.setProductBuyPrice(new BigDecimal(request.getParameter("ProductBuyPrice")));
        productInfo.setProductDescription(request.getParameter("ProductDescription"));
        response.getWriter().write(String.valueOf(productInfoDAO.insertProduct(productInfo)));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
