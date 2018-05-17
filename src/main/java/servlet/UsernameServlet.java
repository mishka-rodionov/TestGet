package servlet;

import logic.Data;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UsernameServlet")
public class UsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        roomIndex = Integer.parseInt(request.getParameter(Data.getRoomIndexLabel()));
        answer = Room.getRoom(roomIndex).getFirstPlayer() + " " + Room.getRoom(roomIndex).getSecondPlayer();

        out.print(answer);
        out.close();
    }

    private Integer roomIndex;
    private String answer;
}
