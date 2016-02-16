import java.util.Arrays;
import java.util.Random;

/**
 * Created 2/16/16
 *
 * @author Niels Norberg
 */
public class SortByEvenOdd {

    public static void main(String[] args) {

        Random generator = new Random(222);
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:" + Arrays.toString(array));

        SortByEvenOdd arrMani = new SortByEvenOdd();
        int result[] = arrMani.evenOdd(array);
        System.out.println("Output: " + Arrays.toString(result));
    }

    public int[] evenOdd(int[] array) {
        int minPos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                IntegerSorter.swap(array, minPos, i);
                minPos++;
            }
        }
        sort(array, minPos);
        return array;
    }

    private void sort(int[] array, int splitIndex) {
        IntegerSorter.sortAscending(array, 0, splitIndex);
        IntegerSorter.sortDescending(array, splitIndex, array.length);
    }
}
