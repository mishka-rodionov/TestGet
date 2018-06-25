package servlet;

import logic.Data;
import logic.Room;

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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        playerNumber = request.getParameter("playerNumber");

        roomIndex = Integer.parseInt(request.getParameter(Data.getRoomIndexLabel()));
        if (playerNumber.equals("firstPlayer")){
            answer = Room.getRoom(roomIndex).getFirstPlayer() + " " + Room.getRoom(roomIndex).getSecondPlayer() + " "
            + Room.getRoom(roomIndex).getSecondPlayerUsername() + " " + Room.getRoom(roomIndex).getSecondPlayerOrigin().replaceAll(" ", "_");
        }else{
            answer = Room.getRoom(roomIndex).getFirstPlayer() + " " + Room.getRoom(roomIndex).getSecondPlayer() + " "
                    + Room.getRoom(roomIndex).getFirstPlayerUsername() + " " + Room.getRoom(roomIndex).getFirstPlayerOrigin().replaceAll(" ", "_");
        }


        out.print(answer);
        out.close();
    }

    private Integer roomIndex;
    private String playerNumber;
    private String answer;
}
