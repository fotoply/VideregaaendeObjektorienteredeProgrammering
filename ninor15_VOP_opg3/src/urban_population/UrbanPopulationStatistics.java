package urban_population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author fotoply
 */
public class UrbanPopulationStatistics {

    private Set<UrbanPopulation> popSet;
    private File file;

    public UrbanPopulationStatistics(String fileName) {
        popSet = new TreeSet<>();
        file = new File(fileName);
        readFile();
    }

    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("ByBefolkning.txt");
        System.out.println(stats);
    }

    private void readFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] inputs = scanner.nextLine().split("/");

                String name = inputs[0];
                int pop1980 = Integer.parseInt(inputs[1]);
                int pop2008 = Integer.parseInt(inputs[4]);

                popSet.add(new UrbanPopulation(name, pop1980, pop2008));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

}
