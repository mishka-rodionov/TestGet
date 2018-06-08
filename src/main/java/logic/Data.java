package logic;

import java.util.Date;

public class Data {

    //region getters

    public static String getFirstPlayerNumber() {
        return firstPlayerNumber;
    }

    public static String getSecondPlayerNumber() {
        return secondPlayerNumber;
    }

    public static String getPlayerNameLabel() {
        return playerNameLabel;
    }

    public static String getUsernameLabel() {
        return usernameLabel;
    }

    public static String getSizeLabel() {
        return sizeLabel;
    }

    public static String getOriginLabel() {
        return originLabel;
    }

    public static String getRoomIndexLabel() {
        return roomIndexLabel;
    }

    public static String getActiveStepLabel() {
        return activeStepLabel;
    }

    public static String getActivePlayerLabel() {
        return activePlayerLabel;
    }

    public static String getMistakeLabel() {
        return mistakeLabel;
    }

    public static String getSendStart() {
        return sendStart;
    }

    public static String getSendFinish() {
        return sendFinish;
    }

    public static String getReadStart() {
        return readStart;
    }

    public static String getReadFinish() {
        return readFinish;
    }

    public static String getStep1() {
        return step1;
    }

    public static String getStep2() {
        return step2;
    }

    //endregion

    //region setters

    public static void setSecondPlayerNumber(String secondPlayerNumber) {
        Data.secondPlayerNumber = secondPlayerNumber;
    }

    public static void setFirstPlayerNumber(String firstPlayerNumber) {
        Data.firstPlayerNumber = firstPlayerNumber;
    }

    public static void setActiveStepLabel(String activeStepLabel) {
        Data.activeStepLabel = activeStepLabel;
    }

    public static void setPlayerNameLabel(String playerNameLabel) {
        Data.playerNameLabel = playerNameLabel;
    }

    public static void setUsernameLabel(String usernameLabel) {
        Data.usernameLabel = usernameLabel;
    }

    public static void setSizeLabel(String sizeLabel) {
        Data.sizeLabel = sizeLabel;
    }

    public static void setOriginLabel(String originLabel) {
        Data.originLabel = originLabel;
    }

    public static void setRoomIndexLabel(String roomIndexLabel) {
        Data.roomIndexLabel = roomIndexLabel;
    }

    public static void setActivePlayerLabel(String activePlayerLabel) {
        Data.activePlayerLabel = activePlayerLabel;
    }

    public static void setMistakeLabel(String mistakeLabel) {
        Data.mistakeLabel = mistakeLabel;
    }

    public static void setSendStart(String sendStart) {
        Data.sendStart = sendStart;
    }

    public static void setSendFinish(String sendFinish) {
        Data.sendFinish = sendFinish;
    }

    public static void setReadStart(String readStart) {
        Data.readStart = readStart;
    }

    public static void setReadFinish(String readFinish) {
        Data.readFinish = readFinish;
    }

    public static void setStep1(String step1) {
        Data.step1 = step1;
    }

    public static void setStep2(String step2) {
        Data.step2 = step2;
    }

