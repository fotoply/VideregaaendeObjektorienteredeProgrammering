package BigCitiesAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BigCities {

    private Map<String, Set<CityItem>> countryMap;

    public BigCities(String fileName) {
        countryMap = new TreeMap<>();
        readFile(fileName);
    }

    private void readFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(";");
                if (values.length != 4) {
                    continue;
                }
                CityItem newCity = new CityItem(values[1],values[3],values[0]);
                if(!countryMap.containsKey(values[2])) {
                    countryMap.put(values[2], new TreeSet<>());
                }
                countryMap.get(values[2]).add(newCity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No such file");
        }
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
