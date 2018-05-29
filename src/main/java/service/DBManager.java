package service;

import logic.Data;

import java.sql.*;

public class DBManager {
    public static String createNewPlayer(String playername, String origin){
        Connection connection;
        String username = "";
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            username = e.toString();
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE test (ID INTEGER PRIMARY KEY , Username VARCHAR(15), Playername VARCHAR (40), " +
//                    "Origin VARCHAR (20), Date VARCHAR (40))");
            ResultSet resultSet = statement.executeQuery("SELECT TOP 1 * FROM "+ Data.getSchema() + "."
                    + Data.getPlayersTable() + "ORDER BY id DESC ");
            Integer id;
            if (resultSet.next()){
                id = resultSet.getInt(1);
            }else{
                id = 1;
            }
            statement.close();
            username = "user" + id;
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + Data.getSchema()
                    + "." + Data.getPlayersTable() +"(id, username, playername, origin, date) VALUES ("
                    + id++ + ", "
                    + username + ", "
                    + playername + ", "
                    + origin + ", "
                    + Data.getCurrentDate() +" )");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            username = ex.toString();
        }
        return username;
    }
}
