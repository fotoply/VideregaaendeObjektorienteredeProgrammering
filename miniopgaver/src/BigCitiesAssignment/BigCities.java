package BigCitiesAssignment;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BigCities {

    private Map<String, Set<CityItem>> countryMap;

    public BigCities(String fileName) {
        countryMap = new TreeMap<>();
        readFile(fileName);
    }

    private void readFile(String fileName) {
        // Indlaes fra filen til mappen
    }

    public Map<String, Set<CityItem>> getCountryMap() {
        
        return countryMap;
    }

    public String toString() {
        return countryMap.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        BigCities bc = new BigCities("Biggest100Cities.txt");
        System.out.println(bc);
        
        // Udvidelse til lektion 8:
//        CityObjectIO coio = new CityObjectIO("CitiesAsObject.obj");
//        coio.writeObjectFile(bc.getCountryMap());


    }

}
