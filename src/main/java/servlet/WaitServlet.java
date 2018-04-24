package servlet;

import logic.Data;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WaitServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                                             //Получение потока, куда писать ответ

        roomIndex = Integer.parseInt(req.getParameter(Data.getRoomIndexLabel()));
        activePlayer = req.getParameter(Data.getActivePlayerLabel());               //игрок ожидающий своего хода
        answer = "";

        if (activePlayer.equals(Room.getRoom(roomIndex).getFirstPlayer())){
            createAnswer();
            answer += " " + Boolean.toString(Room.getRoom(roomIndex).isFirstPlayerActive());
        }else if (activePlayer.equals(Room.getRoom(roomIndex).getSecondPlayer())){
            createAnswer();
            answer += " " + Boolean.toString(Room.getRoom(roomIndex).isSecondPlayerActive());
        }


        out.print(answer);
        out.close();
    }

    private void createAnswer() {
        if (Room.getRoom(roomIndex).getStepsSize() > 0 && !Room.getRoom(roomIndex).isReadFlag()){
            answer += Room.getRoom(roomIndex).getValue(0);
            Room.getRoom(roomIndex).setReadFlag(true);
        }else if (Room.getRoom(roomIndex).getStepsSize() > 1 && Room.getRoom(roomIndex).isReadFlag()){
            answer += Room.getRoom(roomIndex).getValue(1);
            Room.getRoom(roomIndex).setReadFlag(false);
            Room.getRoom(roomIndex).clearSteps();
        }else {
            answer += 0 + " " + (Room.getRoom(roomIndex).isFirstPlayerActive() ? Boolean.toString(Room.getRoom(roomIndex).isFirstPlayerActive()) : Boolean.toString(Room.getRoom(roomIndex).isSecondPlayerActive()));
        }
    }

    private Integer roomIndex;
    private String activePlayer;
    private String answer;

}
