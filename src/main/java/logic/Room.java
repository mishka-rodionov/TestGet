package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Room {

    public Room(){}

    public Room(String firstPlayer, int battleFieldSize, String firstPlayerOrigin,
                String firstPlayerUsername){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = null;
        this.battleFieldSize = battleFieldSize;
        this.firstPlayerOrigin = firstPlayerOrigin;
        this.firstPlayerUsername = firstPlayerUsername;
        this.readFlag = false;
        this.stepCount = 0;
        this.removingRoom = false;

        this.battleField = new BattleField(battleFieldSize);
        this.battleFieldIndex = BattleField.addBattleField(battleField);
        this.steps = new ArrayList<Integer>();
//        this.steps.add(dummy);
//        this.steps.add(dummy);

        this.country = "dummy";
    }

    //region getters

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public Integer getStepsSize(){
        return steps.size();
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public String getFirstPlayerUsername() {
        return firstPlayerUsername;
    }

    public int getBattleFieldSize() {
        return battleFieldSize;
    }

    public String getSecondPlayerOrigin() {
        return secondPlayerOrigin;
    }

    public String getFirstPlayerOrigin() {
        return firstPlayerOrigin;
    }

    public String getSecondPlayerUsername() {
        return secondPlayerUsername;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public String getFirstPlayerAddress() {
        return firstPlayerAddress;
    }

    public String getSecondPlayerAddress() {
        return secondPlayerAddress;
    }

    public int getBattleFieldIndex() {
        return battleFieldIndex;
    }

    public static Set getElement(){
        return roomNameList.keySet();
    }

    public static Room getRoom(int index){
        return rooms.get(index);
    }

    public static int getRoomsSize() { return rooms.size(); }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public String getCountry() {
        return country;
    }

    public int getStepCount() {
        return stepCount;
    }

    public boolean isPlayerSend() {
        return playerSend;
    }

    public boolean isReadFlag() {
        return readFlag;
    }

    public boolean isFirstPlayerActive() {
        return firstPlayerActive;
    }

    public boolean isSecondPlayerActive() {
        return secondPlayerActive;
    }

    public boolean isChangeSecondPlayer() {
        return changeSecondPlayer;
    }

    public boolean isMistake() {
        return mistake;
    }

    public Integer getValue(int index){
        return steps.get(index);
    }

//    public Boolean getSendStart() {
//        return sendStart;
//    }
//
//    public Boolean getSendFinish() {
//        return sendFinish;
//    }
//
//    public Boolean getReadStart() {
//        return readStart;
//    }
//
//    public Boolean getReadFinish() {
//        return readFinish;
//    }

    //endregion

    //region setters

    public void setSecondPlayerActive(boolean secondPlayerActive) {
        this.secondPlayerActive = secondPlayerActive;
    }

    public void setPlayerSend(boolean playerSend) {
        this.playerSend = playerSend;
    }

    public void setReadFlag(boolean readFlag) {
        this.readFlag = readFlag;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public void setFirstPlayerUsername(String firstPlayerUsername) {
        this.firstPlayerUsername = firstPlayerUsername;
    }

    public void setSecondPlayerUsername(String secondPlayerUsername) {
        this.secondPlayerUsername = secondPlayerUsername;
    }

    public void setFirstPlayerOrigin(String firstPlayerOrigin) {
        this.firstPlayerOrigin = firstPlayerOrigin;
    }

    public void setSecondPlayerOrigin(String secondPlayerOrigin) {
        this.secondPlayerOrigin = secondPlayerOrigin;
    }

    public void setBattleFieldSize(int battleFieldSize) {
        this.battleFieldSize = battleFieldSize;
    }

    public void setFirstPlayerActive(boolean firstPlayerActive) {
        this.firstPlayerActive = firstPlayerActive;
    }

    public void setChangeSecondPlayer(boolean changeSecondPlayer) {
        this.changeSecondPlayer = changeSecondPlayer;
    }

    public void setSecondPlayerAddress(String secondPlayerAddress) {
        this.secondPlayerAddress = secondPlayerAddress;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
        this.changeSecondPlayer = true;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setFirstPlayerAddress(String firstPlayerAddress) {
        this.firstPlayerAddress = firstPlayerAddress;
    }

    public void setBattleFieldIndex(int battleFieldIndex) {
        this.battleFieldIndex = battleFieldIndex;
    }

    public static void setElement(String key, Integer value){
        roomNameList.put(key, value);
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMistake(boolean mistake) {
        this.mistake = mistake;
    }

//    public void setSendStart(Boolean sendStart) {
//        this.sendStart = sendStart;
//    }
//
//    public void setSendFinish(Boolean sendFinish) {
//        this.sendFinish = sendFinish;
//    }
//
//    public void setReadStart(Boolean readStart) {
//        this.readStart = readStart;
//    }
//
//    public void setReadFinish(Boolean readFinish) {
//        this.readFinish = readFinish;
//    }

    //endregion

    public void addStepCount() {
        this.stepCount++;
    }

    public static int addRoom(Room room){
        Boolean emptySpace = false;
        if (rooms.size() > 0){
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) == null){
                    rooms.add(i, room);
                    break;
                }
                if (i == (rooms.size() - 1)){
                    emptySpace = true;
                }
            }
        }else{
            rooms.add(room);
        }

        if (emptySpace){
            rooms.add(room);
        }

        return rooms.indexOf(room);
    }

    public static void removeRoom(int index){
        rooms.get(index).setRemovingRoom(true);/*rooms.remove(index)*/
    }

    public void addStep(int index){
        steps.add(index);
    }

    public void clearSteps(){ steps.clear(); }

    public void clearStepCount(){ stepCount = 0; }

    public void resetStepCount(){
        stepCount = 0;
    }

    public boolean isRemovingRoom() {
        return removingRoom;
    }

    public void setRemovingRoom(boolean removingRoom) {
        this.removingRoom = removingRoom;
    }

    private String firstPlayer;
    private String firstPlayerUsername;
    private String secondPlayer;
    private String secondPlayerUsername;
    private String firstPlayerAddress;
    private String secondPlayerAddress;
    private String country;
    private String firstPlayerOrigin;
    private String secondPlayerOrigin;
    private String roomName;

    private boolean firstPlayerActive;
    private boolean secondPlayerActive;
    private boolean changeSecondPlayer;
    private boolean playerSend;
    private boolean readFlag;
    private boolean mistake;
    private boolean removingRoom;

//    private Boolean sendStart;
//    private Boolean sendFinish;
//    private Boolean readStart;
//    private Boolean readFinish;

    private int stepCount;
    private int rowIndex;
    private int columnIndex;
    private int battleFieldIndex;
    private int battleFieldSize;
    private int dummy = -1;

    private BattleField battleField;

    private static HashMap<String, Integer> roomNameList = new HashMap<String, Integer>();
    private static List<Room> rooms = new ArrayList<Room>();
    private List<Integer> steps;
}
