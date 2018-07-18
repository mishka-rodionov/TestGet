package service;

import logic.Data;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
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
            classEx += e.toString() + " ";
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
            preparedStatement.executeUpdate();
            preparedStatement.close();
            PreparedStatement totalTable = connection.prepareStatement("INSERT INTO total(username, score) VALUES ("
                    + "\'" + username + "\',"
                    + "\'" + 0 + "\'"
                    + ");");
            totalTable.executeUpdate();
            totalTable.close();
            classEx += createUsernameTable(username);
        }catch (SQLException ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            classEx += ex.toString();
//            username = stringWriter.toString();
//            Charset cset = Charset.forName("windows-1251");
//            ByteBuffer buf = cset.encode(username);
//            byte[] b = buf.array();
//            String str = new String(b);
//            username = str;

        }
        return username; //+ " " + classEx;
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
            PreparedStatement changePlayersTable = connection.prepareStatement("UPDATE players"
            +" SET playername = " + "\'" + playername + "\', origin = \'" + origin + "\'"
            +" WHERE username = " + "\'" + username + "\'" + ";");
//            +" WHERE username = \'user1\';");
            changePlayersTable.executeUpdate();
            changePlayersTable.close();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username " +
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

    public static String createUsernameTable(String username){
        Connection connection;
        String classEx = "OKClassEx";
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString();
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            Statement sequenceStatement = connection.createStatement();
            sequenceStatement.executeUpdate("CREATE SEQUENCE public.autoincrement" + username + ";"
                    +"ALTER SEQUENCE public.autoincrement" + username
                    +" OWNER TO " + Data.getUserDB() + ";");
            sequenceStatement.close();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + username
            +      "("
            +                "id integer NOT NULL DEFAULT nextval(\'autoincrement" + username +"\'::regclass),"
            +                "enemyusername text,"
            +                "score text,"
            +                "enemyscore text,"
            +                "result text,"
            +                "date text,"
            +                "CONSTRAINT " + username + "_pkey PRIMARY KEY (id)"
            +        ")");
            statement.close();
        }catch (SQLException ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            classEx += ex.toString();
        }
        return classEx;
    }

    public static String pushResultToDB(String username, String enemyusername, String score, String enemyscore, String result, String date){
        Connection connection;
        String classEx = "";
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString() + " ";
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+ username +"(enemyusername,"
                    + " score, enemyscore, result, date) VALUES ("
                    + "\'" + enemyusername + "\',"
                    + "\'" + score + "\',"
                    + "\'" + enemyscore + "\',"
                    + "\'" + result + "\',"
                    + "\'" + date + "\'"
                    + ");");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            ex.printStackTrace();
            classEx += ex.toString();
        }
        return classEx;
    }

    public static String pushTotalScore(String username, String score){
        Connection connection;
        String classEx = "";
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString() + " ";
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            String scoreDB = "";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT score " +
                    "FROM total " +
                    "WHERE username = "
                    + "\'" + username + "\'" + ";");
            if (resultSet.next()){
                scoreDB = resultSet.getString(1);
            }else {
                scoreDB = "0";
            }

            Integer newScore = Integer.parseInt(scoreDB) + Integer.parseInt(score);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE total"
                    +" SET score = " + "\'" + newScore + "\'"
                    +" WHERE username = " + "\'" + username + "\'" + ";");
//            +" WHERE username = \'user1\';");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (SQLException ex){
            ex.printStackTrace();
            classEx += ex.toString();
        }
        return classEx;
    }

    public static org.json.JSONObject getTopTotal(){
        Connection connection;
        String classEx = "";
        org.json.JSONObject topTotal = new org.json.JSONObject();
//        topTotal.put("message", "OK");
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString() + " ";
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            String scoreDB = "";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * "
                    + "FROM total "
                    + "ORDER BY score DESC "
                    + "FETCH FIRST " + 100 +" ROWS ONLY;");

            int i = 1;
//            resultSet.next();
            int  fetchSize = resultSet.getFetchSize();
