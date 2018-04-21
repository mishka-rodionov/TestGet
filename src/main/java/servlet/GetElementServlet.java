package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import logic.BattleField;
import logic.Room;


public class GetElementServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        roomIndex = Integer.parseInt(req.getParameter("roomIndex"));                              // Индекс строки передаваемый в get-запросе
        elementIndex = Integer.parseInt(req.getParameter("elementIndex"));                        // Индекс столбца передаваемый в get-запросе
        playerName = req.getParameter("playerName");

        Room.addStep(elementIndex);
        if (Room.getStepsSize() == 2){
            Room.getRoom(roomIndex).setPlayerSend(true);
        }

        PrintWriter respOut = resp.getWriter();
        resp.setContentType("text/html");
        req.getRequestURL();
        respOut.print("OK");
        respOut.close();
    }

    private Integer roomIndex;
    private Integer elementIndex;

    private String playerName;

}
