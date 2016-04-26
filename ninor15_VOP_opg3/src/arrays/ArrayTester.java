package arrays;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Udleveret klasse erklæring med main() metode til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class ArrayTester {

    private Random generator;
    private static final int MAX = 100;
    private int[] intArray;

    // Udleveret metode, som bytter om på 2 elementer i arrayet.
    // Bør benyttes ved løsning af opg 3d
    public void swap(int fromIndex, int toIndex) {
        int temp = intArray[fromIndex];
        intArray[fromIndex] = intArray[toIndex];
        intArray[toIndex] = temp;
    }
    


    // Udleveret main()-metode til test
    // Fjern ud-kommenteringerne efterhånden som opgaven løses.
    public static void main(String[] args) {
        int size = 30;
        ArrayTester arrayTester = new ArrayTester(size);
        System.out.println("constructor: " + arrayTester);

        arrayTester.sort();
        System.out.println("sorted: " + arrayTester);

        arrayTester.reverse();
        System.out.println("reverse: " + arrayTester);

    }

    public void sort() {
        Arrays.sort(intArray);
    }

    public void reverse() {
        for (int i = 0; i < intArray.length/2; i++) {
            swap(i,intArray.length-1-i);
        }
    }

    public ArrayTester(int size) {
        generator = new Random();
        intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = generator.nextInt(ArrayTester.MAX);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if(i%8 == 0) {
                builder.append("\n");
            }
            builder.append(String.format("%02d, ", intArray[i]));
        }
        builder.append("\n---------------------\n");

        return builder.toString().replace(", \n", "\n");
    }
}
