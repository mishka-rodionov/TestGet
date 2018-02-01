package servlet;

import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetRoomListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = "";
        for (int i = 0; i < Room.getSize(); i++) {
            request += Room.getRoom(i).getFirstPlayer() + " " + i + " ";
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(request);
        out.close();

    }
}
