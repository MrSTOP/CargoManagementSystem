package yanzichao.servlet;

import common.dao.IIncomeDAO;
import common.dao.IoutcomeDAO;
import yanzichao.bean.Income;
import yanzichao.bean.Outcome;
import yanzichao.dao.IncomeDAO;
import yanzichao.dao.OutcomeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletGetAllOutcome", urlPatterns = "/ServletGetAllOutcome")
public class ServletGetAllOutcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IoutcomeDAO ioutcomeDAO = new OutcomeDAO();
        List<Outcome> outcomes = ioutcomeDAO.getAlloutcome();
        request.setAttribute("AllOutcome", outcomes);
        request.getRequestDispatcher("ShowAllOutcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
