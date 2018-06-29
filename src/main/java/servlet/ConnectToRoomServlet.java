package servlet;

import logic.Data;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lab1 on 12.01.2018.
 */
public class ConnectToRoomServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        noRoom = false;
        response.setContentType("text/html; charset=UTF-8");                                 //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                               //Получение потока, куда писать ответ

        playerName = request.getParameter(Data.getPlayerNameLabel());
        user = request.getParameter(Data.getUsernameLabel());
        origin = request.getParameter(Data.getOrigin());
        size = Integer.parseInt(request.getParameter(Data.getSizeLabel()));
        answer = new String();

        if (Room.getRoomsSize() > 0) {
            for (int i = 0; i < Room.getRoomsSize(); i++) {
                if (Room.getRoom(i).getBattleFieldSize() == size &&
                        Room.getRoom(i).getSecondPlayer() == null) {
                    Room.getRoom(i).setSecondPlayer(playerName);
                    Room.getRoom(i).setSecondPlayerUsername(user);
                    Room.getRoom(i).setSecondPlayerOrigin(origin);
                    roomIndex = i;
                    playerNumber = Data.getSecondPlayerNumber();
                    break;
                }
                if (i == (Room.getRoomsSize() - 1)) {
                    noRoom = true;
                }
            }
        } else {
            Room room = new Room(playerName, size, origin, user);
            roomIndex = Room.addRoom(room);
            playerNumber = Data.getFirstPlayerNumber();
        }

        if (noRoom) {
            Room room = new Room(playerName, size, origin, user);
            roomIndex = Room.addRoom(room);
            playerNumber = Data.getFirstPlayerNumber();
        }

        answer += roomIndex + " " + playerNumber + " ";
        for (int i = 0; i < size; i++) {
            answer += i + " ";
            answer += Room.getRoom(roomIndex).getBattleField().getElement(i) + " ";
        }

        out.print(answer);                                          //Возвращение индекса игрового поля из контейнера игровых полей
        out.close();
    }

    private String playerName;
    private String user;
    private String origin;
    private String answer;
    private String playerNumber;

    private Integer size;
    private Integer roomIndex;

    private Boolean noRoom;

}
