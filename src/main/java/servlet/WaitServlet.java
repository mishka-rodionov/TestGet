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
        type = req.getParameter(Data.getType());
        playerName = req.getParameter(Data.getPlayerName());

        if (type.equals(Data.getSend())){
            step = Integer.parseInt(req.getParameter(Data.getStep()));
            Room.getRoom(roomIndex).addStep(step);
        }

        if (type.equals(Data.getReceive())){
            if (Room.getRoom(roomIndex).getStepsSize() < 1){

            }
            if (Room.getRoom(roomIndex).getStepsSize() < 2 && Room.getRoom(roomIndex).getStepCount() == 0){

                Room.getRoom(roomIndex).addStepCount();
            }
            if (Room.getRoom(roomIndex).getStepsSize() == 2 && Room.getRoom(roomIndex).getStepCount() == 1){

                Room.getRoom(roomIndex).addStepCount();
            }
        }
//        step1 = Integer.parseInt(req.getParameter(Data.getStep1()));
//        step2 = Integer.parseInt(req.getParameter(Data.getStep2()));

//        sendStart = Boolean.parseBoolean(req.getParameter(Data.getSendStart()));
//        sendFinish = Boolean.parseBoolean(req.getParameter(Data.getSendFinish()));
//        readStart = Boolean.parseBoolean(req.getParameter(Data.getReadStart()));
//        readFinish = Boolean.parseBoolean(req.getParameter(Data.getReadFinish()));

//        if (sendStart){
//            Room.getRoom(roomIndex).addStep(step1);
//            Room.getRoom(roomIndex).addStep(step2);
//            answer = sendStart + " " + step1 + " " + step2;
//        }
//
//        if (!sendStart && sendFinish){
//            Room.getRoom(roomIndex).addStep(step1);
//            Room.getRoom(roomIndex).addStep(step2);
//            answer = sendStart + " " + step1 + " " + step2;
//        }
//
//        if(readStart && (Room.getRoom(roomIndex).getStepsSize() == 2)){
//            if (sendFinish){
//                answer = sendFinish + " " + Room.getRoom(roomIndex).getValue(0) + " " + Room.getRoom(roomIndex).getValue(1);
//                Room.getRoom(roomIndex).setSendFinish(false);
//            }else {
//                answer = sendFinish + " " + Room.getRoom(roomIndex).getValue(0) + " " + Room.getRoom(roomIndex).getValue(1);
//            }
//            Room.getRoom(roomIndex).clearSteps();
//        }else if (readStart){
//            answer = sendFinish + " " + "-1" + " " + "-1";
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
//    private Integer step1;
//    private Integer step2;
    private Integer step;

//    private String activePlayer;
    private String answer;
    private String type;
    private String playerName;

//    private Boolean sendStart;
//    private Boolean sendFinish;
//    private Boolean readStart;
//    private Boolean readFinish;

}
