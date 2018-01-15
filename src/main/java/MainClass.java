
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lab1 on 12.01.2018.
 */
public class MainClass extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("size");
        int size = Integer.parseInt(name);
        BattleField battleField = new BattleField(size, out);
        out.println("<html>" + "<head><title>Book Description</title></head>");
        out.println("<body> Hello my servlets!" + name);
        out.println("size of array " + size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                out.print(battleField.getElement(i,j) + " ");
            }
            out.println();
        }
        out.println("</body></html>");
        out.close();
    }

}
