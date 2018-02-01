package servlet;

import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestAnotherPlayerChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roomIndex = Integer.parseInt(req.getParameter("roomIndex"));
        String player = req.getParameter("player");
        Room room = Room.getRoom(roomIndex);
        String res = "";
        if (room.getFirstPlayer().equals(player)){
            if(room.isSecondPlayerStep()){
                res = "stop";
            }else{
                res = "start";
            }
        }else if (room.getSecondPlayer().equals(player)){
            if(room.isFirstPlayerStep()){
                res = "stop";
            }else{
                res = "start";
            }
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();
    }
}
