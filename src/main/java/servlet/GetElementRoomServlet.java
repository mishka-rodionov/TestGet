package servlet;

import logic.BattleField;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetElementRoomServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rowIndex = Integer.parseInt(req.getParameter("rowIndex"));                              // Индекс строки передаваемый в get-запросе
        int columnIndex = Integer.parseInt(req.getParameter("columnIndex"));                        // Индекс столбца передаваемый в get-запросе
        int roomIndex = Integer.parseInt(req.getParameter("roomIndex"));                            // Индекс
        String player= req.getParameter("player");
        Room room = Room.getRoom(roomIndex);
        String country = BattleField.getBattleField(room.getBattleFieldIndex()).getElement(rowIndex, columnIndex);
        if(player.equals(room.getFirstPlayer())){
            room.setRowIndex(rowIndex);
            room.setColumnIndex(columnIndex);
            room.setCountry(country);
            room.addStepCount();
            if(room.getStepCount() < 2){
                room.setFirstPlayerStep(true);
            }else {
                room.setFirstPlayerStep(false);
                room.resetStepCount();
            }
        }else if(player.equals(room.getSecondPlayer())){
            room.setRowIndex(rowIndex);
            room.setColumnIndex(columnIndex);
            room.setCountry(country);
            room.addStepCount();
            if(room.getStepCount() < 2){
                room.setSecondPlayerStep(true);
            }else {
                room.setSecondPlayerStep(false);
                room.resetStepCount();
            }
        }
        PrintWriter respOut = resp.getWriter();
        resp.setContentType("text/html");
        req.getRequestURL();
        respOut.print(country);
        respOut.close();
    }
}
