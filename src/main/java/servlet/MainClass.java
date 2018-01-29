package servlet;

import logic.BattleField;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lab1 on 12.01.2018.
 */
public class MainClass extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");                                 //Установка MIME типа ответа на GET запрос
        PrintWriter out = response.getWriter();                               //Получение потока, куда писать ответ
        String name = request.getParameter("size");                     //Получение параметров запроса
        int size = Integer.parseInt(name);                                    //Преобразование значений из параметров запроса к необходимому типу (int)
        BattleField battleField = new BattleField(size);                      //Конструирование поля для игры
        int indexBattleField = BattleField.addBattleField(battleField);       //Добавление игрового поля в контейнер игровых полей.
        out.print(indexBattleField);                                          //Возвращение индекса игрового поля из контейнера игровых полей
        out.close();
    }

}
