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
        // устанавливает заголовок "content-type"
        // прежде сем получить доступ к Writer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // затем пишем ответ
        out.println("<html>" + "<head><title>Book Description</title></head>");

        //берем идентификатор требуемой книги
        String bookId = request.getParameter("bookId");
        if (bookId != null) {
            // печатаем информацию о книге
        }
        out.println("</body></html>");
        out.close();
    }

}
