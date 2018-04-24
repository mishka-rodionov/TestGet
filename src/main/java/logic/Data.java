package logic;

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

    //endregion


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

}
