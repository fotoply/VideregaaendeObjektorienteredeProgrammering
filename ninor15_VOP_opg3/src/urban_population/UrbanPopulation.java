package urban_population;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulation implements Comparable<UrbanPopulation> {

    private String name;
    private int populationPercentage1980;
    private int populationPercentage2008;

    @Override
    public String toString() {
        return String.format("%s: \t1980: %02d \t2008: %02d \tDiff: %02d", name, populationPercentage1980, populationPercentage2008, getDiff());
    }

    private int getDiff() {
        return populationPercentage2008-populationPercentage1980;
    }

    @Override
    public int compareTo(UrbanPopulation o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