    //endregion


    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Data.type = type;
    }

    public static String getStep() {
        return step;
    }

    public static void setStep(String step) {
        Data.step = step;
    }

    public static String getSend() {
        return send;
    }

    public static void setSend(String send) {
        Data.send = send;
    }

    public static String getReceive() {
        return receive;
    }

    public static void setReceive(String receive) {
        Data.receive = receive;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Data.playerName = playerName;
    }

    public static int getXsmallSize() {
        return xsmallSize;
    }

    public static void setXsmallSize(int xsmallSize) {
        Data.xsmallSize = xsmallSize;
    }

    public static int getSmallSize() {
        return smallSize;
    }

    public static void setSmallSize(int smallSize) {
        Data.smallSize = smallSize;
    }

    public static int getMediumSize() {
        return mediumSize;
    }

    public static void setMediumSize(int mediumSize) {
        Data.mediumSize = mediumSize;
    }

    public static int getLargeSize() {
        return largeSize;
    }

    public static void setLargeSize(int largeSize) {
        Data.largeSize = largeSize;
    }

    public static int getXlargeSize() {
        return xlargeSize;
    }

    public static void setXlargeSize(int xlargeSize) {
        Data.xlargeSize = xlargeSize;
    }

    public static int getXxlargeSize() {
        return xxlargeSize;
    }

    public static void setXxlargeSize(int xxlargeSize) {
        Data.xxlargeSize = xxlargeSize;
    }

    public static String getUrlDB() {
        return urlDB;
    }

    public static void setUrlDB(String urlDB) {
        Data.urlDB = urlDB;
    }

    public static String getUserDB() {
        return userDB;
    }

    public static void setUserDB(String userDB) {
        Data.userDB = userDB;
    }

    public static String getPasswordDB() {
        return passwordDB;
    }

    public static void setPasswordDB(String passwordDB) {
        Data.passwordDB = passwordDB;
    }

    public static String getPlayersTable() {
        return playersTable;
    }

    public static void setPlayersTable(String playersTable) {
        Data.playersTable = playersTable;
    }

    public static String getTotalTable() {
        return totalTable;
    }

    public static void setTotalTable(String totalTable) {
        Data.totalTable = totalTable;
    }

    public static String getSchema() {
        return schema;
    }

    public static void setSchema(String schema) {
        Data.schema = schema;
    }

    public static String getCurrentDate(){
        return new Date().toString();
    }

    public static String getVirgin() {
        return virgin;
    }

    public static void setVirgin(String virgin) {
        Data.virgin = virgin;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Data.username = username;
    }

    public static String getEnemyUsername() {
        return enemyUsername;
    }

    public static void setEnemyUsername(String enemyUsername) {
        Data.enemyUsername = enemyUsername;
    }

    public static String getEnemyPlayername() {
        return enemyPlayername;
    }

    public static void setEnemyPlayername(String enemyPlayername) {
        Data.enemyPlayername = enemyPlayername;
    }

    public static String getEnemyOrigin() {
        return enemyOrigin;
    }

    public static void setEnemyOrigin(String enemyOrigin) {
        Data.enemyOrigin = enemyOrigin;
    }

    public static String getEnemyScore() {
        return enemyScore;
    }

    public static void setEnemyScore(String enemyScore) {
        Data.enemyScore = enemyScore;
    }

    public static String getScore() {
        return score;
    }

    public static void setScore(String score) {
        Data.score = score;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        Data.result = result;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Data.date = date;
    }

    public static String getOnline() {
        return online;
    }

    public static void setOnline(String online) {
        Data.online = online;
    }

    private static String firstPlayerNumber = "firstPlayer";
    private static String secondPlayerNumber = "secondPlayer";
    private static String playerNameLabel = "playerName";
    private static String usernameLabel = "user";
    private static String sizeLabel = "size";
    private static String originLabel = "origin";
    private static String roomIndexLabel = "roomIndex";
    private static String activeStepLabel = "activeStep";
    private static String activePlayerLabel = "activePlayer";
    private static String mistakeLabel = "mistake";
    private static String sendStart = "sendStart";
    private static String sendFinish = "sendFinish";
    private static String readStart = "readStart";
    private static String readFinish = "readFinish";
    private static String step1 = "step1";
    private static String step2 = "step2";
    private static String playerName = "playerName";
    private static String type = "type";
    private static String step = "step";
    private static String send = "send";
    private static String receive = "receive";
    private static String virgin = "virgin";
    private static String username = "username";
    private static String enemyUsername = "enemyUsername";
    private static String enemyPlayername = "enemyPlayername";
    private static String enemyOrigin = "enemyOrigin";
    private static String enemyScore = "enemyScore";
    private static String score = "score";
    private static String result = "result";
    private static String date = "date";
    private static String online = "online";

    //region DB
    private static String urlDB = "jdbc:postgresql://localhost:5432/flagmem";
    private static String userDB = "mishka";
    private static String passwordDB = "mashka17";
    private static String playersTable = "players";
    private static String totalTable = "total";
    private static String schema = "public";
    //endregion

    private static int xsmallSize = 8;
    private static int smallSize = 12;
    private static int mediumSize = 16;
    private static int largeSize = 24;
    private static int xlargeSize = 30;
    private static int xxlargeSize = 36;

}
