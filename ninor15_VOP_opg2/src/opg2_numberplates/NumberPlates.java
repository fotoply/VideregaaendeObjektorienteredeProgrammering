package opg2_numberplates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds

    private VehicleType[] vehicleTypes = {      // Intervaller for anvendelse
            new VehicleType("Motorcykel", 10000, 19999),
            new VehicleType("Privat personvogn", 20000, 45999),
            new VehicleType("Udlejningsvogn", 46000, 46999),
            new VehicleType("Hyrevogn", 47000, 48999),
            new VehicleType("Skolevogn", 49000, 49899),
            new VehicleType("Ambulance el. lign.", 49900, 49999),
            new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        districtMap = new HashMap<>();
        readFile();
    }

    public static void main(String[] arg) {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN90022: " + pd.validate("EN90022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

    public void readFile() {
        try {
            Scanner scanner = new Scanner(new File("Nummerplader.txt"));
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(":");
                districtMap.put(values[0].toLowerCase(), values[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No such file");
        }
    }

    public String validate(String plate) {
        if (plate.length() != 7) {
            return "Error: Incorrect length";
        }
        String area = validateDistrict(plate.substring(0, 2));
        String type = validateVehicleType(Integer.valueOf(plate.substring(2, 7)));

        return type + " from " + area;

    }

    private String validateDistrict(String districtCode) {
        String area = districtMap.get(districtCode.toLowerCase());
        if (area != null) {
            return area;
        } else {
            return "Area not found";
        }
    }

    private String validateVehicleType(int number) {
        for (VehicleType type : vehicleTypes) {
            if (type.isA(number)) {
                return type.getVehicleType();
            }
        }
        return "Bad plate ID: " + number;
    }

}
