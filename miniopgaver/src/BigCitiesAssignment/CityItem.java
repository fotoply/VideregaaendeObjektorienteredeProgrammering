package BigCitiesAssignment;

import java.io.Serializable;
import java.util.Arrays;

public class CityItem implements Comparable<CityItem>, Serializable {
    private String city;
    private int population;
    private int range;

    public CityItem(String city, String population, String range) {
        this(city, Integer.valueOf(population), Integer.valueOf(range));
    }

    public CityItem(String city, int population, int range) {
        this.city = city;
        this.population = population;
        this.range = range;
    }

    public static void main(String[] args) {
        // Til test af opgave 3a
        CityItem ci = new CityItem("KOBENHAVN", "499000", "99");
        System.out.println(ci);

        // Til test af opgave 3b
        CityItem[] testArray = new CityItem[3];
        testArray[0] = new CityItem("OSLO", "505000", "97");
        testArray[1] = new CityItem("STOCKHOLM", "744000", "51");
        testArray[2] = new CityItem("KOBENHAVN", "499000", "99");

        // Til test af opgave 3c
        System.out.println("Usorteret:");
        System.out.println(Arrays.toString(testArray));

        Arrays.sort(testArray);
        System.out.println("Sorteret:");
        System.out.println(Arrays.toString(testArray));

    }

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }

    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return String.format("%s: population %d\trange %d", getCity(), getPopulation(), getRange());
    }

    @Override
    public int compareTo(CityItem o) {
        return getCity().compareTo(o.getCity());
    }

}
