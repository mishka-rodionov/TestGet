package servlet;

import logic.Data;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ActivePlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = resp.getWriter();                                             //Получение потока, куда писать ответ

        roomIndex = Integer.parseInt(req.getParameter(Data.getRoomIndexLabel()));
        activeStep = Integer.parseInt(req.getParameter(Data.getActiveStepLabel()));
        activePlayer = req.getParameter(Data.getActivePlayerLabel());
        mistake = req.getParameter(Data.getMistakeLabel());

        Room.getRoom(roomIndex).addStep(activeStep);
        Room.getRoom(roomIndex).setMistake(Boolean.parseBoolean(mistake));

        if (activePlayer.equals(Data.getFirstPlayerNumber())){
            Room.getRoom(roomIndex).setFirstPlayerActive(true);
            Room.getRoom(roomIndex).setSecondPlayerActive(false);
        }else{
            Room.getRoom(roomIndex).setFirstPlayerActive(false);
            Room.getRoom(roomIndex).setSecondPlayerActive(true);
        }

        if (Room.getRoom(roomIndex).getStepsSize() == 2 && Room.getRoom(roomIndex).isMistake()){
            Room.getRoom(roomIndex).setFirstPlayerActive(!Room.getRoom(roomIndex).isFirstPlayerActive());
            Room.getRoom(roomIndex).setSecondPlayerActive(!Room.getRoom(roomIndex).isSecondPlayerActive());
            if (activePlayer.equals(Data.getFirstPlayerNumber())){
                answer = Boolean.toString(Room.getRoom(roomIndex).isFirstPlayerActive());
            }else{
                answer = Boolean.toString(Room.getRoom(roomIndex).isSecondPlayerActive());
            }
        }else{
            if (activePlayer.equals(Data.getFirstPlayerNumber())){
                answer = Boolean.toString(Room.getRoom(roomIndex).isFirstPlayerActive());
            }else{
                answer = Boolean.toString(Room.getRoom(roomIndex).isSecondPlayerActive());
            }
        }

        out.print(answer);
        out.close();
    }

    private Integer roomIndex;
    private Integer activeStep;
    private String activePlayer;
    private String mistake;
    private String answer;
}
