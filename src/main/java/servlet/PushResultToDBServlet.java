package servlet;

import logic.Data;
import service.DBManager;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "PushResultToDBServlet")
public class PushResultToDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        username = request.getParameter(Data.getUsername());
        enemyUsername = request.getParameter(Data.getEnemyUsername());
        enemyPlayername = request.getParameter(Data.getEnemyPlayername());
        enemyOrigin = request.getParameter(Data.getEnemyOrigin());
        enemyScore = request.getParameter(Data.getEnemyScore());
        score = request.getParameter(Data.getScore());
        result = request.getParameter(Data.getResult());
        date = request.getParameter(Data.getDate());
        answer = DBManager.pushResultToDB(username, enemyUsername, enemyPlayername, enemyOrigin, score, enemyScore, result, date);
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
