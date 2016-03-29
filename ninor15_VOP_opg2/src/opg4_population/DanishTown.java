/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opg4_population;

/**
 * VOP eksamen F2014
 * Tom klasse til opgave 4
 *
 * @author erso
 */
public class DanishTown implements Comparable<DanishTown> {
    private String townName;
    private int population2011;
    private int population2012;

    public DanishTown(String townName, int population2011, int population2012) {
        this.townName = townName;
        this.population2011 = population2011;
        this.population2012 = population2012;
    }

    public int getDiff() {
        return population2012 - population2011;
    }

    @Override
    public String toString() {
        return townName + " Diff: " + getDiff() + "\n";
    }

    @Override
    public int compareTo(DanishTown o) {
        if (this.getDiff() == o.getDiff()) {
            return this.getTownName().compareTo(o.getTownName());
        } else {
            if (this.getDiff() > o.getDiff()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public String getTownName() {
        return townName;
    }
}
