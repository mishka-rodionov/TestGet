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

//import javax.servlet.annotation.WebServlet;

//@WebServlet(name = "PushResultToDBServlet")
public class PushResultToDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String json = "";
        while (bufferedReader.ready()){
            json += bufferedReader.readLine();
        }
        json.trim();
        String ans = "";
        JSONObject jsonObject = new JSONObject(json);
        try{
            ans = jsonObject.getString("score");
            username = jsonObject.getString(Data.getUsername());
            enemyUsername = jsonObject.getString(Data.getEnemyUsername());
            enemyScore = jsonObject.getString(Data.getEnemyScore());
            score = jsonObject.getString(Data.getScore());
            result = jsonObject.getString(Data.getResult());
            date = jsonObject.getString(Data.getDate());
            answer = DBManager.pushResultToDB(username, enemyUsername, score, enemyScore, result, date);
            answer += DBManager.pushTotalScore(username, score);
        }catch (JSONException je){
            ans += je.toString();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(answer);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        username = request.getParameter(Data.getUsername());
        enemyUsername = request.getParameter(Data.getEnemyUsername());
//        enemyPlayername = request.getParameter(Data.getEnemyPlayername());
//        enemyOrigin = request.getParameter(Data.getEnemyOrigin());
        enemyScore = request.getParameter(Data.getEnemyScore());
        score = request.getParameter(Data.getScore());
        result = request.getParameter(Data.getResult());
        date = request.getParameter(Data.getDate());
        answer = DBManager.pushResultToDB(username, enemyUsername, score, enemyScore, result, date);
        answer += DBManager.pushTotalScore(username, score);
        out.print(answer);
        out.close();
    }
    private static String username;
    private static String enemyUsername;
    private static String enemyPlayername;
    private static String enemyOrigin;
    private static String enemyScore;
    private static String score;
    private static String result;
    private static String date;
    private static String answer;
}
