package BigCitiesAssignment;

import java.io.*;
import java.util.Map;

/**
 * Udvidelse af "opgave i klassen lektion 7, F14 "BigCities"
 * Laves som forberedelse til lektion 8
 *
 * @author erso
 */
public class CityObjectIO {

    private File file;

    public CityObjectIO(String fName) {
        file = new File(fName);
    }

    public static void main(String[] a) {
        CityObjectIO cityObjectIO = new CityObjectIO("CitiesAsObject.obj");
        Map<?, ?> map = cityObjectIO.readObjectfile();
        System.out.println("Map: " + map);
    }

    public void writeObjectFile(Map<?, ?> map) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<?, ?> readObjectfile() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))){
            return (Map<?, ?>) stream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("This file is not a valid big cities object");
    }


}
