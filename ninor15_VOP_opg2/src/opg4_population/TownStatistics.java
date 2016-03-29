package opg4_population;

import java.util.List;

/**
 * VOP eksamen F2014
 * Kodeskelet til opg 4b
 *
 * @author erso
 */
public class TownStatistics {

    private List<DanishTown> townList;

    public TownStatistics() {

    }

    public static void main(String[] args) {
        TownStatistics ts = new TownStatistics();
        ts.readFile("Befolkning.txt");
        System.out.println("Unsorted " + ts);
        ts.sort();
        System.out.println("Sorted " + ts);

    }

    @Override
    public String toString() {
        String s = townList.toString();
        return "TownStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

    public void sort() {

    }

    public void readFile(String fileName) {

    }

}
