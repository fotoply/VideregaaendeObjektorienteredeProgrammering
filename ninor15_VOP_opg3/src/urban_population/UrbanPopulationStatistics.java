package urban_population;

import java.io.File;
import java.util.Set;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulationStatistics {

    private Set<UrbanPopulation> popSet;
    private File file;

    public UrbanPopulationStatistics(String fileName) {
        // Initialisering af variable

        readFile();
    }

    //Udleveret test-metode
    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("ByBefolkning.txt");
        System.out.println(stats);
    }

    private void readFile() {
        // Til indlæsning af data fra file,
        // dannelse af objekter af klassen UrbanPopulation
        // og indsættelse af disse i popSet
    }

    // Udleveret toString() metode, som giver en "pæn" formatering.
    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

}
