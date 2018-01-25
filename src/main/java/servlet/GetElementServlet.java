package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import logic.BattleField;


public class GetElementServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rowIndex = Integer.parseInt(req.getParameter("rowIndex"));                              // Индекс строки передаваемый в get-запросе
        int columnIndex = Integer.parseInt(req.getParameter("columnIndex"));                        // Индекс столбца передаваемый в get-запросе
        int battleFieldIndex = Integer.parseInt(req.getParameter("battleFieldIndex"));              // Индекс поля в контейнере полей
        String country = BattleField.getBattleField(battleFieldIndex).getElement(rowIndex, columnIndex);
        PrintWriter respOut = resp.getWriter();
        resp.setContentType("text/html");
        req.getRequestURL();
        respOut.print(country);
        respOut.close();
    }
}
