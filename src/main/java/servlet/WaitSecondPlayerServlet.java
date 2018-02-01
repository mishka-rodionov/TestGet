package servlet;

import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WaitSecondPlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = resp.getWriter();                                             //Получение потока, куда писать ответ
        int roomIndex = Integer.parseInt(req.getParameter("roomIndex"));
        Room room = Room.getRoom(roomIndex);
        String res = "";
        if(room.isChangeSecondPlayer()){
            res = "true " + room.getSecondPlayer();
        }else{
            res = "false";
        }
        out.print(res);
        out.close();
    }
}