//            topTotal.put("fetchSize", fetchSize);
//            topTotal.put("result set", resultSet.getString(2));
//            partList.add("kolya");
//            partList.add("vasya");
//            partList.add("tolya");
//            topTotal.put(1, partList);
            while (resultSet.next()){
//                resultSet.next();
                org.json.JSONArray partList = new org.json.JSONArray();
                String usrnm = resultSet.getString(2);
                String score = resultSet.getString(3);
                Statement playersSt = connection.createStatement();
                ResultSet rsPlayers = playersSt.executeQuery("SELECT playername, origin "
                        + "FROM players "
                        + "WHERE username = \'" + usrnm + "\';"
                        );
//                topTotal.put("username" + i, usrnm);
                rsPlayers.next();
                String temp = rsPlayers.getString(1);
                byte[] bytes = new byte[1];
                String plrnm = new String();
                try{
                    bytes = temp.getBytes("UTF-8");
                    plrnm = new String(bytes, "UTF-8");
                }catch (UnsupportedEncodingException uns){
                    uns.printStackTrace();
                }
                String orgn = rsPlayers.getString(2);
//                topTotal.put("playername" + i, plrnm);
//                topTotal.put("origin" + i, orgn);
                partList.put(usrnm);
                partList.put(plrnm);
                partList.put(orgn);
                partList.put(score);
                topTotal.put("" + i++, partList);
                rsPlayers.close();
                playersSt.close();
//                partList.clear();
            }
            topTotal.put("size", i);
            statement.close();
        }catch (SQLException ex){
            ex.printStackTrace();
            classEx += ex.toString();
            topTotal.put("exception", classEx);
        }
        return topTotal;
    }

    public static org.json.JSONObject getPersonalStat(String username){
        Connection connection;
        String classEx = "";
        org.json.JSONObject personalStat = new org.json.JSONObject();
//        topTotal.put("message", "OK");
        try {
            Class.forName("org.postgresql.Driver");                                     //
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            classEx = e.toString() + " ";
        }
        try{
            connection = DriverManager.getConnection(Data.getUrlDB(), Data.getUserDB(), Data.getPasswordDB());
            String scoreDB = "";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * "
                    + "FROM " + username + " "
                    + "ORDER BY score DESC;"
                    /*+ "FETCH FIRST " + 100 +" ROWS ONLY;"*/);

            int i = 1;
//            resultSet.next();
//            int  fetchSize = resultSet.getFetchSize();
//            topTotal.put("fetchSize", fetchSize);
//            topTotal.put("result set", resultSet.getString(2));
//            partList.add("kolya");
//            partList.add("vasya");
//            partList.add("tolya");
//            topTotal.put(1, partList);
            while (resultSet.next()){
//                resultSet.next();
                org.json.JSONArray partList = new org.json.JSONArray();
                String usrnm = resultSet.getString(2);
                String score = resultSet.getString(3);
                String enemyscore = resultSet.getString(4);
                String result = resultSet.getString(5);
//                String date = resultSet.getString(6);
                Statement playersSt = connection.createStatement();
                ResultSet rsPlayers = playersSt.executeQuery("SELECT playername, origin "
                        + "FROM players "
                        + "WHERE username = \'" + usrnm + "\';"
                );
                String plrnm;
                String orgn;
                if(rsPlayers.next()){
                    plrnm = rsPlayers.getString(1);
                    orgn = rsPlayers.getString(2);

                }else{
                    plrnm = "not";
                    orgn = "got";
                }


                partList.put(usrnm);
                partList.put(plrnm);
                partList.put(orgn);
                partList.put(score);
                partList.put(enemyscore);
                partList.put(result);
//                partList.put(date);

                personalStat.put("" + i++, partList);
                rsPlayers.close();
                playersSt.close();
//                partList.clear();
            }
            personalStat.put("size", i);
            statement.close();
        }catch (SQLException ex){
            ex.printStackTrace();
            classEx += ex.toString();
            personalStat.put("exception", classEx);
        }
        return personalStat;
    }
}
