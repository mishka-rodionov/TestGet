package logic;

import java.util.ArrayList;

public class BattleField {

    public BattleField(){}

    public BattleField(int size){
        field = new ArrayList<ArrayList<String>>(size);
        int index = 0;
        CountryList.loading(size);
        CountryList.shuffle();
        country = CountryList.getCountryList();
    }

    public static int addBattleField(BattleField battleField){
        battleFields.add(battleField);
        return battleFields.indexOf(battleField);
    }

    public static BattleField getBattleField(int index){
        return battleFields.get(index);
    }

    public String getElement(int firstIndex, int secondIndex){
        return field.get(firstIndex).get(secondIndex);
    }

    public String getElement(int index){
        return country.get(index);
    }

    private final int size6 = 6;
    private final int size8 = 8;
    private String[][] field6x6 = new String[size6][size6];
    private ArrayList<ArrayList<String>> field;
    private ArrayList<String> country;
    private static ArrayList<BattleField> battleFields = new ArrayList<BattleField>();
}
