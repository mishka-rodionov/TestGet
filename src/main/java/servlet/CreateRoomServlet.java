package servlet;

import logic.BattleField;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

public class CreateRoomServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                                             //Получение потока, куда писать ответ
        String roomaName = req.getParameter("roomName");
        int battleFieldSize = Integer.parseInt(req.getParameter("battleFieldSize"));
        BattleField battleField = new BattleField(battleFieldSize);
        Room.setElement(roomaName, BattleField.addBattleField(battleField));
        String resp = "";
        Set<String> keys = Room.getElement();
        for (Iterator<String> k = keys.iterator(); k.hasNext();) {
            resp += k.next() + " ";
        }
        out.print(resp);
    }
}
