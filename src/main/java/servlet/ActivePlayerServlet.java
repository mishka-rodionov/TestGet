package servlet;

import logic.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ActivePlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");                                               //Установка MIME типа ответа на GET запрос
        PrintWriter out = resp.getWriter();                                             //Получение потока, куда писать ответ

        roomIndex = Integer.parseInt(req.getParameter("roomIndex"));
        activeStep = Integer.parseInt(req.getParameter("activeStep"));
        Room.getRoom(roomIndex).addStep(activeStep);

        String res = "";
        out.print(res);
        out.close();
    }

    private Integer roomIndex;
    private Integer activeStep;
}
