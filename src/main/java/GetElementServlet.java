import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetElementServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rowIndex = Integer.parseInt(req.getParameter("rowIndex"));
        int columnIndex = Integer.parseInt(req.getParameter("columnIndex"));
        int battleFieldIndex = Integer.parseInt(req.getParameter("battleFieldIndex"));
        String country = BattleField.getBattleField(battleFieldIndex).getElement(rowIndex, columnIndex);
        PrintWriter respOut = resp.getWriter();
        resp.setContentType("text/html");
        respOut.print(country);
        respOut.close();
    }
}
