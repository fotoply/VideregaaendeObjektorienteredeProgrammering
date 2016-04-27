package urban_population;

/**
 * @author fotoply
 */
public class UrbanPopulation implements Comparable<UrbanPopulation> {

    private String name;
    private int populationPercentage1980;
    private int populationPercentage2008;

    public UrbanPopulation(String name, int populationPercentage1980, int populationPercentage2008) {
        this.name = name;
        this.populationPercentage1980 = populationPercentage1980;
        this.populationPercentage2008 = populationPercentage2008;
    }

    @Override
    public String toString() {
        return String.format("%s: \t1980: %02d \t2008: %02d \tDiff: %02d", name, populationPercentage1980, populationPercentage2008, getDiff());
    }

    private int getDiff() {
        return populationPercentage2008-populationPercentage1980;
    }

    @Override
    public int compareTo(UrbanPopulation o) {
        if(getDiff() == 0) {
            return name.compareTo(o.name);
        }
        return Integer.compare(getDiff(), o.getDiff());
    }


}
