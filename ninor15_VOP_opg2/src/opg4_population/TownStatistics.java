package opg4_population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

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
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(scanner.nextLine());
                lineScanner.useDelimiter(":");
                lineScanner.nextInt();
                lineScanner.nextInt();
                DanishTown town = new DanishTown(lineScanner.next(),lineScanner.nextInt(),lineScanner.nextInt());
                townList.add(town);

                /*String[] values = scanner.nextLine().split(":");
                townList.add(new DanishTown(values[2],Integer.valueOf(values[3]),Integer.valueOf(values[4])));*/
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No such file");
        }
    }

}
