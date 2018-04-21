package servlet;

import logic.BattleField;
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
public class ConnectToRoom extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        noRoom = false;
        response.setContentType("text/html");                                 //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                               //Получение потока, куда писать ответ

        playerName = request.getParameter("playerName");
        user = request.getParameter("user");
        origin = request.getParameter("origin");
        size = Integer.parseInt(request.getParameter("size"));

        for (int i = 0; i < Room.getRoomsSize(); i++) {
            if(Room.getRoom(i).getBattleFieldSize() == size){
                Room.getRoom(i).setSecondPlayer(playerName);
                Room.getRoom(i).setSecondPlayerUsername(user);
                Room.getRoom(i).setSecondPlayerOrigin(origin);
                break;
            }
            if (i == (Room.getRoomsSize() - 1)){
                noRoom = true;
            }
        }

        if (noRoom){
            Room room = new Room(playerName, size, origin, user);
            roomIndex = Room.addRoom(room);
        }

        answer = "" + roomIndex + " ";
        for (int i = 0; i < size; i++) {
            answer += i + " " + Room.getRoom(roomIndex).getBattleField().getElement(i) + " ";
        }

//        BattleField battleField = new BattleField(size);                      //Конструирование поля для игры
//        int indexBattleField = BattleField.addBattleField(battleField);       //Добавление игрового поля в контейнер игровых полей.
        out.print(answer);                                          //Возвращение индекса игрового поля из контейнера игровых полей
        out.close();
    }

    private String playerName;
    private String user;
    private String origin;
    private String answer;

    private Integer size;
    private Integer roomIndex;

    private Boolean noRoom;

}
