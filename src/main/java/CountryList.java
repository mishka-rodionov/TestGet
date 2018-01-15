import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CountryList {

    public static String getCountry(int index){return country.get(index);}

    public static void loading(int size){
        country = new ArrayList<String>(size*size);
        for (int i = 0; i < size*size; i++) {
            country.add(i, countryList[i]);
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
