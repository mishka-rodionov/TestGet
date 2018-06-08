package servlet;

import logic.Data;
import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AvailableUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                                             //Получение потока, куда писать ответ
        online = req.getParameter(Data.getOnline());
        username = req.getParameter(Data.getUsername());
        xsUsers = 0;
        sUsers = 0;
        mUsers = 0;
        lUsers = 0;
        xlUsers = 0;
        xxlUsers = 0;

        if (Boolean.parseBoolean(online)){
            Room.setOnlineElement(username);
        }else{
            Room.clearOnlineElement(username);
        }

        if (Room.getRoomsSize() > 0) {
            for (int i = 0; i < Room.getRoomsSize(); i++) {
                if (Room.getRoom(i).getBattleFieldSize() == Data.getXsmallSize() && Room.getRoom(i).getSecondPlayer() == null){
                    xsUsers++;
                }
                if (Room.getRoom(i).getBattleFieldSize() == Data.getSmallSize() && Room.getRoom(i).getSecondPlayer() == null){
                    sUsers++;
                }
                if (Room.getRoom(i).getBattleFieldSize() == Data.getMediumSize() && Room.getRoom(i).getSecondPlayer() == null){
                    mUsers++;
                }
                if (Room.getRoom(i).getBattleFieldSize() == Data.getLargeSize() && Room.getRoom(i).getSecondPlayer() == null){
                    lUsers++;
                }
                if (Room.getRoom(i).getBattleFieldSize() == Data.getXlargeSize() && Room.getRoom(i).getSecondPlayer() == null){
                    xlUsers++;
                }
                if (Room.getRoom(i).getBattleFieldSize() == Data.getXxlargeSize() && Room.getRoom(i).getSecondPlayer() == null){
                    xxlUsers++;
                }
            }
        }
        answer = "" + xsUsers + " " + sUsers + " " + mUsers + " " + lUsers + " " + xlUsers + " " + xxlUsers + " " + Room.allOnline();

        out.print(answer);
        out.close();


    }

    private String answer;
    private String online;
    private String username;
    private Integer xsUsers;
    private Integer sUsers;
    private Integer mUsers;
    private Integer lUsers;
    private Integer xlUsers;
    private Integer xxlUsers;
}