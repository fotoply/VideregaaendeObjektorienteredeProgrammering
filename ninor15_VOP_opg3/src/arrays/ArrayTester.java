package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author fotoply
 */
public class ArrayTester {

    private static final int MAX = 100;
    private static Random generator = new Random();
    private int[] intArray;

    public ArrayTester(int size) {
        intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = generator.nextInt(ArrayTester.MAX);
        }
    }

    public static void main(String[] args) {
        int size = 30;
        ArrayTester arrayTester = new ArrayTester(size);
        System.out.println("constructor: " + arrayTester);

        arrayTester.sort();
        System.out.println("sorted: " + arrayTester);

        arrayTester.reverse();
        System.out.println("reverse: " + arrayTester);
    }

    private void swap(int fromIndex, int toIndex) {
        int temp = intArray[fromIndex];
        intArray[fromIndex] = intArray[toIndex];
        intArray[toIndex] = temp;
    }

    public void sort() {
        Arrays.sort(intArray);
    }

    public void reverse() {
        for (int i = 0; i < intArray.length / 2; i++) {
            swap(i, intArray.length - 1 - i);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i % 8 == 0) {
                builder.append("\n");
            }
            builder.append(String.format("%02d, ", intArray[i]));
        }
        builder.append("\n---------------------\n");

        return builder.toString().replace(", \n", "\n");
    }
}
