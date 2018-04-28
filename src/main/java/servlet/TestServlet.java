package servlet;

import logic.TestInteraction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                                             //Получение потока, куда писать ответ
        type = req.getParameter("type");
        name = req.getParameter("name");

        if (name.equals("first") && TestInteraction.getFirst()){
            if (type.equals(SEND)){
                body = req.getParameter("body");
                TestInteraction.setBody(body);
                answer = "get send";
                TestInteraction.setFirst(false);
                TestInteraction.setSecond(true);
            }
//            else if (type.equals(RECEIVE)){
//                answer = TestInteraction.getBody();
//            }
        }else if (name.equals("second") && TestInteraction.getSecond()){
            if (type.equals(SEND)){
                body = req.getParameter("body");
                TestInteraction.setBody(body);
                answer = "get send";
                TestInteraction.setFirst(true);
                TestInteraction.setSecond(false);
            }
//            else if (type.equals(RECEIVE)){
//                answer = TestInteraction.getBody();
//            }
        }
        if (type.equals(RECEIVE)){
            answer = TestInteraction.getBody();
        }



        out.print(answer);
        out.close();


    }

    private String answer;
    private static String RECEIVE = "receive";
    private static String SEND = "send";
    private String type;
    private String body;
    private String name;

}