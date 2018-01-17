import java.io.PrintWriter;
import java.util.ArrayList;

public class BattleField {

    public BattleField(){}

    public BattleField(int size, PrintWriter out){
        field = new ArrayList<ArrayList<String>>(size);
        int index = 0;
        CountryList.loading(size);
        CountryList.shuffle();
        try {
            for (int i = 0; i < size; i++) {
                ArrayList<String> temp = new ArrayList<String>(size);
                field.add(temp);
                for (int j = 0; j < size; j++) {
                    field.get(i).add(CountryList.getCountry(index++));
                }
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace(out);
            out.println();
        }
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

    private final int size6 = 6;
    private final int size8 = 8;
    private String[][] field6x6 = new String[size6][size6];
    private ArrayList<ArrayList<String>> field;
    private static ArrayList<BattleField> battleFields = new ArrayList<BattleField>();
}
