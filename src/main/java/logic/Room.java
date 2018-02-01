package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Room {

    public Room(){}

    public Room(String firstPlayer, int battleFieldIndex){
        this.firstPlayer = firstPlayer;
        this.battleFieldIndex = battleFieldIndex;
        this.changeSecondPlayer = false;
        this.stepCount = 0;
        this.firstPlayerStep = true;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
        this.changeSecondPlayer = true;
    }

    public String getFirstPlayerAddress() {
        return firstPlayerAddress;
    }

    public void setFirstPlayerAddress(String firstPlayerAddress) {
        this.firstPlayerAddress = firstPlayerAddress;
    }

    public String getSecondPlayerAddress() {
        return secondPlayerAddress;
    }

    public void setSecondPlayerAddress(String secondPlayerAddress) {
        this.secondPlayerAddress = secondPlayerAddress;
    }

    public int getBattleFieldIndex() {
        return battleFieldIndex;
    }

    public void setBattleFieldIndex(int battleFieldIndex) {
        this.battleFieldIndex = battleFieldIndex;
    }

    public static void setElement(String key, Integer value){
        roomNameList.put(key, value);
    }
    public static Set getElement(){
        return roomNameList.keySet();
    }

    public static int addRoom(Room room){
        rooms.add(room);
        return rooms.indexOf(room);
    }

    public static Room getRoom(int index){
        return rooms.get(index);
    }

    public boolean isChangeSecondPlayer() {
        return changeSecondPlayer;
    }

    public void setChangeSecondPlayer(boolean changeSecondPlayer) {
        this.changeSecondPlayer = changeSecondPlayer;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isFirstPlayerStep() {
        return firstPlayerStep;
    }

    public void setFirstPlayerStep(boolean firstPlayerStep) {
        this.firstPlayerStep = firstPlayerStep;
    }

    public boolean isSecondPlayerStep() {
        return secondPlayerStep;
    }

    public void setSecondPlayerStep(boolean secondPlayerStep) {
        this.secondPlayerStep = secondPlayerStep;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void addStepCount() {
        this.stepCount++;
    }

    public void resetStepCount(){
        stepCount = 0;
    }

    private String firstPlayer;
    private String secondPlayer;
    private String firstPlayerAddress;
    private String secondPlayerAddress;
    private int rowIndex;
    private int columnIndex;
    private String country;
    private boolean firstPlayerStep;
    private boolean secondPlayerStep;
    private int stepCount;
    private String roomName;
    private int battleFieldIndex;
    private boolean changeSecondPlayer;
    private static HashMap<String, Integer> roomNameList = new HashMap<String, Integer>();
    private static ArrayList<Room> rooms = new ArrayList<Room>();
}
