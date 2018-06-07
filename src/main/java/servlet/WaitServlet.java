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
        type = "";
        playerName = "";

        if (Room.getRoom(roomIndex).isRemovingRoom()){
            answer = "esc";
        }else{
            type = req.getParameter(Data.getType());
            playerName = req.getParameter(Data.getPlayerName());
        }

        if (type.equals(Data.getSend())){
            step = Integer.parseInt(req.getParameter(Data.getStep()));
            Room.getRoom(roomIndex).addStep(step);
            answer = "OK";
        }

        if (type.equals(Data.getReceive()) && !Room.getRoom(roomIndex).isRemovingRoom()){
            if (Room.getRoom(roomIndex).getStepsSize() == 1 && Room.getRoom(roomIndex).getStepCount() == 0){
                answer = "" + Room.getRoom(roomIndex).getValue(0);/* + " " + Room.getRoom(roomIndex).getStepsSize() + " " + Room.getRoom(roomIndex).getStepCount();*/
                Room.getRoom(roomIndex).addStepCount();
            }else if(Room.getRoom(roomIndex).getStepsSize() == 2 && Room.getRoom(roomIndex).getStepCount() == 0){
                answer = "" + Room.getRoom(roomIndex).getValue(0);/* + " " + Room.getRoom(roomIndex).getStepsSize() + " " + Room.getRoom(roomIndex).getStepCount();*/
                Room.getRoom(roomIndex).addStepCount();
            }else if (Room.getRoom(roomIndex).getStepsSize() == 2 && Room.getRoom(roomIndex).getStepCount() == 1){
                answer = "" + Room.getRoom(roomIndex).getValue(1);/* + " " + Room.getRoom(roomIndex).getStepsSize() + " " + Room.getRoom(roomIndex).getStepCount();*/
                Room.getRoom(roomIndex).clearStepCount();
                Room.getRoom(roomIndex).clearSteps();
            }else{
                answer = "" + dummy;
            }
        }

        out.print(answer);
        out.close();
    }

    private Integer roomIndex;
    private Integer step;

    private String answer;
    private String type;
    private String playerName;
    private int dummy = -1;


}
