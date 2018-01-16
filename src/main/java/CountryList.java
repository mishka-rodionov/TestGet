import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CountryList {

    public static String getCountry(int index){return country.get(index);}

    public static void loading(int size){
        country = new ArrayList<String>(size*size);
        Random rnd = new Random();
        int index = rnd.nextInt(countryList.length);
        for (int i = 0; i < size*size; i++) {
            if(i % 2 != 0){
                country.add(i, countryList[index]);
                index++;
                if(index == countryList.length)
                    index = 0;
            }
            else
                country.add(i, countryList[index]);
        }
    }

    public static void shuffle(){
        Collections.shuffle(country);
    }

    private static ArrayList<String> country;

    private static String[] countryList = {
            "Albania",
            "Andorra",
            "Armenia",
            "Austria",
            "Azerbaijan",
            "Belarus",
            "Belgium",
            "Bosnia and Herzegovina",
            "Bulgaria",
            "Croatia",
            "Cyprus",
            "Czech Republic",
            "Denmark",
            "Estonia",
            "Finland",
            "France",
            "Georgia",
            "Germany",
            "Greece",
            "Hungary",
            "Iceland",
            "Ireland",
            "Italy",
            "Kazakhstan",
            "Kosovo",
            "Latvia",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macedonia",
            "Malta",
            "Moldova",
            "Monaco",
            "Montenegro",
            "Netherlands",
            "Norway",
            "Poland",
            "Portugal",
            "Romania",
            "Russia",
            "San Marino",
            "Serbia",
            "Slovakia",
            "Slovenia",
            "Spain",
            "Sweden",
            "Switzerland",
            "Turkey",
            "Ukraine",
            "United Kingdom",
            "Vatican"};

}
