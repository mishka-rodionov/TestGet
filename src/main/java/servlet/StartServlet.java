package servlet;

import logic.Data;
import service.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "StartServlet")
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                 //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                               //Получение потока, куда писать ответ
        playername = request.getParameter(Data.getPlayerNameLabel());
        origin = request.getParameter(Data.getOriginLabel());
        username = request.getParameter(Data.getUsername());
        if (username.equals(Data.getVirgin())){
            username = DBManager.createNewPlayer(playername, origin);
        }else{
            username = DBManager.changePlayername(username, playername, origin);
        }

        out.print(username);
        out.close();
    }

    private String playername;
    private String origin;
    private String username;
}
