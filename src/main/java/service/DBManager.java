package service;

import logic.Data;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;

public class DBManager {
    public static String createNewPlayer(String playername, String origin){
        Connection connection;
        String username = "";
        String classEx = "";
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString() + " ";
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE test (ID INTEGER PRIMARY KEY , Username VARCHAR(15), Playername VARCHAR (40), " +
//                    "Origin VARCHAR (20), Date VARCHAR (40))");
            ResultSet resultSet = statement.executeQuery("SELECT id FROM players ORDER BY id DESC ");
            Integer id;
            if (resultSet.next()){
                id = resultSet.getInt(1);
            }else{
                id = 1;
            }
            statement.close();
            username = "user" + id;
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players(username, playername, origin, date) VALUES ("
            + "\'" + username + "\',"
            + "\'" + playername + "\',"
            + "\'" + origin + "\',"
            + "\'" + Data.getCurrentDate() + "\'"
            + ");");
//                    + 2 + ", "
//                    + username + ", "
//                    + playername + ", "
//                    + origin + ", "
//                    + Data.getCurrentDate().replaceAll(" ", "_").replaceAll(":", "_") +" )");
            preparedStatement.executeUpdate();
//            preparedStatement = connection.prepareStatement("INSERT INTO players(username, playername, origin, date) VALUES ('user2', 'kol', 'comoros', '30_05_2018');");
//            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
//            username = stringWriter.toString();
//            Charset cset = Charset.forName("windows-1251");
//            ByteBuffer buf = cset.encode(username);
//            byte[] b = buf.array();
//            String str = new String(b);
//            username = str;

        }
        return username;
    }

    public static String changePlayername(String username, String playername, String origin){
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
        }
        try {
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players"
            +" SET playername = " + "\'" + playername + "\'"
            +" WHERE username = " + "\'" + username + "\'" + ";");
//            +" WHERE username = \'user1\';");
            preparedStatement.executeUpdate();
            preparedStatement.close();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT playername " +
                "FROM players " +
                "WHERE username = "
                + "\'" + username + "\'" + ";");
            playername = resultSet.getString(1);
        }catch (SQLException ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            username = stringWriter.toString();
//            Charset cset = Charset.forName("windows-1251");
//            ByteBuffer buf = cset.encode(username);
//            byte[] b = buf.array();
//            String str = new String(b);
//            username = str;

        }
        return playername;
    }
}
