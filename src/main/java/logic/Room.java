package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Room {

    public Room(){}

    public Room(String firstPlayer, int battleFieldIndex){
        this.firstPlayer = firstPlayer;
        this.battleFieldIndex = battleFieldIndex;
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

    private String firstPlayer;
    private String secondPlayer;
    private String firstPlayerAddress;
    private String secondPlayerAddress;
    private String roomName;
    private int battleFieldIndex;
    private static HashMap<String, Integer> roomNameList = new HashMap<String, Integer>();
    private static ArrayList<Room> rooms = new ArrayList<Room>();
}
