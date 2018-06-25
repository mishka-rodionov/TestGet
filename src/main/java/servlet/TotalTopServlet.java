package servlet;

import logic.Data;
import org.json.simple.JSONObject;
import service.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "TotalTopServlet")
public class TotalTopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader bufferedReader = request.getReader();
//        String json = "temp";
//        while (bufferedReader.ready()){
//            json += bufferedReader.readLine();
//        }
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print(json);
//        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        username = request.getParameter(Data.getUsername());
        JSONObject topTotal = DBManager.getTopTotal();
        answer = topTotal.toJSONString();
        out.print(answer);
        out.close();
    }

    private String username;
    private String answer;

}
