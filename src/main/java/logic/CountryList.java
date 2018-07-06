package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CountryList {

    public static String getCountry(int index){return country.get(index);}

    public static void loading(int size){
        country = new ArrayList<String>(size);
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        Random rnd = new Random();
        int index;
        for (int i = 0; i < size; i+=2) {
            index = rnd.nextInt(countryList.length - 1);
            while (indexList.contains(index)){
                index = rnd.nextInt(countryList.length - 1);
            }
            indexList.add(index);
//                if(index == countryList.length)
//                    index = 0;
            country.add(i, countryList[index]);
            country.add(i+1, countryList[index]);
        }
    }

    public static void shuffle(){
        Collections.shuffle(country);
    }

    public static ArrayList<String> getCountryList(){ return country; }

    private static ArrayList<String> country;

    private static String[] countryList =
            {
                "Afghanistan",
//                "Aland_Islands",
                "Albania",
                "Algeria",
                "American_Samoa",
                "Andorra",
                "Angola",
                "Anguilla",
                "Antarctica",
                "Antigua_and_Barbuda",
                "Argentina",
                "Armenia",
                "Aruba",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Belarus",
                "Belgium",
                "Belize",
                "Benin",
                "Bermuda",
                "Bhutan",
//                "Biot",
                "Bolivia",
                "Bonaire",
                "Bosnian",
                "Botswana",
//                "Bouvet_Island",
                "Brazil",
//                "British_Antarctic_Territory",
//                "British_Virgin_Islands",
                "Brunei",
                "Bulgaria",
                "Burkina_Faso",
//                "Burma",
                "Burundi",
                "Cambodia",
                "Cameroon",
                "Canada",
                "Cape_Verde",
//                "Cascadia",
                "Cayman_Islands",
                "Central_African_Republic",
                "Chad",
                "Chile",
                "China",
                "Christmas_Island",
                "Cocos_Islands",
                "Colombia",
                "Comoros",
                "Congo",
                "Democratic_Republic_of_the_Congo",
                "Cook_Islands",
                "Costa_Rica",
                "Croatian",
                "Cuba",
                "Curacao",
                "Cyprus",
                "Czech_Republic",
                "Denmark",
                "Djibouti",
                "Dominica",
                "Dominican_Republic",
                "East_Timor",
                "Ecuador",
                "Egypt",
                "El_Salvador",
                "England",
                "Equatorial_Guinea",
                "Eritrea",
                "Estonia",
                "Ethiopia",
                "European_Union",
//                "Ex_Yugoslavia",
                "Falkland_Islands",
                "Faroe_Islands",
                "Fiji",
                "Finland",
                "France",
                "French_Polynesia",
//                "French_Southern_Territories",
                "Gabon",
                "Gambia",
                "Georgia",
                "Germany",
                "Ghana",
                "Gibraltar",
                "Greece",
                "Greenland",
                "Grenada",
//                "Guadeloupe",
                "Guam",
                "Guatemala",
//                "Guernsey",
                "Guinea",
                "Guinea_Bissau",
                "Guyana",
                "Haiti",
//                "Holy_See",
                "Honduras",
                "Hong_Kong",
                "Hungary",
                "Iceland",
                "India",
                "Indonesia",
                "Iran",
                "Iraq",
                "Ireland",
                "Isle_of_Man",
                "Israel",
                "Italy",
                "Ivory_Coast",
                "Jamaica",
//                "Jan_Mayen",
                "Japan",
//                "Jarvis_Island",
//                "Jersey",
                "Jordan",
                "Kazakhstan",
                "Kenya",
                "Kiribati",
                "Kosovo",
                "Kuwait",
                "Kyrgyzstan",
                "Laos",
                "Latvia",
                "Lebanon",
                "Lesotho",
                "Liberia",
                "Libya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
//                "Macau",
                "Macedonia",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Marshall_Islands",
//                "Martinique",
                "Mauritania",
                "Mauritius",
//                "Mayotte",
                "Mexico",
                "Micronesia",
                "Moldova",
                "Monaco",
                "Mongolia",
                "Montenegro",
//                "Montserrat",
                "Morocco",
                "Mozambique",
                "Myanmar",
                "Namibia",
                "Nauru",
                "Nepal",
                "Netherlands",
//                "Netherlands_Antilles",
//                "New_Caledonia",
                "New_Zealand",
                "Nicaragua",
                "Niger",
                "Nigeria",
                "Niue",
                "Norfolk_Island",
                "Northern_Ireland",
                "Northern_Mariana_Islands",
                "North_Korea",
                "Norway",
                "Oman",
                "Pakistan",
                "Palau",
                "Palestinian_Territory",
                "Panama",
                "Papua_New_Guinea",
                "Paraguay",
                "Peru",
                "Philippines",
                "Pitcairn",
                "Poland",
                "Portugal",
                "Puerto_Rico",
                "Qatar",
                "Reunion",
                "Romania",
                "Russia",
                "Rwanda",
                "Saint_Barthelemy",
                "Saint_Helena",
//                "Saint_Helena_and_Dependencies",
                "Saint_Kitts_and_Nevis",
                "Saint_Lucia",
                "Saint_Martin",
                "Saint_Pierre_and_Miquelon",
                "Samoa",
                "San_Marino",
                "Sao_Tome_and_Principe",
                "Saudi_Arabia",
                "Scotland",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra_Leone",
                "Singapore",
                "Sint_Eustatius",
                "Sint_Maarten",
                "Slovakia",
                "Slovenia",
//                "Smom",
                "Solomon_Islands",
                "Somalia",
                "South_Africa",
                "South_Georgia",
                "South_Korea",
                "South_Sudan",
                "Spain",
//                "Spm",
                "Sri_Lanka",
                "Sudan",
                "Suriname",
//                "Svalbard",
                "Saint_Vincent_and_the_Grenadines",
                "Swaziland",
                "Sweden",
                "Switzerland",
                "Syria",
                "Taiwan",
                "Tajikistan",
                "Tanzania",
                "Thailand",
//                "Timor_Leste",
                "Togo",
                "Tokelau",
                "Tonga",
                "Trinidad_and_Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Turks_and_Caicos_Islands",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United_Arab_Emirates",
                "United_Kingdom",
                "United_States",
                "Uruguay",
//                "Ussr",
                "Uzbekistan",
                "Vanuatu",
                "Vatican_City",
                "Venezuela",
                "Vietnam",
//                "Virgin_Islands",
                "Wales",
//                "Wallis_and_Futuna",
//                "Western_Sahara",
                "Yemen",
//                "Yugoslavia",
                "Zambia",
                "Zimbabwe"
            };
}
