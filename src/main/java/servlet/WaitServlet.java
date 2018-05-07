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
        step1 = Integer.parseInt(req.getParameter(Data.getStep1()));
        step2 = Integer.parseInt(req.getParameter(Data.getStep2()));

        sendStart = Boolean.parseBoolean(req.getParameter(Data.getSendStart()));
        sendFinish = Boolean.parseBoolean(req.getParameter(Data.getSendFinish()));
        readStart = Boolean.parseBoolean(req.getParameter(Data.getReadStart()));
        readFinish = Boolean.parseBoolean(req.getParameter(Data.getReadFinish()));

//        activePlayer = req.getParameter(Data.getActivePlayerLabel());               //игрок ожидающий своего хода
//        answer = "remote host " + req.getRemoteHost() + "\n ";
//        answer += "path info " + req.getPathInfo() + "\n ";
//        answer += "path translated " + req.getPathTranslated() + "\n ";
//        answer += "context path " + req.getContextPath() + "\n ";
//        answer += "servlet path " + req.getServletPath() + "\n ";
        if (sendStart){
            Room.getRoom(roomIndex).addStep(step1);
            Room.getRoom(roomIndex).addStep(step2);
            answer = sendStart + " " + step1 + " " + step2;
        }

        if (sendStart && sendFinish){

        }

        if(readStart && (Room.getRoom(roomIndex).getStepsSize() == 2)){
            if (sendFinish){
                answer = sendFinish + " " + Room.getRoom(roomIndex).getValue(0) + " " + Room.getRoom(roomIndex).getValue(1);
                Room.getRoom(roomIndex).setSendFinish(false);
            }else {
                answer = sendFinish + " " + Room.getRoom(roomIndex).getValue(0) + " " + Room.getRoom(roomIndex).getValue(1);
            }
            Room.getRoom(roomIndex).clearSteps();
        }else if (readStart){
            answer = sendFinish + " " + "-1" + " " + "-1";
        }

//        if (activePlayer.equals(Room.getRoom(roomIndex).getFirstPlayer())){
//            createAnswer();
//            answer += " " + Boolean.toString(Room.getRoom(roomIndex).isFirstPlayerActive());
//        }else if (activePlayer.equals(Room.getRoom(roomIndex).getSecondPlayer())){
//            createAnswer();
//            answer += " " + Boolean.toString(Room.getRoom(roomIndex).isSecondPlayerActive());
//        }


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
    private Integer step1;
    private Integer step2;

    private String activePlayer;
    private String answer;

    private Boolean sendStart;
    private Boolean sendFinish;
    private Boolean readStart;
    private Boolean readFinish;

}
