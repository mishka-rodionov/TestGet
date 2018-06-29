package servlet;

import logic.Data;
import logic.Room;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "UsernameServlet")
public class UsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        playerNumber = request.getParameter("playerNumber");

        JSONObject jsonObject = new JSONObject();
        roomIndex = Integer.parseInt(request.getParameter(Data.getRoomIndexLabel()));
        if (playerNumber.equals("firstPlayer")){
            jsonObject.put(Data.getFirstPlayername(), Room.getRoom(roomIndex).getFirstPlayer());
            jsonObject.put(Data.getAnotherPlayername(), Room.getRoom(roomIndex).getSecondPlayer());
            jsonObject.put(Data.getAnotherPlayerUsername(), Room.getRoom(roomIndex).getSecondPlayerUsername());
            jsonObject.put(Data.getAnotherPlayerOrigin(), Room.getRoom(roomIndex).getSecondPlayerOrigin());
//            answer = Room.getRoom(roomIndex).getFirstPlayer() + " " + Room.getRoom(roomIndex).getSecondPlayer() + " "
//            + Room.getRoom(roomIndex).getSecondPlayerUsername() + " " + Room.getRoom(roomIndex).getSecondPlayerOrigin();
        }else{
            jsonObject.put(Data.getFirstPlayername(), Room.getRoom(roomIndex).getFirstPlayer());
            jsonObject.put(Data.getAnotherPlayername(), Room.getRoom(roomIndex).getSecondPlayer());
            jsonObject.put(Data.getAnotherPlayerUsername(), Room.getRoom(roomIndex).getFirstPlayerUsername());
            jsonObject.put(Data.getAnotherPlayerOrigin(), Room.getRoom(roomIndex).getFirstPlayerOrigin());
//            answer = Room.getRoom(roomIndex).getFirstPlayer() + " " + Room.getRoom(roomIndex).getSecondPlayer() + " "
//                    + Room.getRoom(roomIndex).getFirstPlayerUsername() + " " + Room.getRoom(roomIndex).getFirstPlayerOrigin();
        }


        out.print(jsonObject.toString());
        out.close();
    }

    private Integer roomIndex;
    private String playerNumber;
    private String answer;
}
