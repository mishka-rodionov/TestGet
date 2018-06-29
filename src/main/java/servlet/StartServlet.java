package servlet;

import logic.Data;
import org.json.JSONException;
import org.json.JSONObject;
import service.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "StartServlet")
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String json = "";
        while (bufferedReader.ready()){
            json += bufferedReader.readLine();
        }
        json.trim();
        String ans = "test ";
        JSONObject jsonObject = new JSONObject(json);
        try{
//            ans = jsonObject.getString("score");
            username = jsonObject.getString(Data.getUsername());
            playername = jsonObject.getString(Data.getPlayername());
            origin = jsonObject.getString(Data.getOrigin());
            ans += username + " " + playername + " " + origin;
        }catch (JSONException je){
            ans += je.toString();
        }
        if (username.equals(Data.getVirgin())){
            //newUsername += "if";
            newUsername = DBManager.createNewPlayer(playername, origin);
        }else{
            //newUsername += "else";
            newUsername = DBManager.changePlayername(username, playername, origin);

        }
        JSONObject object = new JSONObject();
        object.put(Data.getUsername(), newUsername);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(object.toString());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                 //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                               //Получение потока, куда писать ответ
        playername = request.getParameter(Data.getPlayerNameLabel());
        origin = request.getParameter(Data.getOrigin());
        username = request.getParameter(Data.getUsername());
        //newUsername = "beforeIf";
        if (username.equals(Data.getVirgin())){
            //newUsername += "if";
            newUsername = DBManager.createNewPlayer(playername, origin);
        }else{
            //newUsername += "else";
            newUsername = DBManager.changePlayername(username, playername, origin);
        }
//        username += " 1" + DBManager.createUsernameTable(username);
//        DBManager.createUsernameTable(newUsername);
        out.print(newUsername);
        out.close();
    }

    private String playername;
    private String origin;
    private String username;
    private String newUsername;
}
