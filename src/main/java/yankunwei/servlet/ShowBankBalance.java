package yankunwei.servlet;

import common.dao.IBankDAO;
import yankunwei.dao.BankDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "ShowBankBalance", urlPatterns = "/ShowBankBalance")
public class ShowBankBalance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBankDAO bankDAO = new BankDAO();
        BigDecimal bankBalance = bankDAO.getBankBalance();
        request.setAttribute("BankBalance", bankBalance);
        request.getRequestDispatcher("ShowBankBalance.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
